package com.practise.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "jpaTest")
@SequenceGenerator(sequenceName = "jpaTest_seq", allocationSize = 1, name = "jpaSeq")
public class UserEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "japSeq")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	
	
}
