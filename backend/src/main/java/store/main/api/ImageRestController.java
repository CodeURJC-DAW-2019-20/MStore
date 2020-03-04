package store.main.api;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import store.main.database.*;
import store.main.service.ImageService;

@RestController
@RequestMapping("/api/image")
public class ImageRestController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ImageService imgService;

	@GetMapping("/post/{id}")
	public ResponseEntity<Collection<Object>> getPostImage(@PathVariable long id) throws IOException {
		Optional<Post> post = postRepository.findById(id);
		List<Object> list = new LinkedList<>();
		if (post.isPresent()) {

			for (int i = 0; i < post.get().getnImg(); i++) {
				list.add((this.imgService).createResponseFromImagePost("posts", id, i));
			}
			if(list.isEmpty()) {
				return new ResponseEntity<Collection<Object>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<Object>>(list,HttpStatus.OK);
		}

		return new ResponseEntity<Collection<Object>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUserImage(@PathVariable long id) throws IOException {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<Object>(this.imgService.createResponseFromImage("users", id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Post> updateUserImage(@PathVariable long id, @RequestParam MultipartFile imagenFile)
			throws IOException {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			imgService.saveImage("users", user.get().getId(), imagenFile, null);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/post/{id}")
	public ResponseEntity<Post> newPostImage(@PathVariable long id, @RequestParam MultipartFile imagenFile)
			throws IOException {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			if(post.get().getnImg()<3) {
				imgService.saveImage("posts", post.get().getId(), imagenFile, post.get().getnImg());
				post.get().setnImg(post.get().getnImg() + 1);
				postRepository.save(post.get());
			return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<Post>(HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

