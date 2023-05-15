package com.jackson;

import java.io.File;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class jacksonParsher {

	public static void main(String[] args) {
		try(JsonParser jParser = new JsonFactory().createParser(new File("Example.json"));)
		{
			
		while(jParser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = jParser.getCurrentName();
			if("Name".equals(fieldName)) {
				jParser.nextToken();
				System.out.println(jParser.getText());
				
			}
			if("age".equals(fieldName)) {
				jParser.nextToken();
				System.out.println(jParser.getIntValue());
			}
			if("Messages".equals(fieldName)) {
				if(jParser.nextToken() == JsonToken.START_ARRAY) {
					while(jParser.nextToken() != JsonToken.END_ARRAY) {
						System.out.println(jParser.getText());
					}
				}
			}
					
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	}
