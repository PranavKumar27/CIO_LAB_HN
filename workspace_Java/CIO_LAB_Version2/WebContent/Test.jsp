<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flashing</title>
</head>
<style>
body {
    background-image: url("images/gobeyond.png");
}

</style>


<body style="text-align:center">
<script>

function move() {
  var elem = document.getElementById("myBar");   
  var width = 0;
  var id = setInterval(frame, 500);
  function frame() {
    if (width >= 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
      elem.innerHTML = width * 1  + '%';
      }
  }
}
</script>



<h1>CIO LAB MANAGEMENT</h1>
 
<h2>Common Embedded Platform Firmware Upgrade</h2>
<H3> <font color="black" >BASE IP - 11.1.205.X</i> </font></H3></H3>

<div class="w3-light-grey">
  <div id="myBar" class="w3-container w3-green" style="height:5px;width:10px">0%</div>
  </div>


<form style="text-align:center" method="post" action="FLASH.CIO" enctype="multipart/form-data">

<table align="center">
		<tr>
			<tc>
				<td>
					<h4>Enter Node Index</h4>
				</td>
			</tc>
			<tc>
				<td>
					<h4>Select UOC/CN100 firmware file </h4>
				</td>
			</tc>
			<tc>
				<td>
						<H4>         <input type="hidden"/>        </H4>
				</td>
			</tc>
		
		</tr>
		
		<tr>
			<tc>
				<td>
					<input type="text" name="address" placeholder="X" size="2">
				</td>
			</tc>
			<tc>
				<td>
					   <input type="file" name="file" accept=".zip"/>
				</td>
			</tc>
		
			<tc>
				<td>
					<input type="submit" value="Flash" onclick="move()" size="10"/>
				</td>
			</tc>
		</tr>
</table>

<br>
<!--  <a href="Test.jsp">Refresh</a>-->
<br>


<%

	String Device_Status=(String)request.getAttribute("Device_Status");
	String IPERROR=(String)request.getAttribute("IPERROR");
	String Flash_RESULT=(String)request.getAttribute("Flash_RESULT");
	String message=(String)request.getAttribute("Message");
	String File_Sel_ERROR=(String)request.getAttribute("File_Sel_ERROR");
	String File_Upload_Status=(String)request.getAttribute("File_Upload_Status");

			   
	
	String USER_MESSAGE="";
	if(Device_Status!=null)
		USER_MESSAGE+=Device_Status+"<br>";
	
	
	
	if(IPERROR!=null)
		USER_MESSAGE+=IPERROR+"<br>";
	
	
	
	if(File_Upload_Status!=null)
		USER_MESSAGE+=File_Upload_Status+"<br>";
	
	
	
	if(Flash_RESULT!=null)
		USER_MESSAGE+=Flash_RESULT+"<br>";
	
	
	
	if(File_Sel_ERROR!=null)
		USER_MESSAGE+=File_Sel_ERROR+"<br>";
	
	
	
	if(message!=null)
		USER_MESSAGE+=message+"<br>";
	
	System.out.println("UserMessage="+USER_MESSAGE);
	request.setAttribute("Message", USER_MESSAGE);
	
%>	
	
	<!--  <font color="green" size="3" >${Device_Status}<br></font>
	<font color="red" size="3"> ${IPERROR}<br></font>
    <font color="blue" size="3"> ${File_Upload_Status}<br></font>
    <font color="green" size="3"> ${Flash_RESULT}<br></font>
	<font color="blue" size="3"> ${File_Sel_ERROR}<br></font>
	<font color="red" size="3"> ${message}<br></font>
	-->
	
	<font color="blue" size="3"> <B>${Message}<B>


</form>

</div>
  
<br><br>
</body>
</html>