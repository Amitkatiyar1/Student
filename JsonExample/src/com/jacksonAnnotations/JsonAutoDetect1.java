package com.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

//@JsonAutoDetect can be used to include properties which are not accessible otherwise.

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class StudentA{
	private int id;
	private String name;
	
	StudentA(int id,String name){
		this.id=id;
		this.name=name;
		
	}
}
public class JsonAutoDetect1 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
		
		StudentA stu = new StudentA(1,"Amit");
		String json = mapper.writeValueAsString(stu);
		System.out.println(json);
		}catch(Exception e) {
		System.out.println(e);
		}
	}

}
