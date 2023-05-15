package com.json;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Decodeobject {

	public static void main(String[] args) {
		String k ="{\"Full name\":\"Ritu Sharma\",\"Rollno\":764786.0,\"id.\":8}";
	
		
		Object file = JSONValue.parse(k);
		
		JSONObject jsonO = (JSONObject)file;
		
		
		// converting into java data type
		
		String name = (String)jsonO.get("Full name");
		double rollno = (double)jsonO.get("Rollno");
		long id = (long)jsonO.get("id.");
		
		
		System.out.println(name+" "+rollno +" "+id);
	}

}
