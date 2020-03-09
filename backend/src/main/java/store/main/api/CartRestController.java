package store.main.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.controller.Cart;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.service.CartService;

@RestController
@RequestMapping("/api/carts")

public class CartRestController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CartService cService;

	interface completeCart extends Post.BasicInfo,Post.UserInfo,Post.TagsInfo,Post.BrandInfo{}
	
	@GetMapping("/")
	@JsonView(completeCart.class)
	public ResponseEntity<Object> getCart(HttpSession session) {
		if (session.getAttribute("cart")==null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Object>(session.getAttribute("cart"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	@JsonView(completeCart.class)
	public ResponseEntity<Object> getCartItem(HttpSession session, @PathVariable long id) {
		List<Post> elements= (List<Post>) session.getAttribute("cart");
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent() && elements.contains(post.get())) {
			return new ResponseEntity<>(post.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	@JsonView(completeCart.class)
	public ResponseEntity<Post> ModifyCart(HttpSession session, @PathVariable long id) {
		Optional<Post> post = postRepository.findById(id);
		List<Post> elements= (List<Post>) session.getAttribute("cart");
		if (!post.isPresent()) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
		else if (elements.contains(post.get())) {
			cService.removeFromCart(post.get(), session);
			return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
		}
		else {
			cService.addToCart(post.get(), session);
			return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
		}
	}
	

	@PostMapping("/")
	@JsonView(completeCart.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Cart createCart(HttpSession session) throws IOException {
		Cart c = new Cart();
		cService.newCart(session);
		return c;
	}
	
	@DeleteMapping("/")
	@JsonView(completeCart.class)
	public Cart deleteCart(HttpSession session) throws IOException {
		Cart c = new Cart();
		c.Load(session);
		cService.destroyCart(session);
		return c;
	}
	
	
}