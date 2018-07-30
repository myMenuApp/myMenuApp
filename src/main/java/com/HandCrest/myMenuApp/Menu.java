package com.HandCrest.myMenuApp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Menu {

	private Long id;
	private String restaurant;

	@OneToMany(mappedBy = "item") // updated
	private Collection<Item> items;

	public Menu(Long id, String restaurant, Collection<Item> items) {
		this.id = id;
		this.restaurant = restaurant;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public Collection<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", restaurant=" + restaurant + ", items=" + items + "]";
	}

}
