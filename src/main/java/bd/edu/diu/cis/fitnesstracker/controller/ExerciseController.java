package bd.edu.diu.cis.fitnesstracker.controller;

import bd.edu.diu.cis.fitnesstracker.model.Exercise;
import bd.edu.diu.cis.fitnesstracker.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public String getAllExercises(Model model) {
        List<Exercise> exercises = exerciseService.getAllExercises();
        model.addAttribute("exercises", exercises);
        return "exerciseHome";
    }

    @GetMapping("/new")
    public String createExerciseForm(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "newExercise";
    }

    @PostMapping("/save")
    public String saveExercise(@ModelAttribute Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "redirect:/exercises";
    }

    @GetMapping("/edit/{id}")
    public String editExerciseForm(@PathVariable Long id, Model model) {
        Exercise exercise = exerciseService.getExerciseById(id);
        model.addAttribute("exercise", exercise);
        return "editExercise";
    }

    @PostMapping("/update")
    public String updateExercise(@ModelAttribute Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "redirect:/exercises";
    }

    @GetMapping("/delete/{id}")
    public String deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return "redirect:/exercises";
    }
}
