package com.json;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class jsonParse {

	public static void main(String[] args) throws FileNotFoundException {
		JSONObject jo =  new JSONObject();
		jo.put("FirstName", "Amit ");
		jo.put("LastName", "Katiyar");
		jo.put("age", 98);
		
		
		// Qualifiaction create hashmap
		
		Map m =new LinkedHashMap(3);
		m.put("inter", "VDI");
		m.put("Bachelor","CSJMU");
		m.put("Master", "BU");
		
		// putting address to json object
		jo.put("Address", m);
		
		//create phone number json
		
		JSONArray ja = new JSONArray();
		
	  m= new LinkedHashMap(2);
		m.put("Home", 8686);
		m.put("Second", 766);
		
//		put map to list
		
		ja.add(m);
		
	m = new LinkedHashMap(2);
	m.put("mobile", 8787987);
	m.put("Second mobile", 7678787);
	
	// put
	ja.add(m);
		
		//putting phoneNumbers to object
	jo.put("phone", ja);
	
	PrintWriter pw = new PrintWriter("JsonExample.json");
	pw.write(jo.toJSONString());
//	System.out.println(j);
	pw.flush();

	pw.close();
	
	
		
	}

}
