package com.te.bootwithstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.bootwithstream.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

}
