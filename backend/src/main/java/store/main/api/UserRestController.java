package store.main.api;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.Post;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.UserComponent;
import store.main.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	interface CompleteUser extends User.BasicInfo, User.PostsInfo, User.ListInfo, Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo {}
	
	@JsonView(User.BasicInfo.class)
	@PostMapping("/")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		user.setId(null);
		if(user != null && userRepository.findByEmail(user.getEmail())!=null)
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		else{
			user.getRoles().add("ROLE_USER");
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		}
	}
	
	@JsonView(User.BasicInfo.class)
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable long id) throws IOException {
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if (optionalUser.isPresent()) {
			if (userComponent.getLoggedUser().getEmail().equals(optionalUser.get().getEmail()) ) {
			
				User user = userService.updateUser(updateUser, optionalUser.get());
				
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/{id}")
	@JsonView(CompleteUser.class)
	public ResponseEntity<User> getUser(@PathVariable long id) {
		Optional<User> us = userRepository.findById(id);
		if(us.isPresent()) {
			return new ResponseEntity<User>(us.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
}
