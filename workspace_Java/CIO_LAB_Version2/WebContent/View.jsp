<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Verify_Login.Device,Verify_Login.Verify_User,java.io.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CIO-LAB</title>
</head>
<body align="center">
<font color="red" size="5"> ${MSG} </font>
<%
	ArrayList dev=(ArrayList)request.getAttribute("dlist");
%>
<%
%>


<%
String ip=(String)request.getAttribute("ip");
String fileName = "C\\temp\\"+ip+"\\output1.txt";
System.out.println("filename to be read="+fileName);
InputStream ins = application.getResourceAsStream(fileName);
try
{
if(ins == null)
{
response.setStatus(response.SC_NOT_FOUND);
}
else
{
BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
String data;
while((data= br.readLine())!= null)
{
out.println(data+"<br>");
}
} 
}
catch(IOException e)
{
out.println(e.getMessage());
}
%>
<br>
<br>
	<font size=5>Total UOC Devices:	<b><% out.println(dev.size()); %></b></font>
	<br><br>
	<font size=5> Devices Ranges: <b>1 to 30</b> </font>
<% 	
	Iterator it=dev.iterator();

	while(it.hasNext())
	{
		Device d=(Device)it.next();
		%>
		<table>
			<tr>
				<td><font size=3 color="blue">HOST ID:</font><% out.print(d.getHost_id()); %></td>
			</tr>
			<tr>
			<br>
			</tr>
			<tr>
				<td><font size=3 color="blue">CURRENTLY USED BY:</font><% out.println(d.getUser()); %></td>
			</tr>
		</table>
	<% 
	}
%>
</body>
</html>