package store.main.api;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	interface CompleteUser extends User.BasicInfo, User.PostsInfo, User.ListRolesInfo, User.ListInfo, Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo {}
	
	interface FullUser extends CompleteUser, User.SellersInfo{};
	
	@JsonView(User.BasicInfo.class)
	@PostMapping("/")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		if(user != null && userRepository.findByEmail(user.getEmail())!=null)
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		else{
			if (!checkCompleteUser(user) || user.getPassword() == null) {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
			user.setId(null);
			user.setPosts(new LinkedList<Post>());
			user.getRoles().add("ROLE_USER");
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		}
	}
	
	@JsonView(User.BasicInfo.class)
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable long id) throws IOException {
		
		if (!checkCompleteUser(updateUser)) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
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
	
	@GetMapping("/")
	@JsonView(User.BasicInfo.class)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	@JsonView(FullUser.class)
	public ResponseEntity<User> getUser(@PathVariable long id) {
		Optional<User> us = userRepository.findById(id);
		if(us.isPresent()) {
			return new ResponseEntity<User>(us.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	private boolean checkCompleteUser(User user) {
		
		if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null ||
				user.getPhone() == null) {
			return false;
		}
		
		return true;
	}
	
}
