package com.practise.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="jpatest_role")
@SequenceGenerator(sequenceName = "jpatest_role_seq", allocationSize = 1, name = "jparol_seq")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jparol_seq")
	private Long rno;
	
	@Column
	private String role_name;
	
//	@OneToMany(mappedBy = "roles") 
//	private List<User> users;

	
}