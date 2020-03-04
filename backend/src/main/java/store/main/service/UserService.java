package store.main.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.main.database.User;
import store.main.database.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User updateUser(User updatedUser, User user) throws IOException {

		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		if (!updatedUser.getPassword().equals(""))
			user.setBCryptPassword(updatedUser.getPassword());
		user.setPhone(updatedUser.getPhone());
		user.setUserAddress(updatedUser.getUserAddress());
		user.setCreditCard(updatedUser.getCreditCard());
		userRepository.save(user);
		
		return user;
	}
}
