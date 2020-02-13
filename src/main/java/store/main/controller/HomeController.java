package store.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import store.main.service.HomeLoader;

//HomeController is a class that handles the events of the MStore home page. Upload the names, prices and images of user posts.
@Controller
public class HomeController {

	@Autowired
	private HomeLoader hLoader;
	
	@GetMapping("/") // main page
	public String loadHome(Model model) {

		model = hLoader.modelLoader(model);
		return "index";
	}
	

    @GetMapping("/login")
    public String login(Model model) {
    	model.addAttribute("error", false);
    	return "login";
    }
    
    @GetMapping("/loginerror")
    public String loginerror(Model model) {
    	
    	model.addAttribute("error", true);
    	
    	return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	
    	return "index";
    }
    

}
