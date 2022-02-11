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
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static String SELECT_SQL1 ="SELECT * FROM traindetails WHERE source=";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String noOfPassenger = request.getParameter("noOfPassenger");
		String date = request.getParameter("date");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body  style='background-color:lightgrey;'>");

		
		 
		
		
		out.println(" <hr>  <br>");
		
		
		  

		
		
		
		
		out.println("Available Trains are :");
		out.println("<br><br>");
		out.println("<div style='align:center;'>");
		
		out.println("<table>");
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
			 response.sendRedirect("index.jsp");
		 
         int status=1;
         
		 while(resultSet.next()) {
		  
		    id= resultSet.getString("id");
			String details = resultSet.getString("details");
			out.println("<tr> ");
			out.println("<td>");
			
			out.println("</td>");
			out.println("<td> ");
			out.println(details);
			out.println("<br><br>");
			out.println("</td> ");
			out.println("</tr> ");
	
			status++;
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
		
		response.sendRedirect("index.jsp");
		//out.println("error");
	}
	out.println("</table>");
	
	out.println("</div>");
	out.println("<table style='align:center;'>");
	  
	out.println("</table>");
	  
	
	
	out.println("<form action='booking.jsp' >"); 
	out.println("Enter train no : ");
	out.println("<input type='text' name= 'trainno'/>");
	
	out.println("<input type='hidden' value= "+noOfPassenger+">");
	
	out.println("<input type='submit' value='book'");
	
	
	out.println("</form>");
	
	out.println("</html>");
	out.println("</body>");
	out.close();

	}

}
