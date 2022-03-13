package com.example.demo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductContoller {

		private final ProductService productService;
			
		@Autowired
		public ProductContoller(ProductService productService) {
			this.productService = productService;
		}
		@GetMapping("/items")
		@ResponseBody
		List<Product> getItems() {
	        List<Product> product = productService.getAll();
	        return product;
	    }
		@GetMapping("/items/{id}")
		@ResponseBody
		Product findById(@PathVariable("id") int id) {
	        Product product = productService.findById(id);
	        return product;
	    }
}
