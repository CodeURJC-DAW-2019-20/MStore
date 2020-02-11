package store.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import store.main.dataBase.*;

@Controller
public class DataInsert implements CommandLineRunner {

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User("Diego","Montoto","dm@gmail.com","686665758","pass","Plaza de los limones 27");
		Brand b1 = new Brand("HP");
		brandRepository.save(b1);
		Post p1 = new Post(1,1,120,"barato","...",b1,"company Spain Madrid 111 street1 street2","tags1","tag2");
		user.getPosts().add(p1);
		p1.setUser(user);
		userRepository.save(user);
		b1.getPosts().add(p1);
		p1.setBrand(b1);
		brandRepository.save(b1);
		postRepository.save(p1);
			
		
		
	}

}
