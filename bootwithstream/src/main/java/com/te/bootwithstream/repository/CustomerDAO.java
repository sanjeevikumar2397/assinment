package com.te.bootwithstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.bootwithstream.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	
}
