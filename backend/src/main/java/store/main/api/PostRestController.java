package store.main.api;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.User;
import store.main.service.PostService;
import store.main.service.UserComponent;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {

	@Autowired
	private PostService postService;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private UserComponent userComponent;

	interface PostDetail extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo {
	}
	
	interface PostExtended extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo, Post.TagsInfo, Post.UserInfo, User.BasicInfo {
	}	

	interface CompletePost
			extends Post.BasicInfo, Post.BrandInfo, Brand.BasicInfo, Post.TagsInfo, Post.UserInfo, User.BasicInfo, User.ListInfo {
	}
	
	private boolean isNumber(String input){
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	@JsonView(CompletePost.class)
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") String input,HttpSession session) {
		long id;
		Post post ;
		if(isNumber(input)) {
			id = Integer.parseInt(input);
			Optional<Post> paux = postRepository.findById(id);
			if(paux.isPresent()) {
				post=paux.get();
			} else {
				post=null;
			}
		}else {
			post = postRepository.findByName(input);
		}
		if (post!=null) {
			postService.getComp().setPostList1(new LinkedList<>());
			postService.getComp().setPostList2(new LinkedList<>());
			postService.getComp().setPostList3(new LinkedList<>());
			if(userComponent.isLoggedUser()) {
				User user = userComponent.getLoggedUser();
				try {
					postService.loadRecommendationsIntoBD(user, post);
				}
				catch(Exception e) {
					user.setTags(new LinkedList<>());
					postService.loadRecommendationsIntoBD(user, post);
				}
			} else {
				postService.loadRecommendationsIntoSession(session, post);
			}
			postService.addToRecomendedList();
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@JsonView(PostExtended.class)
	@PostMapping("/")
	public ResponseEntity<Post> createPost(@RequestBody Post post) throws IOException {
		
		if (!checkCompletePost(post)) {
			return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
		}
		
		post.setId(null);
		post.setnImg(0);
			
		Post newPost = postService.createPost(post, post.getBrand().getName(), userComponent.getLoggedUser());
		
		return new ResponseEntity<Post>(newPost, HttpStatus.CREATED);

	}

	@JsonView(CompletePost.class)
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable long id) throws IOException {

		if (!checkCompletePost(post)) {
			return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Post> oldPost = postRepository.findById(id);

		if (oldPost.isPresent()) {
			post.setnImg(oldPost.get().getnImg());
			Post updatedPost = postService.setUpdatedPost(post, post.getBrand().getName(), id);

			return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
		} else {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
	}

	
	public ResponseEntity<List<Post>> aux(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String ord) {
		Pageable paging;

		if (ord.equalsIgnoreCase("desc")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		}

		Page<Post> p = postRepository.findAll(paging);

		List<Post> list = p.getContent();

		if (list.isEmpty())
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}


	@JsonView(PostDetail.class)
	@GetMapping("/")
	public ResponseEntity<List<Post>> getPost(Model model, @RequestParam(defaultValue = "-1") Integer tag,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String ord) {

		if (tag == -1) {
			return aux(model, pageNo, pageSize, sortBy, ord);
		}
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

		if (pageNo > maxPages)
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

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

	@JsonView(PostDetail.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable long id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			postService.deletePostFromBD(post.get());
			return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
	}
	@JsonView(PostDetail.class)
	@GetMapping("/top_products")
	public Collection<Post> recommendPost(){
		return postService.getFinalList();
	}
	
	
	private boolean checkCompletePost(Post post) {
		
		if (post.getName() == null || post.getComponent() == null || post.getBrand() == null ||
				post.getBrand().getName()==null || post.getPostAddress() == null || post.getPrice() == null || post.getDetails() == null) {
			return false;
		}
		
		if(brandRepository.findByName(post.getBrand().getName())==null)
			return false;
		
		return true;
	}
}
