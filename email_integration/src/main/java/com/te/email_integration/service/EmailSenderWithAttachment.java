package com.te.email_integration.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderWithAttachment {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMailWithAttachment(String toEmail,String subject,String body,String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		
		helper.setFrom("sanjeevikumaranbu@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		
		FileSystemResource resource =new FileSystemResource(new File(attachment));
		helper.addAttachment(resource.getFilename(), resource);
		javaMailSender.send(mimeMessage);
		
		System.out.println("mail sent with attachment");
		
	}
	
	public void sendMultiWithAttachment(String[] toEmail,String subject,String body,String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		
		helper.setFrom("sanjeevikumaranbu@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		
		FileSystemResource resource =new FileSystemResource(new File(attachment));
		helper.addAttachment(resource.getFilename(), resource);
		javaMailSender.send(mimeMessage);
		
		System.out.println("mail sent with attachment");
		
	}

}
