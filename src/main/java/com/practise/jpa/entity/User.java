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
@Table(name = "jpatest")
@SequenceGenerator(sequenceName = "jpatestseq", allocationSize = 1, name = "jpaseq")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaseq")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean enabled;
	
	@Column(nullable = false, columnDefinition = "varchar2(20) default 'role_user'")
	private String Rolename;
	
	@Column(columnDefinition = "Date default sysdate")
	private String createDate;
	
	
//	@OneToMany
//	@JoinTable(
//			name = "jpatest_role",
//			joinColumns = @JoinColumn(name = "id"))
//	private List<Role> roles = new ArrayList<>();

}
