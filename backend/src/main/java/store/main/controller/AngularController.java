package store.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

	@GetMapping("/new/") // main page
	public String loadNewHome() {
		return "/new/index.html";
	}
	
	@GetMapping("/new") // main page
	public String loadNewHome2() {
		return "/new/index.html";
	}
	
	
}
