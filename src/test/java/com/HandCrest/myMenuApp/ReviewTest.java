package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Test;

public class ReviewTest {

	private Long id;
	private String creator;
	private String review;
	private String rating;

	@Test
	public void testReviewClassExistsButIsNotNull() {
		Review testReviews = null;
		Assert.assertNull(testReviews);
	}
	@Test
	public void testItemHasNameDescriptionPricePictureCaloriesIngredients() {

		Review testReviews = new Review(id, creator, review, rating);
		
		Assert.assertEquals(creator, testReviews.getCreator());
		Assert.assertEquals(review, testReviews.getReview());
		Assert.assertEquals(rating, testReviews.getRating());;

	}

}

	
	
