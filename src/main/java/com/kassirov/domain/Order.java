package com.kassirov.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name="Orders" )
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int id;
	
	@Column(name="order_paid")
	private byte paid;
	
	@Column(name="order_delivered")
	private byte delivered;
	
	@Column(name="order_address")
	private String address;
	
	@Column(name="Users_login")
	private String user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="ordered" , 
		joinColumns = @JoinColumn(name="orders_order_id"),
		inverseJoinColumns = @JoinColumn(name="products_product_id"))
	private List<Product> orderedProducts;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getPaid() {
		return (paid > 0);
	}
	
	public void setPaid(boolean paid) {
		this.paid = (byte) ((paid) ? 1 : 0);
	}
	
	public boolean getDelivered() {
		return (delivered > 0);
	}
	
	public void setDelivered(boolean delivered) {
		this.delivered = (byte) ((delivered) ? 1 : 0);
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
}
