package com.HandCrest.myMenuApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	private String password;
	private String avatar;
	private String email;

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getEmail() {
		return email;
	}

	public Customer() {

	}

	public Customer(Long id, String userName, String password, String avatar, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.avatar = avatar;
		this.email = email;
	}

	@Override
	public String toString() {
		return userName;
	}

}