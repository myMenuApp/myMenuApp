package com.HandCrest.myMenuApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager {

	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	private String password;
	private String restaurant;

	public Manager() {

	}

	public Manager(Long id, String userName, String password, String restaurant) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.restaurant = restaurant;

	}
	
	public Manager(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRestaurant() {
		return restaurant;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", userName=" + userName + ", password=" + password + ", restaurant=" + restaurant
				+ "]";
	}

	
}
