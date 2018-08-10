package com.HandCrest.myMenuApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	private String creator;
	@Lob
	private String comment;
	
	@JsonIgnore
	@ManyToOne
	private Item item;

	public Comment() {
	}

	public Comment(String creator, String comment, Item item) {
		this.creator = creator;
		this.comment = comment;
		this.item = item;
	}

	public Comment(Long id, String creator, String comment) {
		// Testing Constructor
	}

	public Item getItem() {
		return item;
	}

	public Long getId() {
		return id;
	}

	public String getCreator() {
		return creator;
	}

	public String getComment() {
		return comment;
	}


	@Override
	public String toString() {
		return comment;
	}

}
