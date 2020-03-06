package store.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.main.database.RatingRepository;
import store.main.database.User;

@Service
public class GraphicService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Integer> createGraph(User u){
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<6;i++)
			l.add(ratingRepository.findBySellerEmailIgnoreCaseAndStars(u.getEmail(), i).size());
		return l;
		
	}
}
