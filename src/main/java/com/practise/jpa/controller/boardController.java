package com.practise.jpa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class boardController {

	
	@GetMapping("/board/free")
	public String free(HttpSession session) {
		System.out.println(session.getAttribute("sessionId"));
		return "board/free";
	}
	@GetMapping("/board/write")
	public String write(HttpSession session) {
		System.out.println(session.getAttribute("sessionId"));
		return "board/write";
	}
	@PostMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	}
}
