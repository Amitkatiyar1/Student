package com.Login;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Dconnection {

	public static MongoDatabase getConnection() {
		MongoClient mongoClient = new MongoClient("localhost",27017);
//		MongoClient  mongoClient= new MongoClient(uri);
		MongoDatabase db = mongoClient.getDatabase("Employee");
		
		
		return db;
		
	}


}
