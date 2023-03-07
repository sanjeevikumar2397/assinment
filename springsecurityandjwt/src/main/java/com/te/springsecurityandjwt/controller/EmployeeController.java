package com.te.springsecurityandjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springsecurityandjwt.dto.AuthenticationRequtest;
import com.te.springsecurityandjwt.dto.AuthenticationResponse;
import com.te.springsecurityandjwt.jwtutil.EmployeeJwtUtil;
import com.te.springsecurityandjwt.model.Employee;
import com.te.springsecurityandjwt.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private EmployeeJwtUtil jwtUtil;

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/getAuthenticate")
	public ResponseEntity<AuthenticationResponse> getAuthenticate(@RequestBody AuthenticationRequtest requtest) {
		manager.authenticate(
				new UsernamePasswordAuthenticationToken(requtest.getEmpId(), requtest.getPassword()));
		UserDetails userDetails = detailsService.loadUserByUsername(requtest.getEmpId());
		String generateToken = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(generateToken), HttpStatus.OK);

	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		System.out.println("inside add controller");
		Employee addEmployee = service.addEmployee(employee);
		if (addEmployee!=null) {
			System.out.println("inside add controller1");
			return new ResponseEntity<String>("Data saved", HttpStatus.OK);
		}
		else {
			System.out.println("inside add controller2");
		return new ResponseEntity<String>("Data not saved", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable String empId){
		System.out.println("inside get controller");
		Employee getemployee = service.getEmployee(empId);
		if (getemployee!=null) {
			System.out.println("inside get controller1");
			return new ResponseEntity<Employee>(getemployee, HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("Data not found", HttpStatus.BAD_REQUEST);
		}
	}

}
