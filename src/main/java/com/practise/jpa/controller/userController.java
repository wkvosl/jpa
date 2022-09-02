package com.practise.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.jpa.repository.userRepository;

@RestController
public class userController {

	@Autowired
	private userRepository userRepository;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	@PostMapping("/addmember")
	public String addmember(
			) {
		
		
		return "addmember";
	}
	
}
