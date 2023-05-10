<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
width:20%;
border:1px solid black;
margin:auto;
padding :10px;
font-size:20px;
background-color: gray;
}

</style>

</head>
<body>
<div class="container">
	<form action="Login" method="post">
	<h2>Login here</h2>
	Enter username: <input type = "text" name ="uname"> <br><br>
	Enter password : <input type = "password" name = "pass"> <br><br>

	<%@include file="Captcha.jsp" %>
	<input style= "color: green;  font-size: 15px;border: 0px;background-color:red " name ="captcha" value=<%=sb %> readonly="readonly" >
	 captcha:<input type="text" name="captcha1" ><br><br>
	
	
	
	
	<input type = "submit" value = "login"><br>
	
		
	</form>
	</div>
</body>
</html>
