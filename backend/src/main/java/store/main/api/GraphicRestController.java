package store.main.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import store.main.database.User;
import store.main.database.UserRepository;
import store.main.service.GraphicService;

@RestController
public class GraphicRestController {
	
	@Autowired
	private GraphicService graphicService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/graphics/{id}")
	public ResponseEntity<List<Integer>> getGraphic (@PathVariable("id") long id){
		Optional<User> u = userRepository.findById(id);
		if(u.isPresent())
			return new ResponseEntity<List<Integer>>(graphicService.createGraph(u.get()),HttpStatus.OK);
		else 
			return new ResponseEntity<List<Integer>>(HttpStatus.NOT_FOUND);
	}
}
