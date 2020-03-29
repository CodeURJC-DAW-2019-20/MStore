package store.main.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.Rating;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.service.RatingService;
import store.main.service.UserComponent;

@RestController
@RequestMapping("/api/ratings")
public class RatingRestController {
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private UserComponent userComponent;

	interface RatingUsers extends Rating.BasicInfo, Rating.BuyerInfo, Rating.SellerInfo, User.BasicInfo {}
	
	@GetMapping("/{id}")
	@JsonView(RatingUsers.class)
	public ResponseEntity<Rating> getRating(@PathVariable long id) {
		Optional<Rating> rating=ratingRepository.findById(id);
		if(rating.isPresent()) {
			return new ResponseEntity<Rating>(rating.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		}
	}
	
	private boolean checkSellers(List<User> l,User u) {
		for(User user:l) {
			if(user.getId()==u.getId()) {
				return true;
			}
		}
		return false;
	}
	@JsonView(RatingUsers.class)
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) throws IOException {
		User user = userComponent.getLoggedUser();
		if(rating == null||rating.getBuyer() == null || rating.getBuyer().getId()==null ||rating.getSeller() == null|| rating.getSeller().getId() == null || user.getSellers()==null)
			return new ResponseEntity<Rating>(HttpStatus.BAD_REQUEST);
		rating.setId(null);
		if(user.getId()==rating.getBuyer().getId()&&checkSellers(user.getSellers(),rating.getSeller()))
			return new ResponseEntity<Rating>(ratingService.saveRating(rating.getStars()+"", rating.getSeller().getId(), rating.getBuyer().getId()),HttpStatus.CREATED);
		else
			return new ResponseEntity<Rating>(HttpStatus.FORBIDDEN);
	}
}
