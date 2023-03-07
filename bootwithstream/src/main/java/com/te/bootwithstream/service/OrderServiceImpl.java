package com.te.bootwithstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.repository.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO dao;

	@Override
	public Order registerOrder(Order order) {
		return dao.save(order);
		
		
	}

	

}
