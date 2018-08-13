package com.HandCrest.myMenuApp;

import org.junit.Test;

import junit.framework.Assert;

public class CustomerTest {

	private Long id;
	private String userName;
	private String password;
	private String avatar;
	private String email;
	
	
	@Test
	public void testCustomerExistsButIsNotNull() {
		Customer testCustomer = null;
		Assert.assertNull(testCustomer);
	}
		
		@Test
		public void testItemHasNameDescriptionPricePictureCaloriesIngredients() {

			Customer testCustomer = new Customer(id, userName, password, avatar, email);

			Assert.assertEquals(id, testCustomer.getId());
			Assert.assertEquals(userName, testCustomer.getUserName());
			Assert.assertEquals(password, testCustomer.getPassword());
			Assert.assertEquals(avatar, testCustomer.getAvatar());
			Assert.assertEquals(email, testCustomer.getEmail());
			

		
}
}

