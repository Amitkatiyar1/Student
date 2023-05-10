package com.example.Curd.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Curd.Model.WeatherClass;
import com.example.Curd.Repository.WeatherRepo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class PdfService {
	@Autowired
	private WeatherRepo repo;

	Logger logger = LoggerFactory.getLogger(PdfService.class);

	public ByteArrayInputStream createPdf(List<WeatherClass> list) {
		logger.info("Create Pdf Started");

		String title = "Welcome ";
		String content = "My name is Amit katiyar";

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, stream);
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
		Paragraph paragraph = new Paragraph(title, font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		try {

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(80);
			table.setWidths(new int[] { 1, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			hcell = new PdfPCell(new Phrase("Country", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Temp", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (WeatherClass city : list) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(city.getName().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(city.getCountry()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase(String.valueOf(city.getTemp())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			document.add(table);

			document.close();
		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(stream.toByteArray());

	}

	public List<WeatherClass> getFile() {
		return repo.findAll();
	}

}


