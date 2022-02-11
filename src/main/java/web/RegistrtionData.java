package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrtionData
 */
@WebServlet("/RegistrtionData")
public class RegistrtionData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    	String name= request.getParameter("name");
    	String email=request.getParameter("email");
    	String phone= request.getParameter("phone");
    	String username= request.getParameter("username");
    	String password= request.getParameter("password");
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
    	
    	try
        {
          // create a mysql database connection
          String myDriver = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/studentdb";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "Anurag@1998");
        
          // create a sql date object so we can use it in our INSERT statement
          Calendar calendar = Calendar.getInstance();
          java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

          // the mysql insert statement
          String query = " insert into maindata (name, email, phone, username, password)"
            + " values (?, ?, ?, ?, ?)";

          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, name);
          preparedStmt.setString (2, email);
          preparedStmt.setString   (3, phone);
          preparedStmt.setString(4, username);
          preparedStmt.setString    (5, password);

          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
    	
    	out.println("Your Registration completed ! you can login ");
    	response.sendRedirect("login.jsp");
    	out.println("<a href='login.jsp'> login to continue </a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    	//
       
	}

}
