package store.main.service;

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
	
	public void Load (Model model, HttpSession session, Long id,HttpServletRequest request) {
		cart.cartInit(session);

		boolean empty = (boolean) session.getAttribute("empty");
		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		Post post = postRepository.findById(id).get();
		boolean alreadyOn = cartAux.contains(post);
		if(request.isUserInRole("USER")) {
			User user = getUserInfo(request);
			boolean isSameUser= user.getPosts().contains(post);
			model.addAttribute("isSameUser",isSameUser);
		}
		post.getnImg();

		model.addAttribute("alreadyOn", alreadyOn);	
	}
	
	public void LoadNotProduct (Model model, HttpSession session) {
		cart.cartInit(session);

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
		cart.addToCart(post, session);

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
		cart.removeFromCart(postRepository.findById(idRemove).get(), session);

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
		cart.removeFromCart(postRepository.findById(id).get(), session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");
		boolean alreadyOn = cartAux.contains(postRepository.findById(id));

		model.addAttribute("alreadyOn", alreadyOn);
		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);
	}
	
	public void deletePostFromBD(Post p) {
		Brand b = brandRepository.findByName(p.getBrand().getName());
		b.getPosts().remove(p);
		brandRepository.save(b);

		User u = userRepository.findByEmail(p.getUser().getEmail());
		u.getPosts().remove(p);
		userRepository.save(u);

		postRepository.delete(p);
	}
	
	
}


