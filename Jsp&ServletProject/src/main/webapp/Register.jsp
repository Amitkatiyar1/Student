<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.container {
	width: 30%;
	border: 1px solid black;
	margin: auto;
	padding: 20px;
	font-size: 20px;
	background-color:red;
}
</style>
</head>
<body>
	<div class="container">


		<h1>My Form</h1>
		<form action="Register">
			<table>
				<tr>
					<td>Enter your First name :</td>
					<td><input type="text" name="username"
						placeholder="Enter name" /></td>

				</tr>
				
				<tr>
					<td>Enter your Last name :</td>
					<td><input type="text" name="Lastname"
						placeholder="Enter name" /></td>

				</tr>
				<tr>
					<td>Enter your emailId</td>
					<td><input type="text" name="email" placeholder="Enter email"
						required /></td>
				</tr>
				<tr>
					<td>Enter your password</td>
					<td><input type="password" name="password"
						placeholder="Enter password" required /></td>
				</tr>
				<tr>

				</tr>

				<td>
					<button type="submit">Register</button>
					<button type="reset">Reset</button>
				</td>
			</table>

		</form>
	</div>
</body>
</html>