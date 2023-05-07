package com.te.doctorflow1.service;

import com.te.doctorflow1.DTO.AuthenticationRequest;
import com.te.doctorflow1.DTO.DoctorDTO;
import com.te.doctorflow1.DTO.DoctorDetailsDto;
import com.te.doctorflow1.entity.AppoinmentDetails;
import com.te.doctorflow1.entity.DoctorDetails;
import com.te.doctorflow1.entity.LeaveDetails;

public interface DoctorFlowService {
	
	DoctorDetails addDoctor(DoctorDTO doctorDTO);
	
	DoctorDetailsDto doctorDetails(AuthenticationRequest authenticationRequest);
	
	AppoinmentDetails addAppoinment(AppoinmentDetails appoinmentDetails,String name);

	DoctorDetails appoinmentList(Integer id);
	
	LeaveDetails addLeave(String name,LeaveDetails details);
}
