package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	private Long id;
	private String creator;
	private String review;
	private String rating;

	@Before
	public void reviewTest() { // test to show review class is made
		Review testReviews = new Review(id, creator, review, rating);
		
	}
	
	@Test
	public void testReviewClassExistsButIsNotNull() { // test to show that a created review exists
		Review testReviews = null;
		Assert.assertNull(testReviews);
	}
	@Test
	public void testReviewHasIdCreatorReviewAndRating() { // test to see if the review class gets variables

		Review testReviews = new Review(id, creator, review, rating);
		
		Assert.assertEquals(id, testReviews.getId());
		Assert.assertEquals(creator, testReviews.getCreator());
		Assert.assertEquals(review, testReviews.getReview());
		Assert.assertEquals(rating, testReviews.getRating());;

	}

}

	
	
