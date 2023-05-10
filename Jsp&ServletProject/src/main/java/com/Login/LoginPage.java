package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginPage extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String c1 = request.getParameter("captcha");
		String c2 = request.getParameter("captcha1");
		
		
		if(uname.equals("Amit") && pass.equals("katiyar") && c1.equals(c2)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			
			response.sendRedirect("Form.jsp");
		}else {
			response.sendRedirect("Loginjsp.jsp");
		}
		
		
		
	}

}
