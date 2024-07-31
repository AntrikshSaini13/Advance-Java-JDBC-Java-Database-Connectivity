package Jdbc_Static_Query_Execute_By_executeQuery_Method__DQL_Data_Query_language_2;

import java.sql.*;

//Program to retrieve the data from database by using getInt(), getString(), Passing the parameter, 
//it means record name than get the data
public class GetDataFirstWay{
	public static void main(String[] args) throws SQLException {
		try {
//			this is for loading the Driver between Application And Database
			Class cl = Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			Established the Connection 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:MYSYSTEM", "MyDB11AM", "123");
			System.out.println("Connection Established");
//			Statement Interface for only Static Query 
			Statement st = con.createStatement();
			
//			executeQuery() method for DQl Query return the record and field 
			ResultSet rs =  st.executeQuery("SELECT * FROM STUDENTS");
			System.out.println("Retrive the data of Students in table");
			
//			Here we gets the fiekd of the data base
			ResultSetMetaData rm = rs.getMetaData();	
			
//			here is gets the number of fields
			int columnNum = rm.getColumnCount();
			
//			this loop for getting the record one by one of the position
			System.out.println("we getting the field and records");
			for (int i = 1; i <= columnNum; i++) {
				System.out.print(rm.getColumnName(i)+"\t");
			}
			System.out.println();
			
//			This loop for getting the field of Database one by one
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3)+"\t");
			}
			
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
}
