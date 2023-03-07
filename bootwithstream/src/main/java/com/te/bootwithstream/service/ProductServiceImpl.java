package com.te.bootwithstream.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductDAO dao;

	@Override
	public Product addProduct(Product product) {
		return dao.save(product);
	}

	@Override
	public List<Product> productListwithDiscount() {
		  List<Product> result = dao.findAll()
			        .stream()
			        .filter(p -> p.getName().equalsIgnoreCase("Toys"))
			        .map(p -> p.withPrice(p.getPrice() * 0.9))
			        .collect(Collectors.toList()); 
		return result;
	}
	
	
}
