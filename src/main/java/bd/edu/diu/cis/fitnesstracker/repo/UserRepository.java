package bd.edu.diu.cis.fitnesstracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bd.edu.diu.cis.fitnesstracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long >{

}
