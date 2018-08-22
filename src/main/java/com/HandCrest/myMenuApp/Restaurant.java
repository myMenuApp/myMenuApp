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
	private String restaurantPhone;
	private String restaurantWeb;
	private String restaurantAddress;
	private String RestaurantMap;
	
	@OneToMany(mappedBy = "restaurant")
	private Collection<Menu> menus;

	public Restaurant() {

	}
	public Restaurant(String restaurantName, Menu... menus) {
		this.restaurantName = restaurantName;
		this.menus = Arrays.asList(menus);
	}
	public Restaurant(String restaurantName, String restaurantDescription, String restaurantHours, String restaurantLogo, String restaurantPhone,
			String restaurantWeb, String restaurantAddress, String restaurantMap, Menu... menus) {
		this.restaurantName = restaurantName;
		this.menus = Arrays.asList(menus);
		this.restaurantDescription = restaurantDescription;
		this.restaurantHours = restaurantHours;
		this.restaurantLogo = restaurantLogo;
		this.restaurantPhone = restaurantPhone;
		this.restaurantWeb = restaurantWeb;
		this.restaurantAddress = restaurantAddress; 
		this.RestaurantMap = restaurantMap;
	}
	


	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public String getRestaurantWeb() {
		return restaurantWeb;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public String getRestaurantMap() {
		return RestaurantMap;
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
