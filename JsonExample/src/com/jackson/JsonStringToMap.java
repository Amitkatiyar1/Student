package com.jackson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStringToMap {

	public static void main(String[] args) {
		
		
		// create instance of the ObjectMapper class to map JSON data  
		ObjectMapper mapper = new ObjectMapper();
		
		File FileObj = new File("jsonFile");
		try {
			Map <String, Object> userData = mapper.readValue(FileObj,new TypeReference<Map<String ,Object>>
			(){
			
			
});
			//print all key value pairs
			
			
			System.out.println("Name : "+ userData.get("Name"));
			System.out.println("Mobile:"+ userData.get("Mobile"));
System.out.println("Address: "+ " "+ userData.get("Address"));
System.out.println("pet"+" "+userData.get("pet"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	

}
}