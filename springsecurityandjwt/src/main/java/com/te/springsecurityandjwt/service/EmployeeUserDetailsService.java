package com.te.springsecurityandjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.springsecurityandjwt.dao.EmployeeDAO;
import com.te.springsecurityandjwt.model.Employee;
import com.te.springsecurityandjwt.model.MyUserDetails;

@Service
public class EmployeeUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeDAO dao;
	private Employee emplolyee;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emplolyee2 = dao.findByEmpId(username);
		return new MyUserDetails(emplolyee2);
	}

}
