package com.HandCrest.myMenuApp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private Long menuId;
	private String menuName;
	
	@OneToMany(mappedBy = "menu")
	private Collection<Item> items;

	@ManyToOne
	private Restaurant restaurant;

	public Long getMenuId() {
		return menuId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public String getMenuName() {
		return menuName;
	}
	
	public Menu() {
		
	}

	public Menu(String menuName, Restaurant  restaurant) {
		this.menuName = menuName;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return menuName;
	}
}
