package store.main.api;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Rating;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingRestController {
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private RatingRepository ratingRepository;

	interface RatingUsers extends Rating.BasicInfo, Rating.BuyerInfo, Rating.SellerInfo, User.BasicInfo {}
	
	
	@GetMapping("/")
	@JsonView(RatingUsers.class)
	public Collection<Rating> getBrands() {
		return ratingRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(RatingUsers.class)
	public ResponseEntity<Rating> getBrandId(@PathVariable long id) {
		Optional<Rating> rating=ratingRepository.findById(id);
		if(rating.isPresent()) {
			return new ResponseEntity<Rating>(rating.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(RatingUsers.class)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Rating createPost(@RequestBody Rating rating) throws IOException {
		return ratingService.saveRating(rating.getStars()+"", rating.getSeller().getId(), rating.getBuyer().getId());
	}
	
	@JsonView(RatingUsers.class)
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating updatedRating, @PathVariable long id) {
		
		Optional<Rating> optionalRating = ratingRepository.findById(id);
		
		if (optionalRating.isPresent()) {
			
			Rating rating = optionalRating.get();
			
			rating.setStars(updatedRating.getStars());
			ratingRepository.save(rating);
			
			return new ResponseEntity<Rating>(rating, HttpStatus.OK);
		} else {
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		}
	}
	
	@JsonView(RatingUsers.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Rating> deleteRating(@PathVariable long id){
		Optional<Rating> rating = ratingRepository.findById(id);
		if(rating.isPresent()) {
		ratingService.deleteRatingFromDB(rating.get());
		return new ResponseEntity<Rating>(rating.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		}
	}

	
}
