<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.center {
margin: auto;
width: 60%;
border: 2px solid ;
padding: 10px;
}

</style>
<body>
<%
  response.setHeader("Cache-Control" , "no-cache,no-store,must-revalidate");  // for not storing cachedata  HTTP 1.1
 
		  
 if(session.getAttribute("username")==null){
	 response.sendRedirect("login.jsp");
 }
	 

%>
<%
String cardno= request.getParameter("cardno");
String date = request.getParameter("expirydate");
String ccv= request.getParameter("ccv");

//out.println(cardno);
%>


	  <br>
	 
         <%
         int totalmoney=2;
         int price=60;
       
         
 //String  count= request.getParameter("noOfPassanger");
 String trainno= "32562"; //  request.getParameter("trainno");
  int n= 2;  //  Integer.parseInt(count);   // it will 
  String SELECT_SQL1 ="SELECT * FROM traindetails WHERE trainno=";
  java.sql.Connection connection=null;
	
	
		connection = utils.MySQLDatabaseUtils.getConnection();
	
	
		java.sql.Statement statement=null;
       
        java.sql.ResultSet resultSet=null;
 
	
	 statement =   connection.createStatement();
	 
	 resultSet = statement.executeQuery(SELECT_SQL1+"'"+trainno+"'");  
	
   
	 while(resultSet.next()) {
	  
	 
		String details = resultSet.getString("details");
		

		out.println(details);
		}

	 

  
  for(int i=0;i<n;i++){
	  int k=i+1;
	   
	  %>
	  
	  
	  <div class="center" >
	  Please fill Person : <%=k %> Details
	  <br>
	 
     <form action="" method="post">
         <table class="center1" style="padding:10x;">
	 
            <tr> <td> Name : </td> <td> <input type="text" name="name" placeholder="name" required /> </td>  
            </tr>
             <tr> <td> Age : </td> <td> <input type="text" name="age" placeholder="age" required /> </td>  
            </tr>
             <tr> <td>Phone</td> <td> <input type="text" name="phone" placeholder="phone" required /> </td>  
            </tr>
            
          
             
           

         </table>
         <br><br>
     </form>

</div>
<% } %>


<form action="payment.jsp" class="center">
<h5> Total Amount is : <%=n %> X <%=price %> = <%=n*price %> </h4>
<input type="text" value=<%=n*price %>> $
<input type="submit" value="pay">
</form>
	  



</body>
</html>