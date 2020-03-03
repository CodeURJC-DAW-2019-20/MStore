package store.main.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import store.main.controller.Cart;
import store.main.database.*;

@Service
public class CartService {

	@Autowired
	private Cart cart;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BrandRepository brandRepository;

	private User getUserInfo(HttpServletRequest request) {
		return userRepository.findByEmail(request.getUserPrincipal().getName());
	}

	public void Load(Model model, HttpSession session, Long id, HttpServletRequest request) {
		cartInit(session);

		boolean empty = (boolean) session.getAttribute("empty");
		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		Post post = postRepository.findById(id).get();
		boolean alreadyOn = cartAux.contains(post);
		if (request.isUserInRole("USER")) {
			User user = getUserInfo(request);
			boolean isSameUser = user.getPosts().contains(post);
			model.addAttribute("isSameUser", isSameUser);
		}
		post.getnImg();

		model.addAttribute("alreadyOn", alreadyOn);
	}

	public void LoadNotProduct(Model model, HttpSession session) {
		cartInit(session);

		boolean empty = (boolean) session.getAttribute("empty");
		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

	}

	public void AddComponent(Model model, HttpSession session, Long id) {
		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		addToCart(post, session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(post);

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);
	}

	public void RemoveComponent(Model model, HttpSession session, Long id, Long idRemove) {
		Post post = postRepository.findById(id).get();
		model.addAttribute("post", post);
		removeFromCart(postRepository.findById(idRemove).get(), session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(post);

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);
	}

	public void RemoveComponentNotProduct(Model model, HttpSession session, Long id) {
		removeFromCart(postRepository.findById(id).get(), session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(postRepository.findById(id));

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);
	}
	
	public void addToCart(Post post, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new LinkedList<Post>());
		}

		List<Post> list = (List<Post>) session.getAttribute("cart");
		long total = (long) session.getAttribute("total");

		if (!list.contains(post)) {
			total += post.getPrice();
			list.add(post);
		}

		session.setAttribute("total", total);
		session.setAttribute("cart", list);
		session.setAttribute("empty", list.isEmpty());
	}

	public void removeFromCart(Post post, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new LinkedList<Post>());
		}

		List<Post> list = (List<Post>) session.getAttribute("cart");
		long total = (long) session.getAttribute("total");

		if (list.contains(post)) {
			list.remove(post);
			total -= post.getPrice();
		}
		session.setAttribute("total", total);
		session.setAttribute("cart", list);
		session.setAttribute("empty", list.isEmpty());
	}

	public void cartInit(HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Post> list = new ArrayList<Post>();
			long total = 0;
			boolean empty = true;
			session.setAttribute("cart", list);
			session.setAttribute("empty", empty);
			session.setAttribute("total", total);
		}
	}
	
	public void newCart(HttpSession session) {
		List<Post> list = new ArrayList<Post>();
		long total = 0;
		boolean empty = true;
		session.setAttribute("cart", list);
		session.setAttribute("empty", empty);
		session.setAttribute("total", total);
}
	
	public void destroyCart(HttpSession session) {
		session.removeAttribute("cart");
		session.removeAttribute("total");
		session.removeAttribute("empty");
	}

}
