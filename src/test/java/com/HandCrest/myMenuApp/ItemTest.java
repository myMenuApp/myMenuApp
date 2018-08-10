<<<<<<< HEAD
package com.HandCrest.myMenuApp;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

	private String itemName;
	private String description;
	private BigDecimal price;
	private String picture;
	private int calories;
	private String ingredients;
	private Menu menu;

	@Test
	public void testItemClassExistsButIsNotNull() {
		Item testMenuItems = null;
		Assert.assertNull(testMenuItems);
	}

	@Test
	public void testItemHasNameDescriptionPricePictureCaloriesIngredients() {

		Item testMenuItems = new Item(itemName, description, price, picture, calories, ingredients, menu);

		Assert.assertEquals(itemName, testMenuItems.getItemName());
		Assert.assertEquals(description, testMenuItems.getDescription());
		Assert.assertEquals(price, testMenuItems.getPrice());
		Assert.assertEquals(picture, testMenuItems.getPicture());
		Assert.assertEquals(calories, testMenuItems.getCalories());
		Assert.assertEquals(ingredients, testMenuItems.getIngredients());

	}

}
=======
package com.HandCrest.myMenuApp;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

	private String itemName;
	private String description;
	private BigDecimal price;
	private String picture;
	private int calories;
	private String ingredients;

	@Test
	public void testItemClassExistsButIsNotNull() {
		Item testMenuItems = null;
		Assert.assertNull(testMenuItems);
	}

	@Test
	public void testItemHasNameDescriptionPricePictureCaloriesIngredients() {

		Item testMenuItems = new Item(itemName, description, price, picture, calories, ingredients, null);

		Assert.assertEquals(itemName, testMenuItems.getItemName());
		Assert.assertEquals(description, testMenuItems.getDescription());
		Assert.assertEquals(price, testMenuItems.getPrice());
		Assert.assertEquals(picture, testMenuItems.getPicture());
		Assert.assertEquals(calories, testMenuItems.getCalories());
		Assert.assertEquals(ingredients, testMenuItems.getIngredients());

	}

}
>>>>>>> inital branch commit
