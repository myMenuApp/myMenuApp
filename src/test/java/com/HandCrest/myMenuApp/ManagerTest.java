package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {
	
	private Long id;
	private String userName = "userName";
	private String password = "password";
	private String restaurant = "restaurant";
	
	
	@Test
	public void testManagerClassExistsButIsNotNull() {
		Manager testManagerRequirements = null;
		Assert.assertNull(testManagerRequirements);
	}
		

	@Test
	public void testItemHasIdUserNamePasswordAndResturant() {
		
	Manager testManagerRequirements = new Manager(id, "userName", "password", "restaurant");

		Assert.assertEquals(id, testManagerRequirements.getId());
		Assert.assertEquals(userName, testManagerRequirements.getUserName());
		Assert.assertEquals(password, testManagerRequirements.getPassword());
		Assert.assertEquals(restaurant, testManagerRequirements.getRestaurant());
	}

	
}
