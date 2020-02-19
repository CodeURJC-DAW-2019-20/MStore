package store.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import store.main.database.User;
import store.main.database.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("error", false);
		return "login";
	}

	@GetMapping("/loginerror")
	public String loginerror(Model model) {

		model.addAttribute("error", true);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "index";
	}

	@PostMapping("/register")
	public String register(Model model, User user, HttpServletRequest request) {

		User registeredUser = userRepository.findByEmail(user.getEmail());

		if (registeredUser != null) {
			model.addAttribute("registered", true);
			return "login";
		}

		user.getRoles().add("ROLE_USER");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		userRepository.save(user);
		
		autoLogin(user, request);
		
		return "redirect:/";
	}
	
    private void autoLogin(User user, HttpServletRequest request) {
    	
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
        
        UsernamePasswordAuthenticationToken authenticationToken = 
        		new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), roles);
        
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        
    }

}
