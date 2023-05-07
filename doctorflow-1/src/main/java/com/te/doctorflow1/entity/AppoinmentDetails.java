package com.te.doctorflow1.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class AppoinmentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String appoinmentName;
	
	private String gender;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	private LocalTime time;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	private List<DoctorDetails> doctorDetails;
}
