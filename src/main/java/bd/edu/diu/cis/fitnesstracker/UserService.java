package bd.edu.diu.cis.fitnesstracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bd.edu.diu.cis.fitnesstracker.model.User;
import bd.edu.diu.cis.fitnesstracker.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public User save(User user) {
		return repo.save(user);
	}

	public User find(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<User> getAll() {
		return repo.findAll();
	}

	public User edit(User user) {
		User existingUser = repo.findById(user.getId()).orElse(null);
		if (existingUser != null) {
			existingUser.setAddress(user.getAddress());
			existingUser.setEmail(user.getEmail());
			existingUser.setPhone(user.getPhone());
			existingUser.setUsername(user.getUsername());
			return repo.save(existingUser);
		}
		return null;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
