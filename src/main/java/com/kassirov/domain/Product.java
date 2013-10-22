package com.kassirov.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue
	private int id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_description")
	private String description;
	
	@Column(name="product_detaile")
	private String detaileDescription;
	
	@Column(name="product_price")
	private double price;
	
	@Column(name="product_rating")
	private double rating;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Products_product_id")
	private List<Image> images;

	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="comment_product_id")
	private List<Comment> comments;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetaileDescription() {
		return detaileDescription;
	}

	public void setDetaileDescription(String detaileDescription) {
		this.detaileDescription = detaileDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
