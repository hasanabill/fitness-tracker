package bd.edu.diu.cis.fitnesstracker.controller;

import bd.edu.diu.cis.fitnesstracker.model.Meal;
import bd.edu.diu.cis.fitnesstracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public String getAllMeals(Model model) {
        List<Meal> meals = mealService.getAllMeals();
        model.addAttribute("meals", meals);
        return "mealHome";
    }

    @GetMapping("/new")
    public String createMealForm(Model model) {
        model.addAttribute("meal", new Meal());
        return "newMeal";
    }

    @PostMapping("/save")
    public String saveMeal(@ModelAttribute Meal meal) {
        mealService.saveMeal(meal);
        return "redirect:/meals";
    }

    @GetMapping("/edit/{id}")
    public String editMealForm(@PathVariable Long id, Model model) {
        Meal meal = mealService.getMealById(id);
        model.addAttribute("meal", meal);
        return "editMeal";
    }

    @PostMapping("/update")
    public String updateMeal(@ModelAttribute Meal meal) {
        mealService.saveMeal(meal);
        return "redirect:/meals";
    }

    @GetMapping("/delete/{id}")
    public String deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
        return "redirect:/meals";
    }
}
