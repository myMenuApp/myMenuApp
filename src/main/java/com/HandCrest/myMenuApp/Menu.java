package com.HandCrest.myMenuApp;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	private Long id;
	private String menuName;
	@OneToMany(mappedBy = "item")
	private Collection<Item> items;

	@ManyToOne
	private Restaurant restaurant;

	public Long getId() {
		return id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Collection<Item> getItems() {
		return items;
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
