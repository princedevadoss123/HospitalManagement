package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Staff")

public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long S_ID;
	
	@Column(name="S_name",nullable=false,length=30)
	private String S_name;
	
	@Column(name="Specialist",nullable=false,length=30)
	private String Specialist;
	
	@Column(name="Role")
	private int Role;
	
	@Column(name="Password",nullable=false,length=30)
	private String Password;

	public Long getS_ID() {
		return S_ID;
	}

	public void setS_ID(Long s_ID) {
		S_ID = s_ID;
	}

	public String getS_name() {
		return S_name;
	}

	public void setS_name(String s_name) {
		S_name = s_name;
	}

	public String getSpecialist() {
		return Specialist;
	}

	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}

	public int getRole() {
		return Role;
	}

	public void setRole(int role) {
		Role = role;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
