package web;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MySQLDatabaseUtils;

@WebServlet("/select-sql")
public class SelectCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private static String INSERT_SQL ="insert into customers(name,password) values (?,?)";  //dynamic query
//	private static String SELECT_SQL ="select name,password from customers where ";
	private static String SELECT_SQL1 ="SELECT * FROM customers WHERE name=";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
				
			Connection connection=null;
			
			try {
				connection = MySQLDatabaseUtils.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			
			 statement =   connection.createStatement();
			 
			 resultSet = statement.executeQuery(SELECT_SQL1+"'"+username+"' AND password='"+password+"'");  
//			 if(resultSet==null)
//				 response.sendRedirect("welcome.jsp");
			 
			 // int status=0;
//			 while(resultSet.next()) {
//				 
//				String name= resultSet.getString("name");
//				String pass = resultSet.getString("password");
//				out.println(name+"   "+pass+"<br>");
//				
//				}
			 if(resultSet.next()) {
				 HttpSession session=request.getSession();
 				session.setAttribute("username", username);
 				 resultSet.close();
				 response.sendRedirect("welcome.jsp");
				
			 }
			 else {
				 response.sendRedirect("login.jsp");
				 resultSet.close();
			 }
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			response.sendRedirect("login.jsp");
			//out.println("error");
		}
		
		
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
		
	}


}
