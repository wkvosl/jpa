package com.practise.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practise.jpa.entity.User;
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
	public String addmember(User user) {
		userService.createUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String logForm(HttpServletRequest request) {
		String refrere = request.getHeader("Referer");
		request.getSession().setAttribute("sessionId", refrere);
		return "login";
	}
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestParam("username")String username,
			
			HttpSession session, HttpServletRequest request) {
		
		System.out.println("컨트롤러 파람유저: "+username);

		User ue = userService.login(username);
		
		
		if(ue ==null) {
			return "<script>alert('유저가 없습니다.');location.replace('/login');</script>";
		}
	
		
		String ueName = ue.getUsername();
		if(!ueName.equals(username)) {
			return "<script>alert('유저가 일치하지 않습니다.');location.replace('/login');</script>";
		}
		
		session.setAttribute("sessionId", username);
		
		return "<script>location.replace('/login2');</script>";
	}
	
	@GetMapping("/login2")
	public String log2Form(HttpSession session) {
		
		session.getAttribute("sessionId");
		
		return "login2";
	}
	
	@GetMapping("/member")
	public List<User> member(Model model){
		
		List<User> list =  userService.memberAll();
		model.addAttribute("list", list) ;
		return list ;
	}
	
}
