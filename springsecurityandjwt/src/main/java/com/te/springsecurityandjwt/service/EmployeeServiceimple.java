package com.te.springsecurityandjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springsecurityandjwt.dao.EmployeeDAO;
import com.te.springsecurityandjwt.model.Employee;

@Service
public class EmployeeServiceimple implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee getEmployee(String empId) {
		
		return dao.findByEmpId(empId);
	}

}
