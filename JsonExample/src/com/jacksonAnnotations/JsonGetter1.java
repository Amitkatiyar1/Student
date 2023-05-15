package com.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student1{
	private String name;
	private int rollno;
	public Student1(String name,int rollno) {
		this.name=name;
		this.rollno=rollno;
		
	}
	@JsonGetter
	public String getName() {
		return name;
	}
	@JsonGetter
	public int getRollno() {
		return rollno;
	}
	
	
}
public class JsonGetter1 {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Student1 student = new Student1("Amit",43);
		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			System.out.println(jsonString);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
