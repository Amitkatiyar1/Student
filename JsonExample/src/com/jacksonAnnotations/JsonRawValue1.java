package com.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;

class Stu {
	private String name;

	@JsonRawValue
	
	private String json;
	private int rollno;

	public Stu(String name, int rollno, String json) {
		this.name = name;
		this.rollno = rollno;
		this.json = json;
	}

	public String getName() {
		return name;
	}

	public int getRollno() {
		return rollno;
	}

	public String getjson() {
		return json;
	}
}
	public class JsonRawValue1 {
		public static void main(String[] args) {
			ObjectMapper mapper = new ObjectMapper();

			try {
				Stu s = new Stu("Amit", 56, "{\"attr\":false}");
				String jsonString = mapper.writeValueAsString(s);
System.out.println(jsonString);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
