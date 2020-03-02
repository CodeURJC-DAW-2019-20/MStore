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
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.CartService;
import store.main.service.LoaderService;
import store.main.service.PostService;

@Controller
public class SellProductController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartService cService;

	@Autowired
	private LoaderService loaderService;
	

	@GetMapping("/sell_product/")
	public String loadSellProduct(Model model, HttpServletRequest request, HttpSession session) {
		loadSellProductR(model, request);
		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model);
		cService.LoadNotProduct(model, session);
		return "user-second-hand-product";
	}

	private void loadSellProductR(Model model, HttpServletRequest request) {
		User u = userRepository.findByEmail(request.getUserPrincipal().getName());;
		model.addAttribute("user", u);
	}

	@PostMapping("/sell_product/added_product")
	public String nuevoAnuncio(Model model, Post post, @RequestParam String bname,
			@RequestParam List<MultipartFile> imagenFile, HttpServletRequest request, HttpSession session)
			throws IOException {

		postService.createPost(post, bname, imagenFile, userRepository.findByEmail(request.getUserPrincipal().getName()));

		return "redirect:/";

	}



}
