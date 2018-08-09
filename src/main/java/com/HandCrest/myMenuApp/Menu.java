package com.HandCrest.myMenuApp;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private Long menuId;
	private String menuName;
	@OneToMany(mappedBy = "menu")
	private Collection<Item> items;

	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;

	public Long getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public Menu() {
		
	}
	
	public Menu(String menuName, Restaurant restaurant, Item... items) {
		this.menuName = menuName;
		this.restaurant = restaurant;
		this.items = Arrays.asList(items);
	}

	@Override
	public String toString() {
		return menuName;
	}
}
