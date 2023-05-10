<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Random r = new Random();
	 int count =5;
	 final String random = "0123456789";
	final String ran = "ABCDEFGHIJKLMNOPQRST";
    StringBuffer sb =  new StringBuffer();
       for (int i = 0; i <count ; i++) {
           int num = r.nextInt(random.length());
          
           sb.append(random.charAt(num));
       }
	
	%>
	
	
</body>
</html>