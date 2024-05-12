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
		return repo.getById(id);
	}
	
	public List<User> getAll (){
		return repo.findAll();
	}
	
	public User edit(User user) {
		User user2 = repo.findById(user.getId()).get();
		user2.setAddress(user.getAddress());
		user2.setEmail(user.getEmail());
		user2.setPhone(user.getUsername());
		user2.setUsername(user.getUsername());
		return repo.save(user2);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
