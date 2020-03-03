package store.main.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.main.database.*;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private PostService postService;
	
	public void deleteBrandFromDB(Brand brand) {
		
		List<Post> list=new LinkedList<Post>();
		for(Post p:brand.getPosts()) {
			list.add(p);
		}
		for(Post p:list) {
				postService.deletePostFromBD(p);
		}
		brandRepository.delete(brand);
		
	}

}

