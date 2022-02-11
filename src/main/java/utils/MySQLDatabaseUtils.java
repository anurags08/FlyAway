
package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDatabaseUtils {
	public static Connection getConnection()
	  throws SQLException, ClassNotFoundException{
		
		String clasName ="com.mysql.cj.jdbc.Driver";
		
		Class.forName(clasName);
		System.out.println("the driver loaded sucessfully");
		
		String url = "jdbc:mysql://localhost:3306/studentdb?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root";
		String password ="Anurag@1998";
		
		Connection connection =null;
		try {
		connection =DriverManager.getConnection(url,user,password);

		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return connection;
	}

}
