package com.HandCrest.myMenuApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	private String creator;
	
	@Lob
	private String review;
	private String rating;

	public Review() {

	}

	public Review(Long id, String creator, String review, String rating) {
		this.id = id;
		this.creator = creator;
		this.review = review;
		this.rating = rating;
	}

	
	public Long getId() {
		return id;
	}
	
	public Object getCreator() {
		return creator;
	}

	public Object getReview() {
		return review;
	}

	public Object getRating() {
		return rating;
	}

}
