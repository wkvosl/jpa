package com.practise.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.jpa.entity.UserEntity;

@Repository
public interface userRepository extends JpaRepository<UserEntity, Long>{

	//Optional<UserEntity> findByUsername(String username);
	
}
