package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String Lname = request.getParameter("Lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		create a connection
		MongoClient uri = new MongoClient("localhost",27017);
		MongoDatabase db = uri.getDatabase("Student");
		MongoCollection<Document> collection = db.getCollection("Document");
		
		// create a new Document
		
		Document d = new Document();
		d.append("username", name);
		d.append("Lastname", Lname);
		d.append("email", email);
		d.append("password", password);
		
		collection.insertOne(d);
		uri.close();
		
	
		if(name==null) {
			response.sendRedirect("Register.jsp");
		}else {
			response.sendRedirect("Loginjsp.jsp");
		}
	}

	
	

}
