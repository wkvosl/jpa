package com.practise.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.jpa.entity.UserEntity;
import com.practise.jpa.repository.userRepository;

@Service
public class userService {
	
	@Autowired
	private userRepository userRepository;

	public UserEntity createUser(UserEntity user) {
		return userRepository.save(user);
	}
	
	public UserEntity login(String username) {
		return userRepository.findByUsername(username);
	}
}
