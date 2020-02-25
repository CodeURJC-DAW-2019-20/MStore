package store.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import store.main.database.BrandRepository;
import store.main.database.PostRepository;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;

@Controller
public class DataInsert implements CommandLineRunner {

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public void run(String... args) throws Exception {

		// saveAdmin();

	}

	public void saveAdmin() {
		User user = new User("Admin", "ElAdmin", "admin@gmail.com", "67434344", "admin", "Calle del admin 1");
		user.getRoles().add("ROLE_USER");
		user.getRoles().add("ROLE_ADMIN");

		userRepository.save(user);
	}

}