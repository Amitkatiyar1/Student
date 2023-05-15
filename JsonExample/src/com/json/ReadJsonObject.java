package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonObject {

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {

		Object obj = new JSONParser().parse(new FileReader("jsonExample.json"));

		// typecasting obj to JSonObject

		JSONObject jo = (JSONObject) obj;

		// getting firstName and LastName

		String str = (String) jo.get("FirstName");
		String str1 = (String) jo.get("LastName");
		System.out.println(str);

		System.out.println(str1);

		long age = (long) jo.get("age");
		System.out.println(age);

		Map Address = (Map) jo.get("Address");
		

		Iterator<Map.Entry> itr = Address.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pair = itr.next();
			System.out.println(pair.getKey() + " " + pair.getValue());
		}

		JSONArray ja = (JSONArray) jo.get("Phone");
		Iterator itr1 = ja.iterator();
		while (itr1.hasNext()) {
			itr = ((Map) itr1.next()).entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry pair = itr.next();
				System.out.println(pair.getKey() + " " + pair.getValue());
			}
		}

	}

}
