package store.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.main.database.Rating;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;

@Service
public class RatingService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating saveRating(String stars, long idSeller, long idBuyer) {
		Optional<User> us = userRepository.findById(idSeller);
		Optional<User> ub = userRepository.findById(idBuyer);

		Rating r = new Rating(Integer.parseInt(stars));
		r.setSeller(us.get());
		r.setBuyer(ub.get());
		ratingRepository.save(r);

		ub.get().getSellers().remove(us.get());
		userRepository.save(ub.get());
		
		return r;
	}
}
