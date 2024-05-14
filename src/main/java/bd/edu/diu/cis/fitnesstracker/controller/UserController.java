package bd.edu.diu.cis.fitnesstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import bd.edu.diu.cis.fitnesstracker.UserService;
import bd.edu.diu.cis.fitnesstracker.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public String showUsers() {
        return "userHome";
    }

    @GetMapping("/user/new")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "userHome";
    }

    @RequestMapping("/users")
    public String viewUser(Model model) {
        List<User> users = service.getAll();
        model.addAttribute("users", users);
        return "userHome";
    }

}
