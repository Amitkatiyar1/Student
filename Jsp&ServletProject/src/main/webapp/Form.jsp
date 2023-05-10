<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style >
.conatainer{
     width: 30%;
	border: 1px solid black;
	margin: auto;
	padding: 20px;
	font-size: 20px;
	background-color:fuchsia;
}
</style>
</head>
<body>
	<form action="Create" method="post">
	<div class = "conatainer">
		<h2>Add new users</h2>

		id : <input type="text" name="id"><br>
		<br> name : <input type="text" name="name"><br>
		<br> email: <input type="text" name="email"><br>
		<br> District: <input type="text" name="District"><br>
		<br>
		<button type="submit">save</button>
		<br>
		<!-- <br> <a href="Show.jsp"> view Student</a> -->
		<a href = "Create">View</a>
		</div>
	</form>
	
</body>
</html>