package bd.edu.diu.cis.fitnesstracker.repo;

import bd.edu.diu.cis.fitnesstracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
