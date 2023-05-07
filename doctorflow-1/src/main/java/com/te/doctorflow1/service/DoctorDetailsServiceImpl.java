package com.te.doctorflow1.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.doctorflow1.DTO.AuthenticationRequest;
import com.te.doctorflow1.DTO.DoctorDTO;
import com.te.doctorflow1.DTO.DoctorDetailsDto;
import com.te.doctorflow1.entity.AppoinmentDetails;
import com.te.doctorflow1.entity.DoctorDetails;
import com.te.doctorflow1.entity.LeaveDetails;
import com.te.doctorflow1.exception.DoctorLeaveException;
import com.te.doctorflow1.exception.InvalidCredentialException;
import com.te.doctorflow1.repository.AppoinmentDetailsDAO;
import com.te.doctorflow1.repository.DoctorDetailsDAO;
import com.te.doctorflow1.repository.LeaveDetailsDAO;

@Service
public class DoctorDetailsServiceImpl implements DoctorFlowService {

	@Autowired
	private DoctorDetailsDAO doctorDetailsDAO;

	@Autowired
	private AppoinmentDetailsDAO appoinmentDetailsDAO;

	@Autowired
	private LeaveDetailsDAO leaveDetailsDAO;

	@Override
	public DoctorDetails addDoctor(DoctorDTO doctorDTO) {
		DoctorDetails doctorDetails = new DoctorDetails();
		doctorDetails.setDoctorId(doctorDTO.getDoctorId());
		doctorDetails.setName(doctorDTO.getName());
		doctorDetails.setSpecialist(doctorDTO.getSpecialist());
		doctorDetails.setContactNo(doctorDTO.getContactNo());
		doctorDetails.setRating(doctorDTO.getRating());
		doctorDetails.setRole("ROLE_DOCTOR");
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 String password = encoder.encode(doctorDTO.getPassword());
		
		
		doctorDetails.setPassword(password);

		DoctorDetails save = doctorDetailsDAO.save(doctorDetails);

		return save;
	}

	@Override
	public AppoinmentDetails addAppoinment(AppoinmentDetails appoinmentDetails, String name) {
		DoctorDetails doctorDetails = doctorDetailsDAO.findByName(name);
		if (doctorDetails == null) {
			throw new InvalidCredentialException("Give proper user name.........!");
		}
		LeaveDetails leaveDetails = leaveDetailsDAO.findById(doctorDetails.getDoctorId()).get();

		List<DoctorDetails> details = new ArrayList<>();
		details.add(doctorDetails);
		AppoinmentDetails appoinmentDetails2 = new AppoinmentDetails();
		appoinmentDetails2.setId(appoinmentDetails.getId());
		appoinmentDetails2.setAppoinmentName(appoinmentDetails.getAppoinmentName());
		appoinmentDetails2.setGender(appoinmentDetails.getGender());

		boolean condition = leaveDetails.getFromDate().equals(appoinmentDetails.getDate()) || Period
				.between(leaveDetails.getFromDate(), leaveDetails.getToDate()).equals(appoinmentDetails.getDate())
				|| leaveDetails.getToDate().equals(appoinmentDetails.getDate());

		if (condition) {
			throw new DoctorLeaveException(
					name + " " + "leave " + appoinmentDetails.getDate() + " due to some personal reason");
		}
		appoinmentDetails2.setDate(appoinmentDetails.getDate());
		appoinmentDetails2.setTime(appoinmentDetails.getTime());
		appoinmentDetails2.setDoctorDetails(details);

		appoinmentDetailsDAO.save(appoinmentDetails2);

		return appoinmentDetails2;
	}

	@Override
	public DoctorDetails appoinmentList(Integer id) {
		DoctorDetails doctorDetails = doctorDetailsDAO.findById(id).get();
		if (doctorDetails == null) {
			throw new InvalidCredentialException("Give proper user name.........!");
		}
		List<AppoinmentDetails> appointments = doctorDetails.getAppointments();

		List<AppoinmentDetails> list = new ArrayList<>();

		appointments.forEach(i -> {
			if (i.getDate().equals(LocalDate.now()) || i.getDate().equals(LocalDate.now().plusDays(1))) {

				list.add(i);

			}
		});

		list.sort(Comparator.comparing(AppoinmentDetails::getDate).thenComparing(AppoinmentDetails::getTime));

		doctorDetails.setAppointments(list);

		return doctorDetails;
	}

	@Override
	public LeaveDetails addLeave(String name, LeaveDetails details) {
		DoctorDetails doctorDetails = doctorDetailsDAO.findByName(name);
		if (doctorDetails == null) {
			throw new InvalidCredentialException("Give proper user name.........!");
		}
		LeaveDetails leaveDetails = new LeaveDetails();
		leaveDetails.setDoctorDetails(doctorDetails);
		leaveDetails.setId(details.getId());
		leaveDetails.setFromDate(details.getFromDate());
		leaveDetails.setToDate(details.getToDate());
		leaveDetails.setReason(details.getReason());

		leaveDetailsDAO.save(leaveDetails);

		return leaveDetails;
	}

	@Override
	public DoctorDetailsDto doctorDetails(AuthenticationRequest authenticationRequest) {
		DoctorDetails doctorDetails = doctorDetailsDAO.findByName(authenticationRequest.getName());
		if (doctorDetails == null) {
			throw new InvalidCredentialException("Give proper user name.........!");
		}

		DoctorDetailsDto detailsDto = new DoctorDetailsDto();
		detailsDto.setName(doctorDetails.getName());
		detailsDto.setContactNo(doctorDetails.getContactNo());
		detailsDto.setRating(doctorDetails.getRating());
		detailsDto.setSpecialist(doctorDetails.getSpecialist());

		return detailsDto;
	}

}
