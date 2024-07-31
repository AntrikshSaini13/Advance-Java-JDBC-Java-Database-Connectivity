package run_application_in_Eclipse;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ConnectionSecond {
	public static void main(String[] args) {
		try {
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@MYSYSTEM","MYDB11Am","123");
			System.out.println("Connection Established");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS");			
			ResultSetMetaData rm = rs.getMetaData();
			int numColumn = rm.getColumnCount();
			for(int i = 1; i <= numColumn; i++) {
				System.out.print(rm.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next()) {
				for(int i = 1; i <= numColumn; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
				
			}
			
		} catch (Exception e) {
			System.err.println("Connection not established");
		}
	}
}
