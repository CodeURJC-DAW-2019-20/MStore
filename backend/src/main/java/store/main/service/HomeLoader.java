package store.main.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import store.main.database.Post;
import store.main.database.PostRepository;

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

		// list with all product order by descending price
		List<Post> postListPriceDesc = postRepository.OrderByPriceDesc();

		// list with all product order by ascending price
		List<Post> postListPriceAsc = postRepository.OrderByPriceAsc();

		// list order by new arrivals
		List<Post> postListIdDesc = postRepository.OrderByIdDesc();

		// load the three most expensive products
		loadPosts(model, postListPriceDesc,"1",3);
		
		// load cheapest products
		loadPosts(model, postListPriceAsc,"2",8);

		// load newly arrived products
		loadPosts(model, postListIdDesc,"3",8);
		
		model.addAttribute("post",postListPriceDesc.get(0)); //The most expensive product
		return model;
	}
	
	/**
	 * @param model
	 * @param list
	 * @param tag mustache list
	 * @param n first products to show
	 */
	private void loadPosts(Model model,List<Post> list,String tag,int n) {
	
		if (list.size() > n) {
			List<Post> auxList = new LinkedList<Post>();
			for (int i = 0; i < n; i++) {
				auxList.add(list.get(i));
			}
			model.addAttribute("list"+tag, auxList);
		} else {
			model.addAttribute("list"+tag, list);
		}	
	}
	
	public Model postLoader(Model model){
		model.addAttribute("postList", postRepository.findAll());
		return model;
		
	}
}
