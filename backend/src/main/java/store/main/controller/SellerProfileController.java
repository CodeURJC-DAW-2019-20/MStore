package store.main.controller;

import java.util.LinkedList;
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

import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.CartService;
import store.main.service.GraphicService;
import store.main.service.LoaderService;
import store.main.service.RatingService;

@Controller
public class SellerProfileController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingService ratingService;

	@Autowired
	private GraphicService graphicService;
	
	@Autowired
	private CartService cService;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private LoaderService loaderService;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}

	@GetMapping("/public_profile/{id}")
	public String loadPublicProfile(Model model, HttpServletRequest request, @PathVariable("id") long id,
			HttpSession session) {
		loadPublicProfile(model, request, id);
		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model);
		cService.LoadNotProduct(model, session);
		return "seller-public-profile";
	}

	private void loadPublicProfile(Model model, HttpServletRequest request, long id) {
		Optional<User> u = userRepository.findById(id);
		List<Integer> l = graphicService.createGraph(u.get());

		for (int i = 0; i < 6; i++)
			model.addAttribute("stars" + i,l.get(i));

		List<Post> lp = postRepository.findFirst8ByUserEmail(u.get().getEmail());
		model.addAttribute("u", u.get());
		model.addAttribute("itemList", lp);

		if (request.isUserInRole("USER") || request.isUserInRole("ADMIN")) {
			User user = getUserInfo(request);
			model.addAttribute("hasSold", user.getSellers().contains(u.get()));
			model.addAttribute("idBuyer", user.getId());
		} else {
			model.addAttribute("hasSold", false);
		}
	}

	@PostMapping("/public_profile/{idSeller}/{idBuyer}")
	public String saveRating(Model model, @RequestParam String stars, @PathVariable("idSeller") long idSeller,
			@PathVariable("idBuyer") long idBuyer, HttpSession session, HttpServletRequest request) {
		ratingService.saveRating(stars, idSeller, idBuyer);
		String out = "redirect:/public_profile/" + idSeller;
		return out;
	}

	
}
