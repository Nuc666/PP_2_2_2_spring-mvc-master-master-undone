package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/Hello")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	@Controller
	@RequestMapping("/users")
	public class UsersController {

		@Autowired
		UserService service;


		@GetMapping("/")
		public String getAllUsers(ModelMap map) {
			map.addAttribute("users", service.listUsers());
			return "users";
		}
	}
}