package store.main.api;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;

@RestController
@RequestMapping("/api/brands")
public class BrandRestController {

	@Autowired
	BrandRepository brandRepository;
	
	interface CompleteBrand extends Brand.BasicInfo,Brand.PostsInfo,Post.BasicInfo {}
	
	@GetMapping("/")
	@JsonView(CompleteBrand.class)
	public Collection<Brand> getBrands() {
		return brandRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(CompleteBrand.class)
	public ResponseEntity<Brand> getBrandId(@PathVariable long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		if(brand.isPresent()) {
			return new ResponseEntity<Brand>(brand.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
		}
	}
}
