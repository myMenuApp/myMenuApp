package com.HandCrest.myMenuApp;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long itemId;

	private String itemName;

	@Lob
	private String description;

	private BigDecimal price;
	private String picture;
	private int calories;

	@Lob
	private String ingredients;

	@ManyToOne
	@JsonIgnore
	private Menu menu;

/*	@ManyToOne
	private Restaurant restaurant;*/


	public Item(String itemName, String description, BigDecimal price, String picture, int calories,
			String ingredients, Menu menu) {
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.picture = picture;
		this.calories = calories;
		this.ingredients = ingredients;
		this.menu = menu;
	}

/*	public Restaurant getRestaurant() {
		return restaurant;
	}*/


	public Long getItemId() {
		return itemId;
	}

	public Menu getMenu() {
		return menu;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getPicture() {
		return picture;
	}

	public int getCalories() {
		return calories;
	}

	public String getIngredients() {
		return ingredients;
	}

	@Override
	public String toString() {
		return itemName;
	}

}
