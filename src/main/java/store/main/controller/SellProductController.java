package store.main.controller;

import java.io.IOException;
import java.util.List;

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
import store.main.service.ImageService;

@Controller
public class SellProductController {
	
	private interface BrandPostsInfo extends Brand.BasicInfo, Brand.PostsInfo, Post.BasicInfo{};
	private interface UserPostsInfo extends User.BasicInfo, User.PostsInfo, Post.BasicInfo{};
	@Autowired
	UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ImageService imgService;
	
	@JsonView(UserPostsInfo.class)
	private User getUserInfo() {
		return userRepository.findAll().get(0);
	}
	
	@JsonView(BrandPostsInfo.class)
	private Brand getBrand(String name) {
		Brand b = brandRepository.findFirstByNameIgnoreCase(name);
		if(b == null) {
			b = new Brand(name);
			brandRepository.save(b);
		}
		return b;
	}
	
	@GetMapping("/sell_product/")
	public String loadSellProduct(Model model) {
		User u = getUserInfo();
		model.addAttribute("user",u);
		return "user-second-hand-product";
	}
	
	@PostMapping("/sell_product/added_product")
	public String nuevoAnuncio(Model model, Post post, @RequestParam String bname, @RequestParam MultipartFile imagenFile) throws IOException {
		
		Brand b = getBrand(bname);
		post.setBrand(b);
		User u = getUserInfo();
		u.getPosts().add(post);
		post.setUser(u);
		postRepository.save(post);
		userRepository.save(u);
		b.getPosts().add(post);
		brandRepository.save(b);
		


		imgService.saveImage("posts", post.getId(), imagenFile);
		model.addAttribute("extra", post.getId());

		return "index";

	}


}
