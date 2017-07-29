package com.alex.springmvc.pdfgenerate.example;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class UserPDFView extends AbstractPdfView {

	/* (non-Javadoc)
	 * 建立pdf方法
	 * 
	 * @see org.springframework.web.servlet.view.document.AbstractPdfView#buildPdfDocument(java.util.Map, com.lowagie.text.Document, com.lowagie.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter pdfWriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> userData = (Map<String, String>) model
				.get("userData");

		Table table = new Table(2);
		table.addCell("No.");
		table.addCell("User Name");

		for (Map.Entry<String, String> entry : userData.entrySet()) {
			table.addCell(entry.getKey());
			table.addCell(entry.getValue());
		}
		document.add(table);
	}
}