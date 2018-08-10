package com.HandCrest.myMenuApp;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class CommentTest {
	
	private Long id;
	private String creator;
	private String comment;
	private Date date;
	
	@Test
	public void testCommentClassExistsButIsNotNull() {
		Comment testComment = null;
		Assert.assertNull(testComment);
	}
	
	@Test 
	public void ShouldAddCreatorCommentAndDate() {
		Comment testComment = new Comment(id, creator, comment);
		
		Assert.assertEquals(id, testComment.getId());
		Assert.assertEquals(creator, testComment.getCreator());
		Assert.assertEquals(comment, testComment.getComment());
		
	}

}
