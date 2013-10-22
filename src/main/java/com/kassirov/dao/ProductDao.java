package com.kassirov.dao;

import java.util.List;

import com.kassirov.domain.Product;


public interface ProductDao {
	public void createProduct(Product product);
	public List<Product> readAllProducts();
	public List<Product> readTopRatingProducts(int count);
	public Product readProductById(int id);
	public List<Product> readProducts(List<Integer> params);
	public List<Product> searchProduct(String pattern);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
}
