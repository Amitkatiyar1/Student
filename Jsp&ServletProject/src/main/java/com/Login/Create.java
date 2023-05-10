package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;


@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoClass daoClass;
	 
	public void init() {
 daoClass = new DaoClass();	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
    String District = request.getParameter("District");
    
  DaoClass.saveStudent(id,name,email,District);
    response.sendRedirect("Form.jsp");
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Document> students = daoClass.getStudents();
		request.setAttribute("students", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Show.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
