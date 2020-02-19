package store.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import store.main.database.Post;
import store.main.database.PostRepository;

@Controller
public class AdminController {
	
	@Autowired
	PostRepository postRepository;

	@GetMapping("/admin")
	public String adminPage(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String ord) {
		
		Pageable paging = PageRequest.of(pageNo, 10, Sort.by(sortBy));
		
		Page<Post> posts = postRepository.findAll(paging);
		
		model.addAttribute("posts", posts);
		model.addAttribute("totalPosts", postRepository.count());
		
		return "admin-page";
	}
	
}
