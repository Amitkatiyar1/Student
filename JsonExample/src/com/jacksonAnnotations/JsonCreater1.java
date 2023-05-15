package com.jacksonAnnotations;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

// use Json creator and jsonAnySetter and json creator 

class StudentC{
	@JsonProperty("Name")
	private Map<String ,String> properties;
	
	public StudentC(){
		 properties= new HashMap<>();
	}
	
	public Map<String, String> getProperties() {
		return properties;
	}
@JsonAnySetter
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	

	public String name;
	public int age;
	@JacksonInject
	public int rollno;
	
	@JsonCreator
	public StudentC(@JsonProperty("theName")String name, @JsonProperty("id")int age) {
		this.age=age;
		this.name=name;
		
	}
}
public class JsonCreater1 {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"name\":\"Amit\",\"age\":6,\"Name\" : \"Mark\"}";
		InjectableValues injectv = new InjectableValues.Std().addValue(int.class, 90);
		
		try {
		StudentC stu = mapper.reader(injectv).forType(StudentC.class).readValue(json);
			System.out.println(stu.age+" "+stu.name+" "+stu.rollno+" "+stu.getProperties().get("Name"));
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
