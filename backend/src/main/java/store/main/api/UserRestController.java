package store.main.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Rating;
import store.main.database.User;
import store.main.database.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
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
}
