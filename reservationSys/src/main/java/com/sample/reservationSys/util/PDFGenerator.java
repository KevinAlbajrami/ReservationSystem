package com.sample.reservationSys.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sample.reservationSys.entities.Reservation;

@Component
public class PDFGenerator {
	public void generator(Reservation reservation, String filePath) {
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table= new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Code");
		table.addCell(reservation.getFlight().getCode());
		
		table.addCell("Destination");
		table.addCell(reservation.getFlight().getDestination());
		
		table.addCell("Date");
		table.addCell(reservation.getFlight().getDepDate().toString());
		
		table.addCell("Time");
		table.addCell(reservation.getFlight().getDepTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Name");
		table.addCell(reservation.getPassenger().getfName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getlName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		return table;
		
	}
}
