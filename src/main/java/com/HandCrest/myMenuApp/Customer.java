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
	private String avi;
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

	public String getAvi() {
		return avi;
	}

	public String getEmail() {
		return email;
	}

	public Customer() {

	}

	public Customer(Long id, String userName, String password, String avi, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.avi = avi;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", avi=" + avi + ", email="
				+ email + "]";
	}

}