package bd.edu.diu.cis.fitnesstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	@GetMapping("/userhome")
	public String showUserHome() {
		return "userHome";
	}
	
	
	
}
