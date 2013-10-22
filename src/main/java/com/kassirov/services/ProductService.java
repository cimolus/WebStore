package com.kassirov.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kassirov.dao.ProductDao;
import com.kassirov.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public List<Product> getAllProducts() {
		return productDao.readAllProducts();
	}
	
	@Transactional
	public Product getProductById(int id) {
		return productDao.readProductById(id);
	}
	
	@Transactional
	public List<Product> getRatingProducts(int count) {
		return productDao.readTopRatingProducts(count);
	}
	
	@Transactional
	public List<Product> getProducts(List<Product> products) {
		if ( products.isEmpty())
			return products;
		List<Integer> params = new ArrayList<Integer>();
		for(Product product:products) {
			params.add(product.getId());
		}
		return productDao.readProducts(params);
	}
	
	@Transactional
	public List<Product> getSearchingProducts(String pattern) {
		return productDao.searchProduct("%" + pattern + "%");
	}
}
