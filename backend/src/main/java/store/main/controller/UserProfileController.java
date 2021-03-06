package store.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import store.main.service.CartService;
import store.main.service.GraphicService;
import store.main.service.ImageService;
import store.main.service.LoaderService;
import store.main.service.UserService;

@Controller
public class UserProfileController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private GraphicService graphicService;

	@Autowired
	private CartService cService;

	@Autowired
	private ImageService imgService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoaderService loaderService;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}

	@GetMapping("/public_profile")
	public String loadPublicProfile(Model model, HttpServletRequest request, HttpSession session) {
		
		User u = getUserInfo(request);
		List<Integer> l = graphicService.createGraph(u);
		
		for (int i = 0; i < 6; i++)
			model.addAttribute("stars" + i,l.get(i));

		List<Post> lp = postRepository.findFirst8ByUserEmail(u.getEmail());

		model = loaderService.postLoader(model);
		model = loaderService.userLoader(model, request);
		model.addAttribute("u", u);
		model.addAttribute("id", u.getId());
		model.addAttribute("itemList", lp);
		model.addAttribute("hasSold", false);
		model.addAttribute("idBuyer", 0);
		cService.LoadNotProduct(model, session);
		return "seller-public-profile";
	}

	@GetMapping("/account_settings")
	public String loadAcountSettings(Model model, HttpServletRequest request, HttpSession session) {
		User u = getUserInfo(request);
		model.addAttribute("user", u);
		if (u.getUserAddress() == null)
			model.addAttribute("userAddress", "");
		else
			model.addAttribute("userAddress", u.getUserAddress());

		if (u.getCreditCard() == null)
			model.addAttribute("creditCard", "");
		else
			model.addAttribute("creditCard", u.getCreditCard());
		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model);
		cService.LoadNotProduct(model, session);
		return "account-profile";
	}

	@PostMapping("/profile/updated")
	public String updateProfile(Model model, User user, @RequestParam MultipartFile imagenFile,
			HttpServletRequest request, HttpSession session) throws IOException {

		//Change info
		User u = getUserInfo(request);
		userService.updateUser(user,u);
		
		cService.LoadNotProduct(model, session);
		if (!imagenFile.getOriginalFilename().equals(""))
			imgService.saveImage("users", u.getId(), imagenFile, null);

		return "redirect:/";
	}
}
