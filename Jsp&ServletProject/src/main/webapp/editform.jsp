<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${students!=null }">

 <form action="Update" method="post">

</c:if>

<!-- <form action="Update" method="post"> -->
	
		<h2> update users</h2>
  
		id : <input type="text" name="id"  value="${students.id}"><br>
		<br> name : <input type="text" name="name" value="${students.name}"><br>
		<br> email: <input type="text" name="email"value="${students.email}"><br>
		<br> District: <input type="text" name="District"value="${students.District}"><br>
		<br>
		<button type="submit">save</button>
		<br>
		
		
	</form>
	
</body>

</body>
</html>