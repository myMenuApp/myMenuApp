package com.HandCrest.myMenuApp;

import org.junit.Assert;
import org.junit.Test;

public class CommentTest {
	
	private Long id;
	private String creator;
	private String comment;
	
	@Test
	public void testCommentClassExistsButIsNotNull() {
		Comment testComment = null;
		Assert.assertNull(testComment);
	}
	
	@Test 
	public void testShouldAddCreatorCommentAndDate() {
		id = new Long(10);
		creator = "Groot";
		comment = new String("review");
		
		Comment testComment = new Comment(id, creator, comment);
		
		Assert.assertEquals(id, testComment.getId());
		Assert.assertEquals(creator, testComment.getCreator());
		Assert.assertEquals(comment, testComment.getComment());
		
	}

}
