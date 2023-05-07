package com.te.doctorflow1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.doctorflow1.entity.DoctorDetails;

@Repository
public interface DoctorDetailsDAO extends JpaRepository<DoctorDetails, Integer> {
	
	DoctorDetails findByName(String name);
	

}
