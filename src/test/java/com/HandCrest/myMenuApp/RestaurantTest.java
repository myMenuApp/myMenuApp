package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Test;

public class RestaurantTest {

	
	private Long id;
	private String menu;
	
	
	@Test
	public void testRestaurantClassExistsButIsNotNull() {
		Restaurant testRestaurant = null;
		Assert.assertNull(testRestaurant);
	}
		

	@Test
	public void testRestaurantHasIdAndMenu() {
		
	Restaurant testRestaurant = new Restaurant (id, menu);

		Assert.assertEquals(id, testRestaurant.getId());
		Assert.assertEquals(menu, testRestaurant.getMenu());
		
	}

	
}

	
	

