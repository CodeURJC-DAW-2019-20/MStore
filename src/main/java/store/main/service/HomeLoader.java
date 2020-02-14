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

	/**
	 * Loads the Home Page
	 * 
	 * @param model
	 * @return model with attributes
	 */
	public Model modelLoader(Model model) {
		// list with all products
		List<Post> postList = postRepository.findAll();

		// list with all product order by descending price
		List<Post> postListPriceDesc = postRepository.OrderByPriceDesc();

		// list with all product order by ascending price
		List<Post> postListPriceAsc = postRepository.OrderByPriceAsc();

		// load the three most expensive products
		for (int i = 0; i < 3; i++) {
			model.addAttribute("post" + i, postListPriceDesc.get(i));
		}

		// load the eight cheapest products
		for (int i = 0; i < 8; i++) {
			model.addAttribute("item" + i, postListPriceAsc.get(i));
		}
		// load newly arrived products
		for (int i = 0; i < 12; i++) {
			model.addAttribute("arrival" + i, postList.get(i));
		}
		return model;
	}
}
