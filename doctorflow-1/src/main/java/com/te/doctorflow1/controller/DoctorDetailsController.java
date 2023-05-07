package com.te.doctorflow1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.doctorflow1.DTO.AuthenticationRequest;
import com.te.doctorflow1.DTO.DoctorDTO;
import com.te.doctorflow1.DTO.DoctorDetailsDto;
import com.te.doctorflow1.entity.AppoinmentDetails;
import com.te.doctorflow1.entity.DoctorDetails;
import com.te.doctorflow1.entity.LeaveDetails;
import com.te.doctorflow1.exception.InvalidCredentialException;
import com.te.doctorflow1.response.AuthenticationResponce;
import com.te.doctorflow1.response.SuccessResponce;
import com.te.doctorflow1.securityandjwtutil.AuthenticationJwtUtil;
import com.te.doctorflow1.service.DoctorFlowService;

@RestController
public class DoctorDetailsController {

	@Autowired
	private DoctorFlowService doctorFlowService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationJwtUtil authenticationJwtUtil;
	
	 
	private static final Logger log = LoggerFactory.getLogger(DoctorDetailsController.class);

	

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponce> getAuthenticate(
			@RequestBody AuthenticationRequest authenticationRequest) {

		DoctorDetailsDto doctorDetails = doctorFlowService.doctorDetails(authenticationRequest);

		log.debug("Request{}", authenticationRequest.getName());

		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getName(),
					authenticationRequest.getPassword()));

			UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getName());
			String token = authenticationJwtUtil.generateToken(userDetails);
			
		

			return new ResponseEntity<AuthenticationResponce>(AuthenticationResponce.builder().jwtToken(token)
					.data(doctorDetails).message("login Successfull............!!").build(), HttpStatus.OK);

		} catch (Exception e) {

			if (doctorDetails == null) {
				throw new InvalidCredentialException("Give proper user name.........!");
			}

			throw new InvalidCredentialException("Incorrect password............!!");
		}

	}

	@PostMapping("/addDoctor")
	public ResponseEntity<?> addDoctor(@RequestBody DoctorDTO doctorDTO) {
		DoctorDetails addDoctor = doctorFlowService.addDoctor(doctorDTO);
		if (addDoctor != null) {
			return new ResponseEntity<DoctorDetails>(addDoctor, HttpStatus.OK);
		}
		return new ResponseEntity<DoctorDetails>(addDoctor, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addAppoinment/{name}")
	public ResponseEntity<?> addAppoinment(@PathVariable String name,
			@RequestBody AppoinmentDetails appoinmentDetails) {
		AppoinmentDetails appoinment = doctorFlowService.addAppoinment(appoinmentDetails, name);
		if (appoinment != null) {
			return new ResponseEntity<AppoinmentDetails>(appoinment, HttpStatus.OK);

		}
		return new ResponseEntity<AppoinmentDetails>(appoinment, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/appoinmentList/{id}")
	public ResponseEntity<SuccessResponce> appoinmentList(@PathVariable Integer id) {
		DoctorDetails doctorDetails = doctorFlowService.appoinmentList(id);

		if (doctorDetails != null) {
			return new ResponseEntity<SuccessResponce>(
					SuccessResponce.builder().data(doctorDetails).Message("your appoinment list ").build(),
					HttpStatus.OK);

		}
		return new ResponseEntity<SuccessResponce>(
				SuccessResponce.builder().data(doctorDetails).Message("No appoinment list").build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/ApplyLeave/{name}")
	public ResponseEntity<?> leaveApply(@PathVariable String name, @RequestBody LeaveDetails leaveDetails) {
		LeaveDetails leaveDetails2 = doctorFlowService.addLeave(name, leaveDetails);
		DoctorDetails doctorDetails = leaveDetails2.getDoctorDetails();
		if (leaveDetails2 != null) {
			return new ResponseEntity<String>(doctorDetails.getName() + "  leave submited", HttpStatus.OK);
		}
			return new ResponseEntity<String>(doctorDetails.getName() + "  leave not submited", HttpStatus.BAD_REQUEST);
	

	}

}
