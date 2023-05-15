package com.jackson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToJsonString {

	public static void main(String[] args) {
 long Starttime = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userdata = new HashMap<String , Object>();
		String name,price,model;
		String Colour[];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Car name");
		name = sc.nextLine();
		
		System.out.println("Enter Car price");
		price = sc.nextLine();
		
		System.out.println("Enter car model");
		model = sc.nextLine();
		
		  Colour = new String[3];
		  Colour[0] = "Red";
		  Colour[1] = "Blue";
		  Colour[2] = "White";
		
		userdata.put("name", name);
		userdata.put("model", model);
		userdata.put("price", price);
		userdata.put("Colour", Colour);
		try {
			
		// pretty Function use 
			
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File ("jsonFile.json"), userdata);
		 System.out.println("excution time"+( System.currentTimeMillis()-Starttime)+"ms");
		System.out.println("Write Successfully ");
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}
