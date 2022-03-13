package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductDao {
	void insertProduct( Product  product);
	
	int updateProduct( Product  product);
		
	List<Product> getAll();
	
	Product findById(int id);
}
