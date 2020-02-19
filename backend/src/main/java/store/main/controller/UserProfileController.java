package store.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.ImageService;

@Controller
public class UserProfileController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ImageService imgService;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}
	
	
	@GetMapping("/public_profile")
	public String loadPublicProfile(Model model, HttpServletRequest request) {
		User u = getUserInfo(request);
		for(int i=0;i<6;i++)
			model.addAttribute("stars"+i,ratingRepository.findBySellerEmailIgnoreCaseAndStars(u.getEmail(), i).size());

		List<Post> lp = postRepository.findFirst8ByUserEmail(u.getEmail());
		model.addAttribute("user", u);
		model.addAttribute("itemList",lp);
		return "seller-profile";
	}
	
	@GetMapping("/account_settings")
	public String loadAcountSettings(Model model, HttpServletRequest request) {
		User u = getUserInfo(request);
		model.addAttribute("user", u);
		return "account-profile";
	}

	@PostMapping("/profile/updated")
	public String nuevoAnuncio(Model model, User user,
			@RequestParam MultipartFile imagenFile, HttpServletRequest request) throws IOException {
		
		User u = getUserInfo(request);
		u.setFirstName(user.getfirstName());
		u.setLastName(user.getLastName());
		u.setBCryptPassword(user.getPassword());
		u.setPhone(user.getPhone());
		u.setUserAddress(u.getUserAddress());
		userRepository.save(u);
		
		if(!imagenFile.getOriginalFilename().equals("")) 
				imgService.saveImage("users", u.getId(), imagenFile, null);
				
		return "redirect:/";
	}
}
