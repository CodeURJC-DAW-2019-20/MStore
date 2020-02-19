package store.main.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import store.main.database.Post;

@Component
@SessionScope
public class Cart {

	public void addToCart(Post post, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new LinkedList<Post>());
		}

		List<Post> list = (List<Post>) session.getAttribute("cart");
		long total = (long) session.getAttribute("total");

		if (!list.contains(post)) {
			total += post.getPrice();
			list.add(post);
		}

		session.setAttribute("total", total);
		session.setAttribute("cart", list);
		session.setAttribute("empty", list.isEmpty());
	}

	public void removeFromCart(Post post, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new LinkedList<Post>());
		}

		List<Post> list = (List<Post>) session.getAttribute("cart");
		long total = (long) session.getAttribute("total");

		if (list.contains(post)) {
			list.remove(post);
			total -= post.getPrice();
		}
		session.setAttribute("total", total);
		session.setAttribute("cart", list);
		session.setAttribute("empty", list.isEmpty());
	}

	public void cartInit(HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Post> list = new ArrayList<Post>();
			long total = 0;
			boolean empty = true;
			session.setAttribute("cart", list);
			session.setAttribute("empty", empty);
			session.setAttribute("total", total);
		}
	}
}
