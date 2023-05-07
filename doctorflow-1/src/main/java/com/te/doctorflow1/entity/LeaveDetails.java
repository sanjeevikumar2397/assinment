package com.te.doctorflow1.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class LeaveDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fromDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate toDate;
	
	private String reason;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private DoctorDetails doctorDetails;
	
}
