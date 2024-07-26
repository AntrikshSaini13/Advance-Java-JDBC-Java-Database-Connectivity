package JDBC_Established_The_Connection_between_Java_Appliction_Database_By_Type_2_Driver;

import java.sql.*;

//Load a JDBC and Established the Connection between Java Application and Database by using
//the type-2 Driver(JDBC Native API Driver)

//C:\SRC\Oracle_Extract_File\jdbc\lib (path of jar file)
public class Connection_First_Way {
	public static void main(String[] args) {
		try {
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@MYSYSTEM","system","Satkum15!");
			System.out.println("Connection Established");
		} catch (Exception e) {
			System.err.println("Connection not established");
		}
	}
}
