package com.practise.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/login")
	public String logForm() {
		return "login";
	}
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestParam("username")String username) {
		
		System.out.println("컨트롤러 파람유저: "+username);

		UserEntity ue = userService.login(username);
		
		if(ue ==null) {
			return "<script>alert('유저가 없습니다.');location.href='login';</script>";
		}
		
		String ueName = ue.getUsername();
		if(!ueName.equals(username)) {
			return "<script>alert('유저가 일치하지 않습니다.');location.href='login';</script>";
		}
		return "<script>location.href='login2';</script>";
	}
	
	@GetMapping("/login2")
	public String log2Form() {
		return "login2";
	}
}
