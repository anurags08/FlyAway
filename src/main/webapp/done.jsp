<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>status</title>
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
 <p align="right">
 
  <form action="Logout"  align="right" method="post">
 <input type="submit" value="Logout" style="color:red ; padding:10px; background-color:lightgreen;"/> 
 </form> </p>
<div align="center">
<h2> your payment has Sucessful </h2>

</div>

<h3><a href="welcome.jsp">main page</a></h3>
</body>
</html>