
package com.HandCrest.myMenuApp;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "item")
	private Collection<Comment> comments;

	public Item() {
	}

	public Item(String itemName, String description, BigDecimal price, String picture, int calories, String ingredients,
			Menu menu) {
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.picture = picture;
		this.calories = calories;
		this.ingredients = ingredients;
		this.menu = menu;
	}

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

	public Collection<Comment> getComments() {
		return comments;
	}
		public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public String toString() {
		return itemName;
	}
}
