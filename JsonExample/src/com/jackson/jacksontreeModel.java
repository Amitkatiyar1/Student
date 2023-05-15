package com.jackson;

import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jacksontreeModel {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonstr ="{\"name\":\"Amit katiyar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
		String str1 ="{\"Name\":\"Amit katiyar\"}";
				
		
		// creating json node tree
				JsonNode rootNode = mapper.readTree(jsonstr);
				
		// json node Traversing 
				JsonNode nameNode = rootNode.path("name");
				System.out.println("name"+nameNode.textValue());
				
		JsonNode nameNode1 = rootNode.path("age");
		System.out.println("age"+nameNode1.intValue());
		
		JsonNode nameNode2 = rootNode.path("verified");
		System.out.println("verified"+nameNode2.booleanValue());
		
		JsonNode nameNode3 = rootNode.path("marks");
	  Iterator <JsonNode> iterator = nameNode3.elements();
	  
		System.out.println();
		
		
		
		

	}

}
