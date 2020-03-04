package store.main.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.User;
import store.main.database.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private BrandRepository brandRepository;
		
	@Autowired
	private UserRepository userRepository;

	
	private Brand getBrand(String name) {
		Brand b = brandRepository.findFirstByNameIgnoreCase(name);
		if (b == null) {
			b = new Brand(name);
			brandRepository.save(b);
		}
		return b;
	}
	
	public Post createPost(Post post, @RequestParam String bname, User u) throws IOException {

		Brand b = getBrand(bname);
		post.setBrand(b);
		post.setComponentTag(post.getComponent());
		u.getPosts().add(post);
		post.setUser(u);
		postRepository.save(post);

		userRepository.save(u);
		b.getPosts().add(post);
		brandRepository.save(b);
		
		return post;
	}
	
	public Post setUpdatedPost(Post post, @RequestParam String bname, Long id) throws IOException {

		Brand b = getBrand(bname);
				
		Post oldPost = postRepository.findById(id).get();

		User user = oldPost.getUser();

		post.setBrand(b);
		post.setUser(user);
		post.setComponentTag(post.getComponent());
		post.setId(oldPost.getId());
		post.setPostAddress(oldPost.getPostAddress());

		postRepository.save(post);
		
		return post;
	}
	
	public void deletePostFromBD(Post p) {
		Brand b = brandRepository.findByName(p.getBrand().getName());
		b.getPosts().remove(p);
		brandRepository.save(b);

		User u = userRepository.findByEmail(p.getUser().getEmail());
		u.getPosts().remove(p);
		userRepository.save(u);

		postRepository.delete(p);
	}

}
