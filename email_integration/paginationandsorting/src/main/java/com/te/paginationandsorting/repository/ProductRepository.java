package com.te.paginationandsorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.paginationandsorting.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
