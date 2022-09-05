package com.practise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.jpa.entity.User;

@Repository
public interface userRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
