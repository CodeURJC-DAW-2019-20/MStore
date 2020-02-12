package store.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import store.main.dataBase.*;

//HomeController is a class that handles the events of the MStore home page. Upload the names, prices and images of user posts.
@Controller
public class HomeController {

	@Autowired
	private PostRepository postRepository; // repository of posts

	@GetMapping("/") // main page
	public String loadHome(Model model) {

		List<Post> postList = postRepository.findAll();

		// load first three items from the database
		for (int i = 0; i < 3; i++) {
			model.addAttribute("post" + i, postList.get(i));
		}

		// load first eight items from the database
		for (int i = 0; i < 8; i++) {
			model.addAttribute("item" + i, postList.get(i));
		}
		return "index";
	}

}
