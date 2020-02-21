package store.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import store.main.database.PostRepository;
import store.main.service.LoaderService;

@Controller
public class AdminController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	LoaderService loaderService;

	@GetMapping("/admin")
	public String adminPage(Model model, HttpServletRequest request) {
		
		model = loaderService.userLoader(model, request);
		model = loaderService.postLoader(model);
		
		return "admin-page";
	}
	
}
