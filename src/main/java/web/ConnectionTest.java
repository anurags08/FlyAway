package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MySQLDatabaseUtils;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/ConnectionTest")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		
		
		out.println("hello ");
		
		try {
			Connection connection= MySQLDatabaseUtils.getConnection();
		}catch(Exception e) {
			e.getStackTrace();
		}
			
		
		
		out.println("connnected");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}


}
