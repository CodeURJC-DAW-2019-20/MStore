package store.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.Rating;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.CartService;
import store.main.service.ImageService;

@Controller
public class SellerProfileController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private PostRepository postRepository;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}
	
	
	@GetMapping("/public_profile/{id}")
	public String loadPublicProfile(Model model, HttpServletRequest request, 
			@PathVariable("id") long id, HttpSession session) {
		loadPublicProfile(model, request, id);
		cService.Load(model, session, id);
		return "seller-public-profile";
	}
	
	private void loadPublicProfile(Model model, HttpServletRequest request, long id) {
		Optional<User> u = userRepository.findById(id);
		
		for(int i=0;i<6;i++)
			model.addAttribute("stars"+i,ratingRepository.findBySellerEmailIgnoreCaseAndStars(u.get().getEmail(), i).size());

		List<Post> lp = postRepository.findFirst8ByUserEmail(u.get().getEmail());
		model.addAttribute("user", u.get());
		model.addAttribute("itemList",lp);
		
		if(request.isUserInRole("USER") || request.isUserInRole("ADMIN")) {
			User user = getUserInfo(request);
			model.addAttribute("hasSold",user.getSellers().contains(u.get()));
			model.addAttribute("idBuyer",user.getId());
		}else {
			model.addAttribute("hasSold",false);
		}
	}
	
	@PostMapping("/public_profile/{idSeller}/{idBuyer}")
	public String saveRating(Model model, @RequestParam String stars,
			@PathVariable("idSeller") long idSeller, @PathVariable("idBuyer") long idBuyer, HttpSession session) {
		saveRating(model, stars, idSeller, idBuyer);
		cService.LoadNotProduct(model, session);
		return ("redirect:/public_profile/"+idSeller);
	}
	
	private void saveRating(Model model, String stars, long idSeller, long idBuyer) {
		Optional<User> us = userRepository.findById(idSeller);
		Optional<User> ub = userRepository.findById(idBuyer);
		
		Rating r = new Rating(Integer.parseInt(stars));
		r.setSeller(us.get());
		r.setBuyer(ub.get());
		ratingRepository.save(r);
		
		ub.get().getSellers().remove(us.get());
		userRepository.save(ub.get());
	}
}
