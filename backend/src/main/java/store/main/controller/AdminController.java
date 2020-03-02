package store.main.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.UserRepository;
import store.main.service.CartService;
import store.main.service.LoaderService;
import store.main.service.PostService;

@Controller
public class AdminController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	LoaderService loaderService;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private CartService cService;

	@Autowired
	private PostService postService;

	private void adminLoader(Model model, HttpSession session, HttpServletRequest request) {

		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model);

		model.addAttribute("updated", false);
		model.addAttribute("deleted", false);

		cService.LoadNotProduct(model, session);
	}

	private void adminPostLoader(Model model, Post post) {

		LinkedList<Integer> images = new LinkedList<>();

		for (int i = 0; i < post.getnImg(); i++) {
			images.add(i);
		}

		model.addAttribute("post", post);
		model.addAttribute("found", true);
		model.addAttribute("images", images);
		model.addAttribute("edit", false);
	}

	@GetMapping("/admin")
	public String adminPage(Model model, HttpSession session, HttpServletRequest request) {

		adminLoader(model, session, request);

		model.addAttribute("found", false);

		model.addAttribute("updated", session.getAttribute("updated"));
		model.addAttribute("deleted", session.getAttribute("deleted"));

		session.setAttribute("updated", false);
		session.setAttribute("deleted", false);

		return "admin-page";
	}

	@PostMapping("/admin/search_product")
	public String findPost(Model model, HttpServletRequest request, HttpSession session, String searchAdmin) {

		adminLoader(model, session, request);

		Post post = postRepository.findByName(searchAdmin);

		if (post == null) {
			model.addAttribute("found", false);
		} else {
			adminPostLoader(model, post);
		}

		return "admin-page";
	}

	@PostMapping("/admin/edit/{id}")
	public String editPost(Model model, HttpServletRequest request, HttpSession session, @PathVariable Long id) {

		Post post = postRepository.findById(id).get();

		adminLoader(model, session, request);
		adminPostLoader(model, post);

		model.addAttribute("edit", true); // Override value of edit after method adminPostLoader

		return "admin-page";
	}

	@PostMapping("/admin/updated/{id}")
	public String updatePost(Model model, Post post, @RequestParam String bname, @PathVariable Long id,
			@RequestParam List<MultipartFile> imagenFile, HttpServletRequest request, HttpSession session)
			throws IOException {

		postService.setUpdatedPost(post, bname, imagenFile, id);

		session.setAttribute("updated", true);

		return "redirect:/admin";
	}

	@PostMapping("/admin/deleted/{id}")
	public String deletePost(Model model, HttpServletRequest request, HttpSession session, @PathVariable Long id) {

		Post post = postRepository.findById(id).get();

		postService.deletePostFromBD(post);

		session.setAttribute("deleted", true);

		return "redirect:/admin";
	}

}
