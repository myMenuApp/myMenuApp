package com.HandCrest.myMenuApp;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long restaurantId;
	private String restaurantName;
	private String restaurantDescription;
	private String restaurantHours;
	private String restaurantLogo;
	
	@OneToMany(mappedBy = "restaurant")
	private Collection<Menu> menus;

	public Restaurant() {

	}

	public Restaurant(String restaurantName, Menu... menus) {
		this.restaurantName = restaurantName;
		this.menus = Arrays.asList(menus);
	}
	public Restaurant(String restaurantName, String restaurantDescription, String restaurantHours, String restaurantLogo, Menu... menus) {
		this.restaurantName = restaurantName;
		this.restaurantDescription = restaurantDescription;
		this.restaurantHours = restaurantHours;
		this.restaurantLogo = restaurantLogo;
		this.menus = Arrays.asList(menus);
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	
	public String getRestaurantDescription() {
		return restaurantDescription;
	}

	public String getRestaurantHours() {
		return restaurantHours;
	}

	public String getRestaurantLogo() {
		return restaurantLogo;
	}

	public Collection<Menu> getMenus() {
		return menus;
	}

	@Override
	public String toString() {
		return restaurantName;
	}

}
