package bd.edu.diu.cis.fitnesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bd.edu.diu.cis.fitnesstracker.model.User;
import bd.edu.diu.cis.fitnesstracker.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class JSONController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        System.out.println("Fetching user with username: " + username);
        User user = userService.getUserByUsername(username);
        System.out.println("User fetched: " + user);
        return user;
    }
}
