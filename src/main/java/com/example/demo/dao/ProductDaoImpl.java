package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertProduct(Product product) {
		jdbcTemplate.update("INSERT INTO product(name, price, description)"
				+ "VALUES(?, ?, ?, ?)", 
				product.getName(), product.getPrice(), product.getDescription());
	}

	@Override
	public int updateProduct(Product product) {
		return jdbcTemplate.update("UPDATE  product SET name = ?, price = ?, description = ? WHERE id = ?)",
				product.getName(), product.getPrice(), product.getDescription());
	}

	@Override
	public List<Product> getAll() {
		String sql = "SELECT id, name, price, description FROM product";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Product> list = new ArrayList<Product>(); 
		for(Map<String, Object> result : resultList) {
			Product product = new Product();
			product.setId((int)result.get("id"));
			product.setName((String)result.get("name"));
			product.setPrice((int)result.get("price"));
			product.setDescription((String)result.get("description"));
			list.add(product);
		}
		
		return list;
	}

	@Override
	public Product findById(int id) {
		String sql = "SELECT name, price, description FROM product WHERE id = ?";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, id);
		Product product = new Product();
		for(Map<String, Object> result : resultList) {
			product.setId(id);
			product.setName((String)result.get("name"));
			product.setPrice((int)result.get("price"));
			product.setDescription((String)result.get("description"));
		}
		
		return product;
	}


}
