package com.Login;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class DaoClass {

	 private static MongoCollection<Document> collection;
	 

	public   DaoClass(){
		
		MongoClient client = new MongoClient("localhost",27017);
		MongoDatabase  db = client.getDatabase("Student");
		
		 this.collection=db.getCollection("Document");
		
	}

	
	
	// get student
	public List<Document> getStudents(){
		FindIterable<Document> result = collection.find();
		List<Document> student = new ArrayList<>();
		for(Document document :result) {
			student.add(document);
		}
		return student;
	}
	
  // get by id
	public Document getStudent(int id) {
		Document query = new Document("id",id);
		FindIterable<Document> result = collection.find(query);
		Document user = result.first();
		return user;
		
	}
	
	// update
	
	public static void updateStudent(int id,String name ,String email,String District) {
		Document us = new Document("id",id);
		Document updateD = new Document("$set" ,new  Document("name" ,name).append("District", District).append("email", email).append("id", id));
		collection.updateOne(us, updateD);
	}
	// save data
	
	public static void saveStudent(int id, String name, String email, String District) {
		Document student = new Document("id",id).append("name",name).append("email",email)
				.append("District", District);
			collection.insertOne(student);
		
	}

	 // Delete data
	 public void doDelete(int id)
	           {
		Document  deleteQ = new Document("id",id);
	        collection.deleteOne(deleteQ);
	       
	    }
	
	
	
	
	

	

	
		
		
		




	
}
