package com.practise.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.practise.jpa.entity.UserEntity;
import com.practise.jpa.service.userService;

@Controller
public class userController {

	@Autowired
	private userService userService;
	
	@GetMapping({"/","/home"})
	public String homeForm() {
		return "home";
	}

	@GetMapping("/addmember")
	public String joinForm() {
		return "addmember";
	}
	
	@PostMapping("/addmember")
	public String addmember(UserEntity user) {
		userService.createUser(user);
		return "redirect:/";
	}
	
	
}
