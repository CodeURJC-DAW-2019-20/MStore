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

@Controller
public class ComponentController {

	private List<Post> postList1 = new LinkedList<Post>();// store posts with user tag1
	private List<Post> postList2 = new LinkedList<Post>();// store posts with user tag2
	private List<Post> postList3 = new LinkedList<Post>();// store posts with user tag3

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingRepository ratingRepository;


	@Autowired
	private PostRepository postRepository;

	@Autowired
	private Cart cart;
	
	@Autowired
	private CartService cService;

	@RequestMapping("/post/{id}-{img}")
	public String mapPost(Model model, @PathVariable Long id, @PathVariable int img, HttpSession session, HttpServletRequest request) {

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		cService.Load(model, session, id);
		
		//reset lists
		this.postList1 = new LinkedList<>();
		this.postList2 = new LinkedList<>();
		this.postList3 = new LinkedList<>();

		if (request.isUserInRole("USER")) {
			loadRecommendationsIntoBD(postList1, postList2, postList3, request, post);// private method that loads the
																						// recommendations of a
																						// registered user
		} else {
			loadRecommendationsIntoSesion(postList1, postList2, postList3, session, post);// private method that loads
																							// the recommendations of a
																							// visiting user
		}
		LinkedList<Integer> images = new LinkedList<>();
		for (int i=0; i<post.getnImg(); i++) {
			images.add(i);
		}
		int totalr=0;
		String seller = post.getUser().getFirstName()+" "+post.getUser().getLastName();
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
		model.addAttribute("list1", postList1);
		model.addAttribute("list2", postList2);
		model.addAttribute("list3", postList3);
		model.addAttribute("recomend", (postList1.size() + postList2.size() + postList3.size()) != 0); // there are
																										// recommended
																										// posts

		return "shop-single-electronics";
	}

	@RequestMapping("/post/{id}-{img}/itemAdded")
	public String mapPostCart(Model model, @PathVariable Long id, @PathVariable int img, HttpSession session) {
		
		cService.AddComponent(model, session, id);

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		
		LinkedList<Integer> images = new LinkedList<>();
		for (int i=0; i<post.getnImg(); i++) {
			images.add(i);
		}
		int totalr=0;
		String seller = post.getUser().getFirstName()+" "+post.getUser().getLastName();
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
		model.addAttribute("list1", postList1);
		model.addAttribute("list2", postList2);
		model.addAttribute("list3", postList3);
		model.addAttribute("recomend", (postList1.size() + postList2.size() + postList3.size()) != 0); // there are
																										// recommended
																										// posts

		return "shop-single-electronics";
	}


	private void loadRecommendationsIntoBD(List<Post> postList1, List<Post> postList2, List<Post> postList3,
			HttpServletRequest request, Post post) {
		User user = userRepository.findByEmail(request.getUserPrincipal().getName());
		List<String> userTags = user.getTags();
		loadList(userTags, post, postList1, postList2, postList3);
		user.setTags(userTags);
		userRepository.save(user); // update user tag list
	}

	private void loadRecommendationsIntoSesion(List<Post> postList1, List<Post> postList2, List<Post> postList3,
			HttpSession session, Post post) {
		List<String> userTags = (List<String>) session.getAttribute("tags");
		List<String> list = loadList(userTags, post, postList1, postList2, postList3);
		session.setAttribute("tags", list); // update user tag list in session
	}

	private List<String> loadList(List<String> userTags, Post post, List<Post> postList1, List<Post> postList2,
			List<Post> postList3) {

		// Advanced algorithm

		Random r = new Random(); // need a Random to choose the tags of a post
		if (userTags == null) {
			userTags = new LinkedList<>();
		}

		if (userTags.isEmpty()) { // the user enters for the first time and the recommended tags are those of the
									// post he is seeing
			if (post.getTags().size() > 3) {
				while (userTags.size() < 3) {
					userTags.add(post.getTags().get(r.nextInt(post.getTags().size())));
				}
			} else {
				for (String tag : post.getTags()) {
					if (userTags.size() < 3) {
						userTags.add(tag);
					}
				}
				while (userTags.size() < 3) {
					userTags.add(userTags.get(0));
				}
			}
		} else {// if the user has already visited other posts, the user's tags are replaced by
				// more recent tags
			if (post.getTags().size() > 2) {
				int cont = 0;
				while (cont < 2) {
					userTags.add(0, post.getTags().get(r.nextInt(post.getTags().size())));
					cont++;
				}
			} else {
				for (String tag : post.getTags()) {
					userTags.add(0, tag);
				}
			}
			// remove old and unnecessary tags(the user has more than 3 recommended tags)
			if (userTags.size() > 3) {
				List<String> removeList = new LinkedList<>();
				for (int i = 3; i < userTags.size(); i++) {
					removeList.add(userTags.get(i));
				}
				for (String t : removeList) {
					userTags.remove(t);
				}
			}

		}
		List<Post> postsList = postRepository.findAll();
		/**
		 * Once having the 3 key tags, a maximum of 9 recommended posts are searched.
		 * postList1 stores the key tag 1 postList2 stores the key tag 2 postList3 3
		 * stores the key tag 3
		 */
		for (Post p : postsList) {
			if (p != post) {
				if (p.getTags().contains(userTags.get(0)) && postList1.size() < 3 && !postList2.contains(p)
						&& !postList3.contains(p) && !postList1.contains(p)) {
					postList1.add(p);
				} else if (p.getTags().contains(userTags.get(1)) && postList2.size() < 3 && !postList1.contains(p)
						&& !postList3.contains(p) && !postList2.contains(p)) {
					postList2.add(p);
				} else if (p.getTags().contains(userTags.get(2)) && postList3.size() < 3 && !postList1.contains(p)
						&& !postList2.contains(p) && !postList3.contains(p)) {
					postList3.add(p);
				}
			}
		}
		return userTags;

	}
	
	private List<Boolean> getratings (Post post, int totalr) {
		List<List<Rating>> rating = new LinkedList<List<Rating>>();
		for(int i=0;i<6;i++){
			rating.add((ratingRepository.findBySellerEmailIgnoreCaseAndStars(post.getUser().getEmail(), i)));
			}
		int cont =0;
		for(int i=0;i<rating.size();i++){
			cont+=rating.get(i).size()*i;
			totalr+= rating.get(i).size();
			}
		if (totalr!=0) {
		cont= cont / totalr;
		}
		List<Boolean>ratingf=new LinkedList<Boolean>();
		for(int i=0;i<5;i++){
			if (i<cont) {
			ratingf.add(true);
			}
			else {
			ratingf.add(false);
			}
		}
		return ratingf;
	}
	
	private int countratings (Post post) {
		List<List<Rating>> rating = new LinkedList<List<Rating>>();
		for(int i=0;i<6;i++){
			rating.add((ratingRepository.findBySellerEmailIgnoreCaseAndStars(post.getUser().getEmail(), i)));
			}
		int totalr=0;
		for(int i=0;i<rating.size();i++){
			totalr+= rating.get(i).size();
			}
		return totalr;
	}
}
