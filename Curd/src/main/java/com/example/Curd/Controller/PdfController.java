package com.example.Curd.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curd.Model.WeatherClass;
import com.example.Curd.Service.PdfService;



@Controller
public class PdfController {

	@Autowired
	private PdfService pService;
	
	@GetMapping("/createP")
	public ResponseEntity<InputStreamResource> createPdf(){
		
		 var list = (List<WeatherClass>) pService.getFile();
		
	ByteArrayInputStream pdf=	pService.createPdf(list);
	HttpHeaders headers = new HttpHeaders();
	
	headers.add("Content-Disposition" ,"inline;sd.pdf");
	return ResponseEntity.ok()
			.headers(headers)
			.contentType(MediaType.APPLICATION_PDF)
			.body(new InputStreamResource(pdf));
		
		
	}
}
