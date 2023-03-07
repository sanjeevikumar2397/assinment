package com.te.bootwithstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.bootwithstream.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

	

}