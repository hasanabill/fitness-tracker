package bd.edu.diu.cis.fitnesstracker.repo;

import bd.edu.diu.cis.fitnesstracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
