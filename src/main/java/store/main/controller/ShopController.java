package store.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import store.main.dataBase.Post;
import store.main.dataBase.PostRepository;

@Controller
public class ShopController {

    @Autowired
    PostRepository repository;

    @GetMapping("/shop/")
    public String shop(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String ord) {
        Pageable paging;

        if (ord.equalsIgnoreCase("desc")) {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        }

        Page<Post> p = repository.findAll(paging);

        Long nPost = repository.count();

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("ord", ord);
        model.addAttribute("posts", p);
        model.addAttribute("nPosts", nPost);

        return "shop-style2-ls";
    }

    @GetMapping("/shop/{tag}")
    public String shopByTag(Model model, @PathVariable("tag") Integer tag) {


        List<Post> p = repository.findByComponentTag(tag);

        Long nPost = repository.count();

        model.addAttribute("posts", p);
        model.addAttribute("nPosts", nPost);

		return "shop-style2-ls";
    }
    

}
