<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>user interface</title>
<style>
.center {
margin: auto;
width: 80%;
border: 2px solid blue ;
padding: 20px;
}

</style>
</head>
<body style="background-color:lightgrey;">
<br>

 <div align="center">
 <h4> Search & Check Availability</h4>
<form action ="UserSearch" method="Post">
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
  
  <tr>
  <td> <input type="submit" value="search"/> </td>

 </tr>
</table>
</form>
</div>


 <br>


</body>
</html>