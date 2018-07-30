package com.HandCrest.myMenuApp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Restaurant {

	@Id
	@GeneratedValue
	private Long id;
	
	@Lob
	private String menu;

	public Restaurant(Long id, String menu) {
		this.id = id;
		this.menu = menu;
	}

	public Long getId() {
		return id;
	}

	public String getMenu() {
		return menu;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", menu=" + menu + "]";
	}

}
