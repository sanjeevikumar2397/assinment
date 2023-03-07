package com.te.bootwithstream.service;

import java.util.List;

import com.te.bootwithstream.entity.Product;

public interface ProductService {
	
 public Product addProduct(Product product);
 
 public List<Product> productListwithDiscount();
}
