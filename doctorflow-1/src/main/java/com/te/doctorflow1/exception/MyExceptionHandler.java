package com.te.doctorflow1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(DoctorLeaveException.class)
	public ResponseEntity<?> leaveException(DoctorLeaveException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<?> invalidCredential(InvalidCredentialException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
