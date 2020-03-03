package store.main.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;

@RestController
@RequestMapping("/api/brand")
public class BrandRestController {
	
	@Autowired
	BrandRepository brandRepository;

	@GetMapping("/")
	@JsonView(Brand.BasicInfo.class)
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Brand.BasicInfo.class)
	public Brand postBrand(@RequestBody Brand brand) {
		brandRepository.save(brand);
		return brand;
	}
	
	
}
