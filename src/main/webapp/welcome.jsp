<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
  
    <%@ page import="web.Logout" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightgrey;">
<%
  response.setHeader("Cache-Control" , "no-cache,no-store,must-revalidate");  // for not storing cachedata  HTTP 1.1
 // response.setHeader("Pragma", "no-cache");  // HTTP 1.0
 // response.setHeader("Expires", "0");   // Proxies
		  
 if(session.getAttribute("username")==null){
	 response.sendRedirect("login.jsp");
 }
	 

%>
 <p style="color:green;" align="center"> <b > Welcome : ${username}</b>
 
 </p>
 <p align="right">
 
  <form action="Logout"  align="right" method="post">
 <input type="submit" value="Logout" style="color:red ; padding:10px; background-color:lightgreen;"/> 
 </form> </p>
 <hr>
 <br>
 
 <div align="center">
 <h4> Search & Check Availability</h4>
<form action ="Search" method="get">
<table >

  <tr>
  <label for="source">From :</label>
  <select name="source" id="source">
    <option value="">select</option>
    <option value="delhi">delhi</option>
    <option value="delhi">delhi</option>
    <option value="mumbai">mumbai</option>
    <option value="kanpur">kanpur</option>
  </select>
  <br><br>
  
   <label for="destination">To :</label>
  <select name="destination" >
   <option value="">select</option>
    <option value="banglore">banglore</option>
    <option value="jaypur">jaypur</option>
    <option value="mumbai">mumbai</option>
    <option value="kanpur">kanpur</option>
  </select>
  <br><br>
  </tr>
  <tr>
  <td> Number of Passanger </td> <td> <input type="text" name="noOfPassenger"/> </td>
  </tr>
  <tr> <td> Date : </td> <td><input type="date" name="date" /> </td> </tr>
  <tr>  <input type="hidden" id="custId" name="name" value= &{username}> </tr>
  <tr>
  <td> <input type="submit" value="search"/> </td>

 </tr>
</table>
</form>
</div>


 <br>
 
</body>
</html>