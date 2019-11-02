<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CIO-LAB</title>
</head>
<body align="center">
<h1>CIO LAB PORTAL</h1>
<h2>Login FORM</h2>
<br>
	<font color="red" size="5"> ${Result}</font>
	<br>
<form action="Details.CIO" method="post">
<table align="center">
	<tr>
		<td>User Name:</td>
		<td><input type="text" name="username" placeholder="Employed ID"></td>
	</tr>
	
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password" placeholder="Employee Password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="LOGIN">
		</td>
	</tr>
</table>
</form>
</body>
</html>