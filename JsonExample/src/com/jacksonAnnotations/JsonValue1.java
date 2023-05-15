package com.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
@JsonRootName(value ="tester")
class Tester{
	private String name;
	private int id;
	
	public Tester(String name,int id) {
		this.id=id;
		this.name=name;
		
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	@JsonValue
	public String toString() {
		return "{name:" + name+"}";
	}
	
}
public class JsonValue1 {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Tester tr = new Tester("amit katityar",567);
			 mapper.enable(SerializationFeature.WRAP_ROOT_VALUE); 
			String jsonString =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr);
			System.out.println(jsonString);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
