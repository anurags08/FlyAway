<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payment portal</title>
</head>
<body>
<%
  response.setHeader("Cache-Control" , "no-cache,no-store,must-revalidate");  // for not storing cachedata  HTTP 1.1
 // response.setHeader("Pragma", "no-cache");  // HTTP 1.0
 // response.setHeader("Expires", "0");   // Proxies
		  
 if(session.getAttribute("username")==null){
	 response.sendRedirect("login.jsp");
 }
	 

%>
<br>
<a  href="booking.jsp"> Back</a>
<br>
 
<br>
<div align="center">
<form action="done.jsp" method="post">

<table>
<tr>
<td> Enter card number</td>
<td>
<input type="text" name="cardno"/>
</td>
</tr>
<tr>
<td>Enter Expiry date</td>
<td>
<input type="date" name="expirydate">
</td>
</tr>
<tr>
<td> Enter CCV number </td>
<td>
<input type="text" name="ccv">
</td>
</tr>

<tr>
<td> <input type="submit" value="submit"/>
</tr>
</table>
</form>
</div>

</body>
</html>