package com.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder({"id","Fullname","rollno"})
class Amit{
	private String Fullname;
	private int rollno;
	private int id;
	public Amit(String Fullname,int rollno,int id) {
		this.Fullname= Fullname;
		this.rollno=rollno;
		this.id=id;
		
	}
	public Amit(String Fullname,int rollno) {
		this.Fullname= Fullname;
		this.rollno=rollno;
		this.id=67;
		
	}
	public String getFullname() {
		return Fullname;
	}
	public int getRollno() {
		return rollno;
	}
	public int getId() {
		return id;
	}
	
}
public class JsonPropertityOrder {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Amit stu = new Amit("Amit katiyar",98);
		try {
			String jsonString = mapper.writeValueAsString(stu);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
