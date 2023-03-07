package com.te.pdfgenerator.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PdfService {

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle.setSize(18);
		Paragraph paragraph = new Paragraph("welcome to pdf generator.", fontTitle);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);
		Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
		fontParagraph.setSize(14);
		Paragraph paragraph2 = new Paragraph("yes we generated the pdf", fontParagraph);
		paragraph2.setAlignment(paragraph2.ALIGN_LEFT);
		document.add(paragraph);
		document.add(paragraph2);
		document.close();

	}

}
