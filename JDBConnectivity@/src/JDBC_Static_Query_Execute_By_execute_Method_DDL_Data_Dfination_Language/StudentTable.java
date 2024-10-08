package JDBC_Static_Query_Execute_By_execute_Method_DDL_Data_Dfination_Language;

import java.sql.*;

public class StudentTable {
	public static void main(String[] args) {

		try {
//			Loading the Specific driver-4
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver1");
			
//			Connection Established between Application and Database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:MYSYSTEM", "MYDB11AM", "123");
			System.out.println("Connection Established");
			
//			Statement interface it is used to createStatement() method for Static SQL Query
			Statement statement = con.createStatement();			
			
//			execute method it is suitable for DDMl Query
			System.out.println("table created of students");
		} 
		catch (ClassNotFoundException e)  {
			System.out.println("Connection Is not Established");
			System.out.println(e);
		}
		catch (SQLSyntaxErrorException e) {
			System.out.println("Table allready availiable in  Database");
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	} 
}
