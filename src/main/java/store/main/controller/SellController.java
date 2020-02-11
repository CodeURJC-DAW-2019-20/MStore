package store.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import store.main.dataBase.*;
import store.main.service.ImageService;

@Controller
public class SellController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ImageService imgService;

	@PostMapping("/sell")
	public String nuevoAnuncio(Model model, Post post, @RequestParam MultipartFile imagenFile) throws IOException {

		post.setImage(true);

		this.postRepository.save(post);

		imgService.saveImage("posts", post.getId(), imagenFile);

		return "index";

	}

}
