package com.te.doctorflow1.securityjwtservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.doctorflow1.entity.DoctorDetails;
import com.te.doctorflow1.repository.DoctorDetailsDAO;

@Service
public class DoctorUserDetailsService implements UserDetailsService{
	
	@Autowired
	private DoctorDetailsDAO detailsDAO;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DoctorDetails details = detailsDAO.findByName(username);
		
		
		return new MyUserDetailsService(details);
	}
	
	

}
