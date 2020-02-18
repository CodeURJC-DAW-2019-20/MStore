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

import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.*;

@Controller
public class ComponentController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private Cart cart;

	@RequestMapping("/post/{id}")
	public String mapPost(Model model, @PathVariable Long id, HttpSession session, HttpServletRequest request) {

		cart.cartInit(session);

		boolean empty = (boolean) session.getAttribute("empty");
		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		Post post = postRepository.findById(id).get();
		boolean alreadyOn = cartAux.contains(post);

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("post", post);

		List<Post> postList1 = new LinkedList<Post>();// store posts with user tag1
		List<Post> postList2 = new LinkedList<Post>();// store posts with user tag2
		List<Post> postList3 = new LinkedList<Post>();// store posts with user tag3

		if (request.isUserInRole("USER")) {
			loadRecommendationsIntoBD(postList1, postList2, postList3, request, post);// private method that loads the
																						// recommendations of a
																						// registered user
		} else {
			loadRecommendationsIntoSesion(postList1, postList2, postList3, session, post);// private method that loads
																							// the recommendations of a
																							// visiting user
		}

		model.addAttribute("list1", postList1);
		model.addAttribute("list2", postList2);
		model.addAttribute("list3", postList3);

		return "shop-single-electronics";
	}

	@RequestMapping("/post/{id}/removeItem-{idRemove}")
	public String mapPost(Model model, @PathVariable Long id, @PathVariable Long idRemove, HttpSession session) {

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		cart.removeFromCart(postRepository.findById(idRemove).get(), session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(post);

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		return "shop-single-electronics";
	}

	@RequestMapping("/post/{id}/itemAdded")
	public String mapPostCart(Model model, @PathVariable Long id, HttpSession session) {

		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		cart.addToCart(post, session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(post);

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

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
}
