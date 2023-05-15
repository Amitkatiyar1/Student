package com.jacksonAnnotations;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student{
	
	private Map<String,String> properties;
	public Student() {
	 properties =new  HashMap<>();
	}
	
	@JsonAnyGetter
	public Map<String , String> getProperties(){
		return properties;
		
	}
	public void add(String property,String value) {
		properties.put(property,value);
	}
}
public class JsonAnyGetter1 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Student student = new Student();
			student.add("Name", "Mark");
			student.add("Rollno", "1");
			
			String jsonString = mapper
					.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			System.out.println(jsonString);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
