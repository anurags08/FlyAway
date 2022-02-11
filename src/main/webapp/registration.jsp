<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration portal</title>
<style>

.center {
margin: auto;
width: 60%;
border: 2px solid ;
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


<br>
<div class="center" >

     <h3 style="text-align: center; color: blue; background-color:gray; padding:20px;"> Welcome to FlyAway  </h3>
    
     <h3 style="text-align: center;"> Registration  </h3>

     <form action="RegistrtionData" method="post">
         <table class="center1" style="padding:30x;">
            <tr> <td> Name : </td> <td> <input type="text" name="name" placeholder="name" required /> </td>  
            </tr>
             <tr> <td> Email : </td> <td> <input type="email" name="email" placeholder="email" required /> </td>  
            </tr>
             <tr> <td>Phone</td> <td> <input type="text" name="phone" placeholder="phone" required /> </td>  
            </tr>
             <tr> <td> Username : </td> <td> <input type="text" name="username" placeholder="username" required /> </td>  
            </tr>
            
            <tr> <td> Password : </td>
                 <td> <input type="password" name="password" placeholder="password" required/> </td> 
            </tr> 
             
            <tr  >  <td> <input type="reset" value="Clear"/> </td> 
                   <td><input type="submit" value="Register"/>  </td> 
            </tr>

         </table>
     </form>

</div>


</body>
</html>