package store.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.UserRepository;
import store.main.service.CartService;
import store.main.service.LoaderService;

//HomeController is a class that handles the events of the MStore home page. Upload the names, prices and images of user posts.
@Controller
public class HomeController {

	@Autowired
	private LoaderService hLoader;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/") // main page
	public String loadHome(Model model, HttpServletRequest request, HttpSession session) {
		
		model = hLoader.modelLoader(model);
		model = hLoader.postLoader(model);
		model = hLoader.userLoader(model, request);
		cService.LoadNotProduct(model, session);
				
		return "index";
	}
	
	@PostMapping("/finder")
	public String findPost(HttpServletRequest request, String search) {
		
		Post post = postRepository.findByName(search);
		
		Long id = post.getId();
		
		return "redirect:/post/"+ id + "-0";
	}

}
