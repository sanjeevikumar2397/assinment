package com.te.springsecurityandjwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "employee")

public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private String password;
	private String roles;

}
