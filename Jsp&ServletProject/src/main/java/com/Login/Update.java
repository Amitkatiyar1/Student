package com.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private DaoClass daoClass;
       
	public void init() {
		daoClass = new DaoClass();
		
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Document studentEx = daoClass.getStudent(id);
		RequestDispatcher dg =request.getRequestDispatcher("editform.jsp");
		request.setAttribute("Document", studentEx);
		dg.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
