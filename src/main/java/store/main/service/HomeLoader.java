package store.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import store.main.dataBase.Post;
import store.main.dataBase.PostRepository;

@Service
public class HomeLoader {
	
	@Autowired
	private PostRepository postRepository; // repository of posts
	
	public Model modelLoader(Model model) {
		List<Post> postList = postRepository.findAll();

		// load first three items from the database
		for (int i = 0; i < 3; i++) {
			model.addAttribute("post" + i, postList.get(i));
		}

		// load first eight items from the database
		for (int i = 0; i < 8; i++) {
			model.addAttribute("item" + i, postList.get(i));
		}
		return model;
	}
}
