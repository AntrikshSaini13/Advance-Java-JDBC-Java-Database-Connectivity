package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class LoginOnServer
 */
public class LoginOnServer extends GenericServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;  
    /**
     * @see GenericServlet#GenericServlet()
     */
    public LoginOnServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String DRIVER = config.getInitParameter("DRIVER");
		String URL = config.getInitParameter("URL");
		String USERNAME = config.getInitParameter("USERNAME");
		String PASSWORD = config.getInitParameter("PASSWORD");
		
		// here load the driver by forName method dynamically
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// get the data form html file by getParamter method
		String userName = request.getParameter("firstName");
		String password = request.getParameter("firstName");
		
		// send the reaponse to server 
		PrintWriter printwriter = response.getWriter();
		printwriter.println("<html><body bgcolor = yellow text=blue><center><h1>");
		try {
			// here the sql query in prepareStatement method
			PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM REGISTRATION WHERE USERNAME = ? AND PASSWORD = ?");
			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, password);
			
			// here we get the data form database and store Result set
			ResultSet resultSet = preparedstatement.executeQuery();
			
			// here we get the metadata
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			int countColumn = resultSetMetaData.getColumnCount();
			
			if(resultSet.next()) {
				printwriter.println("<u>Welcome </u>"+userName+"<br><br>");		
				
				for(int i=1;i<=countColumn;i++) {
					printwriter.println(resultSetMetaData.getColumnName(i));
				}
				printwriter.println("<br>");
				for(int i=1;i<=countColumn;i++) {
					printwriter.println(resultSet.getString(i).toUpperCase());
				}
			}
			else {
				printwriter.println("<u>Wrong User Name and Password : "+userName+"<br><br></u>");
			}
			printwriter.println("<h1></center></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
