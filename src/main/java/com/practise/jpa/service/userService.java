package com.practise.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practise.jpa.entity.Role;
import com.practise.jpa.entity.User;
import com.practise.jpa.repository.userRepository;

@Service
public class userService {
	
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public User createUser(User user) {
		Role role = new Role();
		role.setRno(1l); //DB에서 가져오려면 레파지토리를 만들어야되서 간편하게 데리고 오기.
		
		String encodedPassword = passwordEncoder.encode(user.getPassword()) ;
		user.setPassword(encodedPassword);
		user.setEnabled(true);
		return userRepository.save(user);
	}
	
	public User login(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> memberAll(){
		return userRepository.findAll();
	}
}
