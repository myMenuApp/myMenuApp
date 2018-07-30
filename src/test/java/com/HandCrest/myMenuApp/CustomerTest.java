package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

	private Long id;
	private String userName;
	private String password;
	private String avi;
	private String email;
	
	
	@Test
	public void testCustomerExistsButIsNotNull() {
		Customer testCustomer = null;
		Assert.assertNull(testCustomer);
	}
		
		@Test
		public void testItemHasNamePasswordAviAndEmail() {

			Customer testCustomer = new Customer(id, userName, password, avi, email);

			Assert.assertEquals(id, testCustomer.getId());
			Assert.assertEquals(userName, testCustomer.getUserName());
			Assert.assertEquals(password, testCustomer.getPassword());
			Assert.assertEquals(avi, testCustomer.getAvi());
			Assert.assertEquals(email, testCustomer.getEmail());
			

		
}
}
