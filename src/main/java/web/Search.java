package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MySQLDatabaseUtils;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String SELECT_SQL1 ="SELECT * FROM traindetails WHERE source=";
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String noOfPassenger = request.getParameter("noOfPassenger");
		String date = request.getParameter("date");
		String uname= request.getParameter("name");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body  style='background-color:lightgrey;'>");

		HttpSession session= request.getSession();
		if(session==null)
			response.sendRedirect("login.jsp");
		out.println("<p style='color:green;' align='center'> <b > Welcome : "+uname+"</b> </p>");
		 
		 
		
		out.println("<p align='right'>");
		 
		out.println(" <form action='Logout'  align='right' method='post'>");
		out.println(" <input type='submit' value='Logout' style='color:red ; padding:10px; background-color:lightgreen;'/>"); 
		out.println(" </form> </p>");
		out.println(" <hr>  <br>");
		
		
		  

		
		
		
		
		out.println("available trains are :");
		out.println("<br>");
		
		
		Connection connection=null;
		
		try {
			connection = MySQLDatabaseUtils.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
	Statement statement=null;
	 String id="";
	ResultSet resultSet=null;
	try {
		
		 statement =   connection.createStatement();
		 
		 resultSet = statement.executeQuery(SELECT_SQL1+"'"+source+"' AND destination='"+destination+"'");  
		 if(resultSet==null)
			 response.sendRedirect("welcome.jsp");
		 
         int status=0;
         
		 while(resultSet.next()) {
		 
		    id= resultSet.getString("id");
			String details = resultSet.getString("details");
			out.println(details);
			out.println("<br><br>");
	
			
			}
//		 if(resultSet.next()) {
//			 
//				 resultSet.close();
//			 response.sendRedirect("welcome1.jsp");
//			
//		 }
//		 else {
//			 response.sendRedirect("welcome.jsp");
//			 resultSet.close();
//		 }
		
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		response.sendRedirect("welcome.jsp");
		//out.println("error");
	}
	
	out.println("<table class='center'>");
	  
	out.println("</table>");
	  
	
	
	out.println("<form action='booking.jsp' >"); 
	out.println("Enter train no : ");
	out.println("<input type='text' name='trainno'>");
	
	
	out.println("<input type='hidden' name='noOfPassanger' value= "+noOfPassenger+">");
	
	out.println("<input type='submit' value='book'");
	
	
	out.println("</form>");
	
	out.println("</html>");
	out.println("</body>");
	out.close();

	}

	
	
}
