package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public String listUsers(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", userService.listUsers());
		return "users";
	}


	@PostMapping(value = "/add")
	public String add(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/users";
	}


//	@PostMapping(value = "/add")
//	public String add(@ModelAttribute User user) {
//		userService.add(user);
//		return "redirect:/users";
//	}

	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@PostMapping("/edit")
	public String editUser(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/users";
	}

	@GetMapping("/add")
	public String addPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "addPage";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") int id, ModelMap model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		return "editPage";
	}

}