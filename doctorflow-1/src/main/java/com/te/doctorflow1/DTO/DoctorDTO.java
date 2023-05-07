package com.te.doctorflow1.DTO;

import lombok.Data;

@Data
public class DoctorDTO {
	
	private Integer doctorId;
	
	private String name;
	
	private String specialist;
	
	private Long contactNo;
	
	private double rating;
	
	private String password;

}
