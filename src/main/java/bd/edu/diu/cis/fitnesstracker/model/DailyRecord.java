package bd.edu.diu.cis.fitnesstracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class DailyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double morningWeight;
    private double eveningWeight;
    private double morningWaistSize;
    private double eveningWaistSize;
    private String activityLevel;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Meal> meals;
    @OneToMany
    private List<Exercise> exercises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMorningWeight() {
        return morningWeight;
    }

    public void setMorningWeight(double morningWeight) {
        this.morningWeight = morningWeight;
    }

    public double getEveningWeight() {
        return eveningWeight;
    }

    public void setEveningWeight(double eveningWeight) {
        this.eveningWeight = eveningWeight;
    }

    public double getMorningWaistSize() {
        return morningWaistSize;
    }

    public void setMorningWaistSize(double morningWaistSize) {
        this.morningWaistSize = morningWaistSize;
    }

    public double getEveningWaistSize() {
        return eveningWaistSize;
    }

    public void setEveningWaistSize(double eveningWaistSize) {
        this.eveningWaistSize = eveningWaistSize;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

}
