package com.kassirov.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue
	@Column(name="comment_id")
	private int id;
	
	@Column(name="comment_text")
	private String text;
	
	@Column(name="Users_login")
	private String author;
	
	@Column(name="comment_product_id")
	private int comment_product_id;
	
	public Comment() {
		
	}
	
	public Comment(int comment_product_id) {
		this.comment_product_id = comment_product_id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getComment_product_id() {
		return comment_product_id;
	}

	public void setComment_product_id(int comment_product_id) {
		this.comment_product_id = comment_product_id;
	}
	
	
}
