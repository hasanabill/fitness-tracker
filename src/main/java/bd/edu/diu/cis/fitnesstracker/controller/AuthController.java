package bd.edu.diu.cis.fitnesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import bd.edu.diu.cis.fitnesstracker.model.User;
import bd.edu.diu.cis.fitnesstracker.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model) {
        model.addAttribute("user", userService.getUserById(1L));
        return "profile";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(Model model, @ModelAttribute("user") User user) {

        User usr = userService.getUserByUsername(user.getUsername());
        if (usr == null) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        } else if (!usr.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        } else {
            model.addAttribute("user", usr);
            return "redirect:/profile";
        }

    }
}