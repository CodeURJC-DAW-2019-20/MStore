package store.main.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import store.main.database.*;

@Controller
public class CartController {

	@Autowired
	private Cart cart;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/cart")
	public String mapPost(Model model, HttpSession session) {

		cart.cartInit(session);

		long total = (long) session.getAttribute("total");
		boolean empty = (boolean) session.getAttribute("empty");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		return "cart";
	}

	@RequestMapping("/cart/removeItem-{idRemove}")
	public String mapPost(Model model, @PathVariable Long idRemove, HttpSession session) {

		cart.removeFromCart(postRepository.findById(idRemove).get(), session);

		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		boolean empty = (boolean) session.getAttribute("empty");

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);
		model.addAttribute("empty", empty);

		return "cart";
	}

	@RequestMapping("/final_review")
	public String finalReview(Model model, HttpSession session, HttpServletRequest request) {
		// get user
		User user = userRepository.findByEmail(request.getUserPrincipal().getName());
		// get session data
		long total = (long) session.getAttribute("total");
		List<Post> cartAux = (List<Post>) session.getAttribute("cart");
		// String creditcart=session.getAttribute("creditcard");
		String creditcard = "58887788778";
		creditcard = creditcard.substring(creditcard.length() - 4, creditcard.length());

		model.addAttribute("cart", cartAux);
		model.addAttribute("total", total);

		// user data to model
		model.addAttribute("phone", user.getPhone());
		model.addAttribute("firstname", user.getFirstName());
		model.addAttribute("lastname", user.getLastName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("creditcard", creditcard);
		return "checkout-review";
	}

	@RequestMapping("/complete")
	public String completeOrder(Model model, HttpSession session, HttpServletRequest request) {
		User user = userRepository.findByEmail(request.getUserPrincipal().getName());// get user

		List<Post> cartAux = (List<Post>) session.getAttribute("cart");// get cart
		List<User> sellerList = user.getSellers();
		for (Post p : cartAux) { // set sellers
			if (!sellerList.contains(p.getUser())) {
				sellerList.add(p.getUser());
				/*p.getUser().getPosts().remove(p);
				p.getBrand().getPosts().remove(p);
				postRepository.delete(p);//delete post*/
			}
		}
		user.setSellers(sellerList);
		//reset cart
		session.setAttribute("cart", new LinkedList<>());
		session.setAttribute("total", (long) 0);
		session.setAttribute("empty", true);
		model.addAttribute("name",user.getFirstName());
		return "checkout-complete";
	}

}
