package com.HandCrest.myMenuApp;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	private String itemName;

	@Lob
	private String description;

	private BigDecimal price;
	private String picture;
	private int calories;

	@Lob
	private String ingredients;

	@ManyToOne
	private Menu menu;

	public Item() {
	}

	public Item(String itemName, String description, BigDecimal price, String picture, int calories,
			String ingredients) {

	}

	public Item(Long id, String itemName, String description, BigDecimal price, String picture, int calories,
			String ingredients) {
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.picture = picture;
		this.calories = calories;
		this.ingredients = ingredients;
	}

	public Long getId() {
		return id;
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
		return "Item [id=" + id + ", itemName=" + itemName + ", description=" + description + ", price=" + price
				+ ", picture=" + picture + ", calories=" + calories + ", ingredients=" + ingredients + "]";
	}

}
