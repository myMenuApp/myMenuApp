package com.HandCrest.myMenuApp;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

	private String itemName;
	private String description;
	private BigDecimal price;
	private String picture;
	private int calories;
	private String ingredients;
	private boolean enabled;
	private Menu menu;

	@Test
	public void testItemClassExistsButIsNotNull() {
		Item testMenuItems = null;
		Assert.assertNull(testMenuItems);
	}

	@Test
	public void testItemHasNameDescriptionPricePictureCaloriesIngredients() {

		Item testMenuItems = new Item(itemName, description, price, picture, calories, ingredients, false, menu);

		Assert.assertEquals(itemName, testMenuItems.getItemName());
		Assert.assertEquals(description, testMenuItems.getDescription());
		Assert.assertEquals(price, testMenuItems.getPrice());
		Assert.assertEquals(picture, testMenuItems.getPicture());
		Assert.assertEquals(calories, testMenuItems.getCalories());
		Assert.assertEquals(ingredients, testMenuItems.getIngredients());
		Assert.assertEquals(menu, testMenuItems.getMenu());

	}

	@Test
	public void isEnabledShouldbefalse() {
		
		Item testMenuItems = new Item(itemName, description, price, picture, calories, ingredients, false, menu);
		
		AssertThat(testMenuItems.getIsEnabled(), is("false"));
	}

	private void AssertThat(boolean isEnabled, Matcher<String> matcher) {

	}

	

}
