package store.main.controller;

import java.util.LinkedList;
import java.util.List;

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

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;

@Controller
public class ShopController {

	@Autowired
	PostRepository repository;

	@Autowired
	private BrandRepository brandRepository;

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
		Integer maxPages = (int) (nPost / 10);
		boolean viewMore = nPost > 10;

		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("ord", ord);
		model.addAttribute("withTag", false);
		model.addAttribute("posts", p);
		model.addAttribute("nPosts", nPost);
		model.addAttribute("maxPages", maxPages);
		model.addAttribute("viewMore", viewMore);

		return "shop-style2-ls";
	}

	@GetMapping("/shop/{tag}")
	public String shopByTag(Model model, @PathVariable("tag") Integer tag,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String ord) {

		List<Post> p = new LinkedList<>();

		if (sortBy.equalsIgnoreCase("price")) {
			if (ord.equalsIgnoreCase("asc")) {
				p = repository.findByComponentTagOrderByPriceAsc(tag);

			} else if (ord.equalsIgnoreCase("desc")) {
				p = repository.findByComponentTagOrderByPriceDesc(tag);
			}
		} else if (sortBy.equalsIgnoreCase("name")) {
			if (ord.equalsIgnoreCase("asc")) {
				p = repository.findByComponentTagOrderByNameAsc(tag);

			} else if (ord.equalsIgnoreCase("desc")) {
				p = repository.findByComponentTagOrderByNameDesc(tag);
			}
		} else {
			p = repository.findByComponentTag(tag);
		}

		Integer nPost = p.size();
		boolean zeroPost = nPost == 0;
		Integer maxPages = nPost / 10;

		Integer ini = pageNo * 10;
		Integer fin;
		if (pageNo == maxPages) {
			fin = nPost;
		} else {
			fin = ini + 10;
		}
		List<Post> posts = p.subList(ini, fin);
		boolean viewMore = nPost > 10;

		model.addAttribute("posts", posts);
		model.addAttribute("nPosts", nPost);
		model.addAttribute("withTag", true);
		model.addAttribute("numberT", tag);

		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("ord", ord);
		model.addAttribute("zeroPost", zeroPost);
		model.addAttribute("maxPages", maxPages);
		model.addAttribute("viewMore", viewMore);

		return "shop-style2-ls";
	}

	@GetMapping("/shop/brand/{name}")
	public String shopByBrand(Model model, @PathVariable("name") String name,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String ord) {

		Brand b = brandRepository.findFirstByNameIgnoreCase(name);
		List<Post> posts = new LinkedList<>();

		if (sortBy.equalsIgnoreCase("price")) {
			if (ord.equalsIgnoreCase("asc")) {
				posts = repository.findByBrandOrderByPriceAsc(b);
			} else if (ord.equalsIgnoreCase("desc")) {
				posts = repository.findByBrandOrderByPriceDesc(b);
			}
		} else if (sortBy.equalsIgnoreCase("name")) {
			if (ord.equalsIgnoreCase("asc")) {
				posts = repository.findByBrandOrderByNameAsc(b);
			} else if (ord.equalsIgnoreCase("desc")) {
				posts = repository.findByBrandOrderByNameDesc(b);
			}
		} else {
			posts = b.getPosts();
		}

		Integer nPost = posts.size();
		boolean zeroPost = nPost == 0;
		Integer maxPages = nPost / 10;

		Integer ini = pageNo * 10;
		Integer fin;
		if (pageNo >= maxPages) {
			fin = nPost;
		} else {
			fin = ini + 10;
		}
		List<Post> p = new LinkedList<>();
		if (!(ini > fin)) {
			p = posts.subList(ini, fin);
		}

		boolean viewMore = nPost > 10;

		model.addAttribute("posts", p);
		model.addAttribute("nPosts", nPost);
		model.addAttribute("nameBrand", name);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("ord", ord);
		model.addAttribute("zeroPost", zeroPost);
		model.addAttribute("maxPages", maxPages);
		model.addAttribute("viewMore", viewMore);

		return "shop-brand";
	}

}
