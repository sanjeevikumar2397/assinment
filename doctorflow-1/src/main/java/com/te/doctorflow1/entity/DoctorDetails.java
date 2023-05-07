package com.te.doctorflow1.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class DoctorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	
	private String name;
	
	private String specialist;
	
	private Long contactNo;
	
	private double rating;
	
	private String password;
	
	@Value("ROLE_DOCTOR")
	private String role;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "doctorDetails",fetch = FetchType.EAGER)
	private List< AppoinmentDetails> appointments;
	


}
