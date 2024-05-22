package bd.edu.diu.cis.fitnesstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bd.edu.diu.cis.fitnesstracker.UserService;
import bd.edu.diu.cis.fitnesstracker.model.User;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public String viewUser(Model model) {
        List<User> users = service.getAll();
        model.addAttribute("users", users);
        return "userHome";
    }

    @GetMapping("/user/new")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.find(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/updateuser")
    public String updateUser(@ModelAttribute("user") User user) {
        if (user.getId() != 0) {
            service.edit(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
