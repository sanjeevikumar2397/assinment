package com.te.doctorflow1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.doctorflow1.entity.AppoinmentDetails;

public interface AppoinmentDetailsDAO extends JpaRepository<AppoinmentDetails, Integer>{

}
