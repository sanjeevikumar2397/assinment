package com.te.bootwithstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.response.SuccessResponse;
import com.te.bootwithstream.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	@PostMapping("/saveProduct")
	public ResponseEntity<SuccessResponse> saveProduct(@RequestBody Product product) {
		Product addProduct = service.addProduct(product);
		if (addProduct != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addProduct).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addProduct).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getDiscount")
	public ResponseEntity<SuccessResponse> getDiscount() {
		List<Product> discountList = service.productListwithDiscount();
		if (!discountList.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(discountList).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(discountList).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

}
