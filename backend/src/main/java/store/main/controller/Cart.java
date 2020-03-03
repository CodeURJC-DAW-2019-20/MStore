package store.main.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import store.main.database.Post;
import store.main.service.CartService;

@Component
@SessionScope
public class Cart {
	
	@Autowired
	CartService cService;
	
	boolean emptyCart;
	long totalprice;
	List<Post> elements;
	
	
	public Cart() {
		this.emptyCart=true;
		this.elements=new LinkedList<Post>();
		this.totalprice=0;
	}
	
	public boolean Load(HttpSession session) {
		if (session.getAttribute("cart")!=null) {
			this.elements=(List<Post>) session.getAttribute("cart");
			this.totalprice=(long) session.getAttribute("total");
			this.emptyCart=(boolean) session.getAttribute("empty");
			return true;
		}
		else {
			return false;
		}
	}
}