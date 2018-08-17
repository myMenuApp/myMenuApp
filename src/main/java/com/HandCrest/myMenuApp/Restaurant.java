package com.HandCrest.myMenuApp;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long restaurantId;
	private String restaurantName;
	private String picture;
	@Lob
	private String description;

	@OneToMany(mappedBy = "restaurant")
	private Collection<Menu> menus;

	public Restaurant() {}

	public Restaurant(String restaurantName, String description, String picture, Menu... menus) {
		this.restaurantName = restaurantName;
		this.description = description;
		this.picture = picture;
		this.menus = Arrays.asList(menus);
	}


	public Long getRestaurantId() {
		return restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public String getDescription() {
		return description;
	}

	public String getPicture() {
		return picture;
	}

	public Collection<Menu> getMenus() {
		return menus;
	}

	@Override
	public String toString() {
		return restaurantName;
	}

}
