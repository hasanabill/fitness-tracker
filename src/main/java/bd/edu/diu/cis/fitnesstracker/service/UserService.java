package bd.edu.diu.cis.fitnesstracker.service;

import bd.edu.diu.cis.fitnesstracker.model.User;
import bd.edu.diu.cis.fitnesstracker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
