package com.te.doctorflow1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.doctorflow1.entity.LeaveDetails;

public interface LeaveDetailsDAO extends JpaRepository<LeaveDetails, Integer> {
	

}
