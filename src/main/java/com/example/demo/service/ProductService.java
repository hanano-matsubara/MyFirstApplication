package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	
	void save(Product product);
	
	void update(Product product);
	
	List<Product> getAll();
	
	Product findById(int id);
}
