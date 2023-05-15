package com.jackson;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jacksonGenrator {

	public static void main(String[] args) {
		
		
		try {
			JsonFactory j = new JsonFactory();
			com.fasterxml.jackson.core.JsonGenerator jGenrator = j.createGenerator(new File("Example.json"),JsonEncoding.UTF8);
		
		
//		(JsonGenerator jGenrator = mapper.getFactory().createGenerator(new File("jsonFile.json"),JsonEncoding.UTF8)){
			
			jGenrator.writeStartObject();
			
			
			
			jGenrator.writeStringField("Name", "Amit");
			jGenrator.writeNumberField("age", 22);

			jGenrator.writeFieldName("Messages");
		
			jGenrator.writeStartArray();
			
			jGenrator.writeNumber(2);
			
			
			jGenrator.writeNumber(3);
			
			jGenrator.writeEndArray();
			jGenrator.writeEndObject();
			jGenrator.close();
			

   ObjectMapper mapper = new ObjectMapper();

   Map <String,Object> dataMap = mapper.readValue(new File("Example.json"),Map.class);
   System.out.println(dataMap.get("Name"));
   System.out.println(dataMap.get("age"));
   System.out.println(dataMap.get("Messages"));
		
		}catch(Exception e) {
			
			System.out.println(e);
		}
			
		}

	}


