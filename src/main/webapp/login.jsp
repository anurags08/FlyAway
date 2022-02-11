<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login portal</title>
<style>

.center {
margin: auto;
width: 60%;
border: 5px solid green;
padding: 10px;
}
.center1 {
margin: auto;
width: 60%;

padding: 10px;
}


</style>
</head>
<body  >
<%
  response.setHeader("Cache-Control" , "no-cache,no-store,must-revalidate"); 
%>

<div class="center" >

     <h3 style="text-align: center; color: blue; background-color:lightgreen; padding:20px;"> Welcome to FlyAway  </h3>
    
     <h3 style="text-align: center;"> Log in to Continue  </h3>

     <form action="select-sql" method="post">
         <table class="center1" style="padding:30x;">
            <tr> <td> Username : </td> <td> <input type="text" name="username" placeholder="username" required /> </td>  
            </tr>
            <tr> <td> Password : </td>
                 <td> <input type="password" name="password" placeholder="password" required/> </td> 
            </tr> 
             
            <tr  >  <td> <input type="reset" value="clear"/> </td> 
                   <td><input type="submit" value="login"/>  </td> <td> <a href="forgotPassword">Forgot Password ?</a>
            </tr>
            
            <tr> <td><a href="registration.jsp" > <b>Register </b></a> </td> </tr>

         </table>
     </form>

</div>



</body>
</html>