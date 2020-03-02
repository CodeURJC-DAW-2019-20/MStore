package store.main.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	private ImageService imgService;
	
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
	
	public Post createPost(Post post, @RequestParam String bname,
			@RequestParam List<MultipartFile> imagenFile, User u) throws IOException {

		Brand b = getBrand(bname);
		post.setBrand(b);
		post.setComponentTag(post.getComponent());
		u.getPosts().add(post);
		post.setUser(u);
		postRepository.save(post);

		int aux = 0;
		for (MultipartFile mf : imagenFile)
			if (!mf.getOriginalFilename().equals("")) {
				imgService.saveImage("posts", post.getId(), mf, aux);
				aux++;
			}

		post.setnImg(aux);
		userRepository.save(u);
		b.getPosts().add(post);
		brandRepository.save(b);
		
		return post;
	}

}
