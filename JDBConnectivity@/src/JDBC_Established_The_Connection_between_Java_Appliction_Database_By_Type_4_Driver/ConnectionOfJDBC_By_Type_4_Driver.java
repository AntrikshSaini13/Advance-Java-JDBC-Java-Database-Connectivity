package JDBC_Established_The_Connection_between_Java_Appliction_Database_By_Type_4_Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOfJDBC_By_Type_4_Driver {
	public static void main(String[] args) throws SQLException {
		try {
			// Loading the Specific Driver
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection Established b/n application and database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "Satkum15!&");
			System.out.println("Connection is Established SucessFully");
			
		} catch (ClassNotFoundException e) {
			System.err.println("Connection is not Established");
		}
	}
}