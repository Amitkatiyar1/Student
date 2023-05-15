package com.jacksonAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

class StudentTest{
	public int id;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
   public Date date;
	
   StudentTest(int id , Date date){
	   this.id = id;
	   this.date= date;
   }
}
public class JsonFormat1 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = simple.parse("02-12-2022");
			StudentTest stu = new StudentTest(1,date);
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
			System.out.println(jsonString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
