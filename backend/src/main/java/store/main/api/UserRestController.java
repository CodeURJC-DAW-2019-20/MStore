package store.main.api;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.api.UserRestController.completeUser;
import store.main.database.Post;
import store.main.database.Rating;
import store.main.database.User;
import store.main.database.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	interface completeUser extends User.BasicInfo, User.PostsInfo, User.ListInfo, Post.BasicInfo {}
	
	
	@JsonView(User.BasicInfo.class)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public User postUser(@RequestBody User user) {
		if(user != null && userRepository.findByEmail(user.getEmail())==null) {
		user.getRoles().add("ROLE_USER");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		userRepository.save(user);
		return user;
		}
		return null;
	}
	
	@GetMapping("/")
	@JsonView(completeUser.class)
	public Collection<User> getBrands() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(completeUser.class)
	public ResponseEntity<User>getBrandId(@PathVariable long id) {
		Optional<User> us = userRepository.findById(id);
		if(us.isPresent()) {
			return new ResponseEntity<User>(us.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
}
