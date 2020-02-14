package store.main.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.dataBase.Brand;
import store.main.dataBase.BrandRepository;
import store.main.dataBase.Post;
import store.main.dataBase.PostRepository;
import store.main.dataBase.User;
import store.main.dataBase.UserRepository;
import store.main.service.HomeLoader;
import store.main.service.ImageService;

@Controller
public class SellProductController {

	private interface BrandPostsInfo extends Brand.BasicInfo, Brand.PostsInfo, Post.BasicInfo {
	};

	private interface UserPostsInfo extends User.BasicInfo, User.PostsInfo, Post.BasicInfo {
	};

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ImageService imgService;

	@Autowired
	private HomeLoader hLoader;

	@JsonView(UserPostsInfo.class)
	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}

	@JsonView(BrandPostsInfo.class)
	private Brand getBrand(String name) {
		Brand b = brandRepository.findFirstByNameIgnoreCase(name);
		if (b == null) {
			b = new Brand(name);
			brandRepository.save(b);
		}
		return b;
	}

	@GetMapping("/sell_product/")
	public String loadSellProduct(Model model, HttpServletRequest request) {
		User u = getUserInfo(request);
		model.addAttribute("user", u);
		return "user-second-hand-product";
	}

	@PostMapping("/sell_product/added_product")
	public String nuevoAnuncio(Model model, Post post, @RequestParam String bname,
			@RequestParam MultipartFile imagenFile, HttpServletRequest request) throws IOException {

		Brand b = getBrand(bname);
		post.setBrand(b);
		post.setnImg(1);
		post.setComponentTag(post.getComponent());
		User u = getUserInfo(request);
		u.getPosts().add(post);
		post.setUser(u);
		postRepository.save(post);
		userRepository.save(u);
		b.getPosts().add(post);
		brandRepository.save(b);

		imgService.saveImage("posts", post.getId(), imagenFile);
		//model = hLoader.modelLoader(model);

		//return "index";
		return "redirect:/";

	}

}
