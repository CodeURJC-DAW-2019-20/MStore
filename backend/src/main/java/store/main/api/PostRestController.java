package store.main.api;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.PostService;
import store.main.service.UserComponent;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserComponent userComponent;

	@Autowired
	private BrandRepository brandRepository;
	
	interface PostDetail extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo {}
	
	interface CompletePost extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo,  Post.TagsInfo, Post.UserInfo, User.BasicInfo {}
	
	@JsonView(CompletePost.class)
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") long id) {

		Optional<Post> post = postRepository.findById(id);
		
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(CompletePost.class)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Post createPost(@RequestBody Post post) throws IOException {
		return postService.createPost(post, post.getBrand().getName(), new LinkedList<MultipartFile>(), userComponent.getLoggedUser());
	}
	
	@JsonView(CompletePost.class)
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable long id) throws IOException {
		
		Optional<Post> oldPost = postRepository.findById(id);
		
		if (oldPost.isPresent()) {
			
			Post updatedPost = postService.setUpdatedPost(post, post.getBrand().getName(), new LinkedList<MultipartFile>(), id);
			
			return new ResponseEntity<>(updatedPost, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(CompletePost.class)
	@GetMapping("/")
	public ResponseEntity<List<Post>> shop(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String ord, HttpServletRequest request, HttpSession session) {
		Pageable paging;

		if (ord.equalsIgnoreCase("desc")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		}

		Page<Post> p = postRepository.findAll(paging);
		
		List<Post> list = p.getContent();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@JsonView(PostDetail.class)
	@GetMapping("/brand/{name}")
	public ResponseEntity<List<Post>> shopByBrand(Model model, @PathVariable("name") String name,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String ord,
			HttpServletRequest request, HttpSession session) {

		Brand b = brandRepository.findFirstByNameIgnoreCase(name);
		List<Post> posts = new LinkedList<>();

		if (sortBy.equalsIgnoreCase("price")) {
			if (ord.equalsIgnoreCase("asc")) {
				posts = postRepository.findByBrandOrderByPriceAsc(b);
			} else if (ord.equalsIgnoreCase("desc")) {
				posts = postRepository.findByBrandOrderByPriceDesc(b);
			}
		} else if (sortBy.equalsIgnoreCase("name")) {
			if (ord.equalsIgnoreCase("asc")) {
				posts = postRepository.findByBrandOrderByNameAsc(b);
			} else if (ord.equalsIgnoreCase("desc")) {
				posts = postRepository.findByBrandOrderByNameDesc(b);
			}
		} else {
			posts = b.getPosts();
		}

		Integer nPost = posts.size();
		Integer maxPages = nPost / 10;

		Integer ini = pageNo * 10;
		Integer fin;
		if (pageNo >= maxPages) {
			fin = nPost;
		} else {
			fin = ini + 10;
		}
		List<Post> p = new LinkedList<>();
		if (!(ini > fin)) {
			p = posts.subList(ini, fin);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@JsonView(PostDetail.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable long id){
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			postService.deletePostFromBD(post.get());
			return new ResponseEntity<Post>(post.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
	}

/*
	@JsonView(PostDetail.class)
	@GetMapping("/{tag}")
	public ResponseEntity<List<Post>> shopByTag(Model model, @PathVariable("tag") Integer tag,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String ord,
			HttpServletRequest request, HttpSession session) {

		List<Post> p = new LinkedList<>();

		if (sortBy.equalsIgnoreCase("price")) {
			if (ord.equalsIgnoreCase("asc")) {
				p = postRepository.findByComponentTagOrderByPriceAsc(tag);

			} else if (ord.equalsIgnoreCase("desc")) {
				p = postRepository.findByComponentTagOrderByPriceDesc(tag);
			}
		} else if (sortBy.equalsIgnoreCase("name")) {
			if (ord.equalsIgnoreCase("asc")) {
				p = postRepository.findByComponentTagOrderByNameAsc(tag);

			} else if (ord.equalsIgnoreCase("desc")) {
				p = postRepository.findByComponentTagOrderByNameDesc(tag);
			}
		} else {
			p = postRepository.findByComponentTag(tag);
		}

		Integer nPost = p.size();
		Integer maxPages = nPost / 10;

		Integer ini = pageNo * 10;
		Integer fin;
		if (pageNo == maxPages) {
			fin = nPost;
		} else {
			fin = ini + 10;
		}
		List<Post> posts = p.subList(ini, fin);

		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	*/
}
