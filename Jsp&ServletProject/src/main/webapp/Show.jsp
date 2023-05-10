<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<style >
.c{
     width: 30%;
	border: 1px solid Red;
	margin: auto;
	padding: 20px;
	
	
}
</style>
</head>
<body>
<h2> Added Successfully</h2>
<div class ="c">
<h1> User List</h1>
<h2><a href = "Form.jsp">Add student</a></h2>
<table border = "1" >
<tr><th>Id </th><th>Name</th>
<th>Email</th>
<th>District</th>
<th>Delete</th>
<th>Update</th>

<c:forEach  var="students"  items="${students}">
<tr>
<td> <c:out value="${students.id}"></c:out></td>
<td> <c:out value="${students.name}"></c:out></td>
<td> <c:out value="${students.email}"></c:out></td>
<td> <c:out value="${students.District}"></c:out></td>
<td> <a href = "Delete?id=<c:out value ='${students.id}'/>">Delete</a></td>
<td> <a href = "Update?id=<c:out value = '${students.id}'/>">Update</a>
</tr>

</c:forEach>

 </table>
</div>
</body>
</html>




