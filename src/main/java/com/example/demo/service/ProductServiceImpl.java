package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductDao dao;
	
	@Autowired ProductServiceImpl(ProductDao dao){
		this.dao = dao;
	}

	@Override
	public void save(Product product) {
		dao.insertProduct(product);
	}

	@Override
	public List<Product> getAll() {
		return dao.getAll();
	}

	@Override
	public void update(Product product) {
		if(dao.updateProduct(product) == 0) {
			throw new InquiryNotFoundException("can't find the same ID");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

}
