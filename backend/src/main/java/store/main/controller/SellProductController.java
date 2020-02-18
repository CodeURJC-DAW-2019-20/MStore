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

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.ImageService;

@Controller
public class SellProductController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ImageService imgService;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}

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
			@RequestParam 	List<MultipartFile> imagenFile, HttpServletRequest request) throws IOException {
		
		Brand b = getBrand(bname);
		post.setBrand(b);
		post.setComponentTag(post.getComponent());
		User u = getUserInfo(request);
		u.getPosts().add(post);
		post.setUser(u);
		postRepository.save(post);
		
		int aux=0;
		for(MultipartFile mf:imagenFile) 
			if(!mf.getOriginalFilename().equals("")) {
				imgService.saveImage("posts", post.getId(), mf,aux);
				aux++;
			}
		
		post.setnImg(aux);
		userRepository.save(u);
		b.getPosts().add(post);
		brandRepository.save(b);

		
		
		return "redirect:/";

	}

}
