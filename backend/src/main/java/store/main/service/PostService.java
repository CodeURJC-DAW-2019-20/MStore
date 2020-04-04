package store.main.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import store.main.controller.ComponentController;
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
	
	@Autowired
	private ComponentController comp;

	
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
	
	public void loadRecommendationsIntoBD(HttpServletRequest request, Post post) {
		User user = userRepository.findByEmail(request.getUserPrincipal().getName());
		List<String> userTags = user.getTags();
		loadList(userTags, post);
		user.setTags(userTags);
		userRepository.save(user); // update user tag list
	}
	
	public void loadRecommendationsIntoBD(User user, Post post) {
		List<String> userTags = user.getTags();
		loadList(userTags, post);
		user.setTags(userTags);
		userRepository.save(user); // update user tag list
	}

	public ComponentController getComp() {
		return comp;
	}

	public void setComp(ComponentController comp) {
		this.comp = comp;
	}

	public void loadRecommendationsIntoSession(HttpSession session, Post post) {
		List<String> userTags = (List<String>) session.getAttribute("tags");
		List<String> list = loadList(userTags, post);
		session.setAttribute("tags", list); // update user tag list in session
	}
	
	private List<String> loadList(List<String> userTags, Post post) {

		// Advanced algorithm

		Random r = new Random(); // need a Random to choose the tags of a post
		if (userTags == null) {
			userTags = new LinkedList<>();
		}

		if (userTags.isEmpty()) { // the user enters for the first time and the recommended tags are those of the
									// post he is seeing
			if (post.getTags().size() > 3) {
				while (userTags.size() < 3) {
					userTags.add(post.getTags().get(r.nextInt(post.getTags().size())));
				}
			} else {
				for (String tag : post.getTags()) {
					if (userTags.size() < 3) {
						userTags.add(tag);
					}
				}
				while (userTags.size() < 3) {
					userTags.add(userTags.get(0));
				}
			}
		} else {// if the user has already visited other posts, the user's tags are replaced by
				// more recent tags
			if (post.getTags().size() > 2) {
				int cont = 0;
				while (cont < 2) {
					userTags.add(0, post.getTags().get(r.nextInt(post.getTags().size())));
					cont++;
				}
			} else {
				for (String tag : post.getTags()) {
					userTags.add(0, tag);
				}
			}
			// remove old and unnecessary tags(the user has more than 3 recommended tags)
			if (userTags.size() > 3) {
				List<Integer> removeList = new LinkedList<>();
				for (int i = 3; i < userTags.size(); i++) {
					removeList.add(i);
				}
				for (Integer i : removeList) {
					userTags.remove(i);
				}
			}

		}
		List<Post> postsList = postRepository.findAll();
		/**
		 * Once having the 3 key tags, a maximum of 9 recommended posts are searched.
		 * postList1 stores the key tag 1 postList2 stores the key tag 2 postList3 3
		 * stores the key tag 3
		 */
		for (Post p : postsList) {
			if (p != post) {
				if (p.getTags().contains(userTags.get(0)) && comp.getPostList1().size() < 3 && !comp.getPostList2().contains(p)
						&& !comp.getPostList3().contains(p) && !comp.getPostList1().contains(p)) {
					comp.getPostList1().add(p);
				} else if (p.getTags().contains(userTags.get(1)) && comp.getPostList2().size() < 3 && !comp.getPostList1().contains(p)
						&& !comp.getPostList3().contains(p) && !comp.getPostList2().contains(p)) {
					comp.getPostList2().add(p);
				} else if (p.getTags().contains(userTags.get(2)) && comp.getPostList3().size() < 3 && !comp.getPostList1().contains(p)
						&& !comp.getPostList2().contains(p) && !comp.getPostList3().contains(p)) {
					comp.getPostList3().add(p);
				}
			}
		}
		return userTags;

	}
	
	public void addToRecomendedList(Model model) {
		comp.setFinalList(new LinkedList<>());// reset final list
		comp.getFinalList().addAll(comp.getPostList2());
		comp.getFinalList().addAll(comp.getPostList1());
		comp.getFinalList().addAll(comp.getPostList3());
		model.addAttribute("recomend", !comp.getFinalList().isEmpty()); // there are recommended posts
		model.addAttribute("list", comp.getFinalList());
	}
	
	public void addToRecomendedList() {
		comp.setFinalList(new LinkedList<>());// reset final list
		comp.getFinalList().addAll(comp.getPostList2());
		comp.getFinalList().addAll(comp.getPostList1());
		comp.getFinalList().addAll(comp.getPostList3());
	}
	
	public List<Post> getFinalList(){
		return this.comp.getFinalList();
	}

	public void updateSellers(User loggedUser, User user) {
		if(!this.containSeller(loggedUser, user)) {
			loggedUser.getSellers().add(user);
			
		}
		userRepository.save(loggedUser);
		
	}
	
	private boolean containSeller(User loggedUser,User user) {
		for(User u:loggedUser.getSellers()) {
			if(u.getEmail().equals(user.getEmail())) {
				return true;
			}
		}
		return false;
		
	}
	
	

}
