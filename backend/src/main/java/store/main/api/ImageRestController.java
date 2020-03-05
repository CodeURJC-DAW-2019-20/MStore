package store.main.api;

import java.io.File;
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

import store.main.database.*;
import store.main.service.ImageService;
import store.main.service.UserComponent;

@RestController
@RequestMapping("/api")
public class ImageRestController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ImageService imgService;

	@Autowired
	private UserComponent userComponent;

	//User Images REST API methods
	@GetMapping("/user/{id}/image")
	public ResponseEntity<Object> getUserImage(@PathVariable long id) throws IOException {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return new ResponseEntity<Object>(this.imgService.createResponseFromImage("users", id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/user/{id}/image")
	public ResponseEntity<Post> updateUserImage(@PathVariable long id, @RequestParam MultipartFile imagenFile)
			throws IOException {
		return this.imgService.saveUserImage(userRepository, id, imagenFile, userComponent);
	}

	@PostMapping("/user/{id}/image")
	public ResponseEntity<Post> createUserImage(@PathVariable long id, @RequestParam MultipartFile imagenFile)
			throws IOException {
		File file = new File("images/users/image-" + id + ".jpg");
		if (file.exists()) {
			return new ResponseEntity<Post>(HttpStatus.NOT_ACCEPTABLE);
		}
		return imgService.saveUserImage(userRepository, id, imagenFile, userComponent);
	}
	
	//Post Images REST API methods
	
	@GetMapping("/post/{id}/image")
	public ResponseEntity<Collection<Object>> getPostImage(@PathVariable long id) throws IOException {
		Optional<Post> post = postRepository.findById(id);
		List<Object> list = new LinkedList<>();
		if (post.isPresent()) {

			for (int i = 0; i < post.get().getnImg(); i++) {
				list.add((this.imgService).createResponseFromImagePost("posts", id, i));
			}
			if (list.isEmpty()) {
				return new ResponseEntity<Collection<Object>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<Object>>(list, HttpStatus.OK);
		}

		return new ResponseEntity<Collection<Object>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/post/{id}/image")
	public ResponseEntity<Post> newPostImage(@PathVariable long id, @RequestParam MultipartFile imagenFile)
			throws IOException {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			if (userComponent.getLoggedUser().getRoles().contains("ROLE_USER")) {
				if (post.get().getnImg() < 4) {
					imgService.saveImage("posts", post.get().getId(), imagenFile, post.get().getnImg());
					post.get().setnImg(post.get().getnImg() + 1);
					postRepository.save(post.get());
					return new ResponseEntity<>(HttpStatus.CREATED);
				} else {
					return new ResponseEntity<Post>(HttpStatus.INSUFFICIENT_STORAGE);
				}
			} else {
				return new ResponseEntity<Post>(HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/post/{id}-{nimg}/image")
	public ResponseEntity<Post> updatePostImage(@PathVariable long id, @PathVariable Integer nimg, @RequestParam MultipartFile imagenFile)
			throws IOException {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			if (userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN")) {
				if (nimg < 0 || nimg>=post.get().getnImg()) {
					return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
				} else {
					imgService.saveImage("posts", post.get().getId(), imagenFile,nimg);
					postRepository.save(post.get());
					return new ResponseEntity<>(HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<Post>(HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
