package store.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.dataBase.User;
import store.main.dataBase.UserRepository;

@Controller
public class SellProductController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/sell_product/")
	@JsonView(User.BasicInfo.class)
	public String loadSellProduct(Model model) {
		User u = userRepository.findAll().get(0);
		model.addAttribute("user",u);
		return "user-second-hand-product";
	}

}
