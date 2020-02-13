package store.main.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.main.dataBase.Post;
import store.main.dataBase.PostRepository;

@Controller
public class ComponentController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private Cart cart;

	
	
	@RequestMapping("/post/{id}")
	public String mapPost(Model model,@PathVariable Long id,HttpSession session){
		cart.cartInit(session);
		
		boolean empty=(boolean) session.getAttribute("empty");
		long total=(long) session.getAttribute("total");
		List<Post> cartAux=(List<Post>)session.getAttribute("cart");
		
		model.addAttribute("cart",cartAux);
		model.addAttribute("total",total);
		model.addAttribute("empty",empty);
		
		Post post= postRepository.findById(id).get();
		boolean alreadyOn=cartAux.contains(post);
		
		
		model.addAttribute("alreadyOn",alreadyOn);
		model.addAttribute("post",post);
		return "shop-single-electronics";
	}
	
	
	@RequestMapping("/post/{id}/removeItem-{idRemove}")
	public String mapPost(Model model,@PathVariable Long id, @PathVariable Long idRemove, HttpSession session){
		Post post= postRepository.findById(id).get();
		model.addAttribute("post",post);
		cart.removeFromCart(postRepository.findById(idRemove).get(), session);
		
		long total=(long) session.getAttribute("total");
		List<Post> cartAux=(List<Post>)session.getAttribute("cart");
		boolean empty=(boolean) session.getAttribute("empty");
		boolean alreadyOn=cartAux.contains(post);
		
		
		model.addAttribute("alreadyOn",alreadyOn);
		model.addAttribute("cart",cartAux);
		model.addAttribute("total",total);
		model.addAttribute("empty",empty);
		
		return "shop-single-electronics";
	}
	
	
	@RequestMapping("/post/{id}/itemAdded")
	public String mapPostCart(Model model,@PathVariable Long id,HttpSession session){
		
		
		Post post= postRepository.findById(id).get();
		model.addAttribute("post",post);
		cart.addToCart(post, session);
		
		long total=(long) session.getAttribute("total");
		List<Post> cartAux=(List<Post>)session.getAttribute("cart");
		boolean empty=(boolean) session.getAttribute("empty");
		boolean alreadyOn=cartAux.contains(post);
		
		
		model.addAttribute("alreadyOn",alreadyOn);
		model.addAttribute("cart",cartAux);
		model.addAttribute("total",total);
		model.addAttribute("empty",empty);
		
		return "shop-single-electronics";
	}
	
	
	
}
