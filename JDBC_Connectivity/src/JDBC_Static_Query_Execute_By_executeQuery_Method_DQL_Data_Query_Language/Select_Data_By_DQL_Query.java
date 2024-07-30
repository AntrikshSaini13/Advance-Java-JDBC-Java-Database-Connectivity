package JDBC_Static_Query_Execute_By_executeQuery_Method_DQL_Data_Query_Language;

import java.sql.*;

// Program to retrieve data from the database by  using executeQuery() method and DQl Query

public class Select_Data_By_DQL_Query {
	public static void main(String[] args) {		
		try {
//			Loading the Specific  Driver 
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			Established The Connection between Application and Database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:MYSYSTEM", "MyDB11AM", "123");
			
//			
			Statement st = con.createStatement();
			
//			
			ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS");
			
//			
			ResultSetMetaData  rm = rs.getMetaData();			
			int columnNum = rm.getColumnCount();
			for(int i=1; i<=columnNum; i++) {
				System.out.print(rm.getColumnName(i)+"\t");
			}
			
			System.out.println();
//			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3)+"\t");
			}
			
			
		} catch (ClassNotFoundException e) {			
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
}
