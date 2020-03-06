package store.main.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import store.main.database.*;
import store.main.service.CartService;
import store.main.service.LoaderService;
import store.main.service.PostService;

@Controller
public class ComponentController {

	private List<Post> postList1 = new LinkedList<Post>();// store posts with user tag1
	private List<Post> postList2 = new LinkedList<Post>();// store posts with user tag2
	private List<Post> postList3 = new LinkedList<Post>();// store posts with user tag3
	private List<Post> finalList = new LinkedList<>(); // store the 3 recommended tags

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private LoaderService loaderService;

	@Autowired
	private CartService cService;
	
	@Autowired
	private PostService postService;
	

	@RequestMapping("/post/{id}-{img}")
	public String mapPost(Model model, @PathVariable Long id, @PathVariable int img, HttpSession session,
			HttpServletRequest request) {

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		cService.Load(model, session, id, request);

		// reset lists
		this.postList1 = new LinkedList<>();
		this.postList2 = new LinkedList<>();
		this.postList3 = new LinkedList<>();

		if (request.isUserInRole("USER")) {
			postService.loadRecommendationsIntoBD(request, post);// private method that loads the
														// recommendations of a
														// registered user
		} else {
			postService.loadRecommendationsIntoSession(session, post);// private method that loads
															// the recommendations of a
															// visiting user
		}

		LinkedList<Integer> images = new LinkedList<>();

		for (int i = 0; i < post.getnImg(); i++) {
			images.add(i);
		}

		int totalr = 0;
		String seller = post.getUser().getFirstName() + " " + post.getUser().getLastName();
		model.addAttribute("emptyfeatures", post.getFeatures().matches(".*[a-zA-Z]+.*"));
		model.addAttribute("userid", post.getUser().getId());
		model.addAttribute("tag", post.getComponentTag());
		model.addAttribute("tagname", post.getComponent());
		model.addAttribute("seller", seller);
		model.addAttribute("stars", getratings(post, totalr));
		model.addAttribute("totalrates", countratings(post));
		model.addAttribute("bname", post.getBrand().getName());
		model.addAttribute("images", images);
		model.addAttribute("image", img);

		postService.addToRecomendedList(model);

		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model); // posts

		return "shop-single-electronics";
	}

	public void setPostList1(List<Post> postList1) {
		this.postList1 = postList1;
	}

	public void setPostList2(List<Post> postList2) {
		this.postList2 = postList2;
	}

	public void setPostList3(List<Post> postList3) {
		this.postList3 = postList3;
	}

	@RequestMapping("/post/{id}-{img}/itemAdded")
	public String mapPostCart(Model model, @PathVariable Long id, @PathVariable int img, HttpSession session,
			HttpServletRequest request) {

		cService.AddComponent(model, session, id);

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);

		LinkedList<Integer> images = new LinkedList<>();
		for (int i = 0; i < post.getnImg(); i++) {
			images.add(i);
		}
		int totalr = 0;
		String seller = post.getUser().getFirstName() + " " + post.getUser().getLastName();
		model.addAttribute("emptyfeatures", post.getFeatures().matches(".*[a-zA-Z]+.*"));
		model.addAttribute("userid", post.getUser().getId());
		model.addAttribute("tag", post.getComponentTag());
		model.addAttribute("tagname", post.getComponent());
		model.addAttribute("seller", seller);
		model.addAttribute("stars", getratings(post, totalr));
		model.addAttribute("totalrates", countratings(post));
		model.addAttribute("bname", post.getBrand().getName());
		model.addAttribute("images", images);
		model.addAttribute("image", img);

		model.addAttribute("recomend", !finalList.isEmpty());
		model.addAttribute("list", finalList);

		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model); // posts

		return "shop-single-electronics";
	}

	public void setFinalList(List<Post> finalList) {
		this.finalList = finalList;
	}

	private List<Boolean> getratings(Post post, int totalr) {
		List<List<Rating>> rating = new LinkedList<List<Rating>>();
		for (int i = 0; i < 6; i++) {
			rating.add((ratingRepository.findBySellerEmailIgnoreCaseAndStars(post.getUser().getEmail(), i)));
		}
		int cont = 0;
		for (int i = 0; i < rating.size(); i++) {
			cont += rating.get(i).size() * i;
			totalr += rating.get(i).size();
		}
		if (totalr != 0) {
			cont = cont / totalr;
		}
		List<Boolean> ratingf = new LinkedList<Boolean>();
		for (int i = 0; i < 5; i++) {
			if (i < cont) {
				ratingf.add(true);
			} else {
				ratingf.add(false);
			}
		}
		return ratingf;
	}

	private int countratings(Post post) {
		List<List<Rating>> rating = new LinkedList<List<Rating>>();
		for (int i = 0; i < 6; i++) {
			rating.add((ratingRepository.findBySellerEmailIgnoreCaseAndStars(post.getUser().getEmail(), i)));
		}
		int totalr = 0;
		for (int i = 0; i < rating.size(); i++) {
			totalr += rating.get(i).size();
		}
		return totalr;
	}
	
	public List<Post> getPostList1() {
		return postList1;
	}


	public List<Post> getPostList2() {
		return postList2;
	}


	public List<Post> getPostList3() {
		return postList3;
	}

	public List<Post> getFinalList() {
		return finalList;
	}

}
