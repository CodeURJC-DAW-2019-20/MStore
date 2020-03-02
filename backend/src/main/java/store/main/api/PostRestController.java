package store.main.api;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	interface PostDetail extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo {}
	
	interface CompletePost extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo,  Post.TagsInfo, Post.UserInfo, User.BasicInfo {}
	
	@JsonView(CompletePost.class)
	@GetMapping("/{id}")
	public Post getPost(@PathVariable("id") long id) {
		return postRepository.findById(id).get();
	}
	
	@JsonView(CompletePost.class)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Post createPost(@RequestBody Post post,  HttpServletRequest request) throws IOException {
		return postService.createPost(post, post.getBrand().getName(), new LinkedList<MultipartFile>(), userRepository.findByEmail(request.getUserPrincipal().getName()));

	}
	
}
