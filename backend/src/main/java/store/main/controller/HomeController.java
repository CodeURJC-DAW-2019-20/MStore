package store.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.HomeLoader;

//HomeController is a class that handles the events of the MStore home page. Upload the names, prices and images of user posts.
@Controller
public class HomeController {

	@Autowired
	private HomeLoader hLoader;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/") // main page
	public String loadHome(Model model, HttpServletRequest request) {
		
		model = hLoader.modelLoader(model);
		
		if (request.getUserPrincipal() != null) {
			
			User user = userRepository.findByEmail(request.getUserPrincipal().getName());
			
			model.addAttribute("logged", true);
			model.addAttribute("user", user);
			
		} else {
			model.addAttribute("logged", false);
		}
		
		return "index";
	}

}
