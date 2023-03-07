package com.te.pdfgenerator.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.te.pdfgenerator.service.PdfService;

import jakarta.servlet.http.HttpServletResponse;
@Controller
public class PdfGeneratorController {
	private final PdfService pdfService;

	public PdfGeneratorController(PdfService pdfService) {
		super();
		this.pdfService = pdfService;
	}
	@GetMapping("/pdf")
	private void pdfGenerte(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateAndTime=dateFormat.format(new Date());
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=pdf_" + currentDateAndTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		this.pdfService.export(response);
		
	}	

}
