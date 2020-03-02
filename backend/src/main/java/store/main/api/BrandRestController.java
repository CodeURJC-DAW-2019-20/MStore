package store.main.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Brand;
import store.main.database.BrandRepository;

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
	
}
