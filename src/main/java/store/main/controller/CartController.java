package store.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import store.main.dataBase.Post;
import store.main.dataBase.PostRepository;

@Controller
public class CartController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/cart")
	public String mapPost(Model model,HttpSession session){
		cart.cartInit(session);
		
		long total=(long) session.getAttribute("total");
		boolean empty=(boolean) session.getAttribute("empty");
		List<Post> cartAux=(List<Post>)session.getAttribute("cart");

		model.addAttribute("cart",cartAux);
		model.addAttribute("total",total);
		model.addAttribute("empty",empty);
		
		return "cart";
	}
	
	@RequestMapping("/cart/removeItem-{idRemove}")
	public String mapPost(Model model, @PathVariable Long idRemove, HttpSession session){
		cart.removeFromCart(postRepository.findById(idRemove).get(), session);
		
		long total=(long) session.getAttribute("total");
		List<Post> cartAux=(List<Post>)session.getAttribute("cart");
		boolean empty=(boolean) session.getAttribute("empty");
		
		
		model.addAttribute("cart",cartAux);
		model.addAttribute("total",total);
		model.addAttribute("empty",empty);
		
		return "cart";
	}

}
