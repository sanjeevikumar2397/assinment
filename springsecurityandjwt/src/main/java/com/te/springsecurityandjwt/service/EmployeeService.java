package com.te.springsecurityandjwt.service;

import com.te.springsecurityandjwt.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public Employee getEmployee(String empId);

}
