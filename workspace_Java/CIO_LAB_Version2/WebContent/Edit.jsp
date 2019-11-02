<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CIO-LAB</title>
</head>
<body>
<h1>CIO LAB PORTAL</h1>
<h2>EDIT FORM</h2>
<br>
	<!--  <font color="red" size="5"> ${Result}</font> -->
<br>
<form action="Details.CIO" method="post">
<table align="center">
	<tr>
		<td>Device Type:</td>
		<td>C300<input type="radio" name="C300" value="C300"></td>
		<td>UOC <input type="radio" name="UOC" value="UOC"></td>
		<td>CN100<input type="radio" name="CN100" value="CN100"></td>
		<td>C200<input type="radio" name="C200" value="C200"></td>
		<td>FIM<input type="radio" name="FIM" value="FIM"></td>
		<td>PGM<input type="radio" name="PGM" value="PGM"></td>
	</tr>
	<tr>
		<td colspan="7" align="center">
		<input type="submit" value="LOGIN">
		</td>
	</tr>
</table>
</form>
</body>
</html>