package com.te.email_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.email_integration.service.EmailSenderService;
import com.te.email_integration.service.EmailSenderWithAttachment;

import jakarta.mail.MessagingException;

@RestController
public class Controller {
	
	@Autowired
	private EmailSenderWithAttachment attachment;
	
	@Autowired
	private EmailSenderService senderService;
	
	@GetMapping("/sendMail")
	public ResponseEntity<?> sendEmailWithAttachment() throws MessagingException {
		attachment.sendMailWithAttachment("ananajay828@gmail.com", "photo","Boot Email Integration", "D:\\image.jpg");
	    return new ResponseEntity<String>("Email sent",HttpStatus.OK);
	}
	
	@GetMapping("/sendMultiMail")
	public ResponseEntity<?> sendMultiEmailWithAttachment() throws MessagingException{
		String[] emailmulti= {"sathisenfield1996@gmail.com","anandajay828@gmail.com","jaganathan1000bc@gmail.com"};
		attachment.sendMultiWithAttachment(emailmulti,"photo", "Boot email integration","D:\\image.jpg");
		
		return new ResponseEntity<String>("Email sent",HttpStatus.OK);
	}
	
	@GetMapping("/sendGmail")
	public ResponseEntity<?> sendEmail(){
		senderService.sendMail("ananajay828@gmail.com", "email integration", "Hi maharastra Anand");
		return new ResponseEntity<String>("Email sent",HttpStatus.OK);}
		  
	   
	
}
