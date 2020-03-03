package store.main.api;

import java.io.IOException;
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

	interface RatingUsers extends Rating.BasicInfo, Rating.BuyerInfo, Rating.SellerInfo, User.BasicInfo {
		
	}
	
	@JsonView(RatingUsers.class)
	@GetMapping("/")
	public List<Rating> getRating(){
		return ratingRepository.findAll();
	}
	@JsonView(RatingUsers.class)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Rating createPost(@RequestBody Rating rating) throws IOException {
		return ratingService.saveRating(rating.getStars()+"", rating.getSeller().getId(), rating.getBuyer().getId());
	}
	
}
