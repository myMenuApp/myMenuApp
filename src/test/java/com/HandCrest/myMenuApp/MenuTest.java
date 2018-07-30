package com.HandCrest.myMenuApp;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class MenuTest {

	private Long id;
	private String restaurant;
	private Collection<Item> items;

	
	@Test
	public void testMenuClassExistsButIsNotNull() {
		Menu testMenuItems = null;
		Assert.assertNull(testMenuItems);
	}
	
	@Test
	public void testItemHasIdRestaurantAndItems() {
		
	Menu testMenuItems = new Menu(id, restaurant, items);

		Assert.assertEquals(id, testMenuItems.getId());
		Assert.assertEquals(restaurant, testMenuItems.getRestaurant());
		Assert.assertEquals(items, testMenuItems.getItems());
	}
	
	
}

