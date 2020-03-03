package store.main.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.api.BrandRestController.completeBrand;
import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;

@RestController
@RequestMapping("/api/brand")
public class BrandRestController {
	
	@Autowired
	BrandRepository brandRepository;
	
	interface completeBrand extends Brand.BasicInfo,Brand.PostsInfo,Post.BasicInfo {}
	
	@GetMapping("/")
	@JsonView(completeBrand.class)
	public Collection<Brand> getBrands() {
		return brandRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(completeBrand.class)
	public ResponseEntity<Brand> getBrandId(@PathVariable long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		if(brand.isPresent()) {
			return new ResponseEntity<Brand>(brand.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Brand.BasicInfo.class)
	public Brand postBrand(@RequestBody Brand brand) {
		brandRepository.save(brand);
		return brand;
	}
	
	@PutMapping("/{id}")
	@JsonView(completeBrand.class)
	public ResponseEntity<Brand> updateBrand(@RequestBody Brand updatedBrand, @PathVariable long id) {
		
		Optional<Brand> optionalBrand = brandRepository.findById(id);
		
		if (optionalBrand.isPresent()) {
			
			Brand brand = optionalBrand.get();
			
			brand.setName(updatedBrand.getName());
			brandRepository.save(brand);
			
			return new ResponseEntity<>(brand,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
