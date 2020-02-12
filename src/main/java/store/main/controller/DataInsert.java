package store.main.controller;

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

		User user = new User("Diego", "Montoto", "dm@gmail.com", "686665758", "pass", "Plaza de los limones 12");
		user.getRoles().add("ROLE_USER");
		Brand b1 = new Brand("HP");
		Brand b2 = new Brand("MSI");
		brandRepository.save(b1);
		brandRepository.save(b2);
		Post p1 = new Post("HP Printer", 1, 1, 10, "barato", "...", b1, "company Spain Madrid 111 street1 street2",
				"tags1", "tag2");
		Post p2 = new Post("HP Scanner", 1, 1, 720, "barato", "...", b1, "company UK London 111 street1 street2",
				"tags1", "tag2");
		Post p3 = new Post("PC MSI", 1, 1, 120, "caro", "...", b1, "company Germany Berlin 111 street1 street2",
				"tags1", "tag2");
		Post p4 = new Post("MSI Printer", 0, 1, 1290, "barato", "...", b1, "company Spain Madrid 111 street1 street2",
				"tags1", "tag2");
		Post p5 = new Post("MSI Printer", 1, 1, 820, "vende rapido", "...", b1,
				"company Spain Madrid 111 street1 street2", "tags1", "tag2");
		Post p6 = new Post("MSI GTX", 1, 1, 120, "barato", "...", b1, "company Spain Madrid 111 street1 street2",
				"tags1", "tag2");
		Post p7 = new Post("HP PrinterRXW", 1, 1, 520, "barato", "...", b1, "company Spain Madrid 111 street1 street2",
				"tags1", "tag2");
		Post p8 = new Post("HP Printer", 1, 1, 160, "barato", "...", b1, "company Spain Madrid 111 street1 street2",
				"tags1", "tag2");
		user.getPosts().add(p1);
		user.getPosts().add(p2);
		user.getPosts().add(p3);
		user.getPosts().add(p4);
		user.getPosts().add(p5);
		user.getPosts().add(p6);
		user.getPosts().add(p7);
		user.getPosts().add(p8);
		p1.setUser(user);
		p3.setUser(user);
		p5.setUser(user);
		p7.setUser(user);
		p2.setUser(user);
		p4.setUser(user);
		p6.setUser(user);
		p8.setUser(user);
		userRepository.save(user);
		b1.getPosts().add(p1);
		b1.getPosts().add(p2);
		b1.getPosts().add(p3);
		p1.setBrand(b1);
		p2.setBrand(b1);
		p3.setBrand(b2);
		p4.setBrand(b2);
		p5.setBrand(b2);
		p6.setBrand(b2);
		p7.setBrand(b1);
		p8.setBrand(b1);
		brandRepository.save(b1);
		brandRepository.save(b2);

		postRepository.save(p1);
		postRepository.save(p2);
		postRepository.save(p3);
		postRepository.save(p4);
		postRepository.save(p5);
		postRepository.save(p6);
		postRepository.save(p7);
		postRepository.save(p8);

	}

}
