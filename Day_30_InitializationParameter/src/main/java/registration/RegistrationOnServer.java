package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class RegistrationOnServer
 */
public class RegistrationOnServer extends GenericServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;  
    /**
     * @see GenericServlet#GenericServlet()
     */
    public RegistrationOnServer() {
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
		// here we get the data form html registration form by using getParameter method of ServletRequest Interface
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			// here we write of SQL query for insert the data in Database by using the prepareStatement method of belong the Connection Interface
			PreparedStatement preparedstatement = connection.prepareStatement("insert into registration values(?, ?, ?, ?, ?)");
			preparedstatement.setString(1, firstName);
			preparedstatement.setString(2, lastName);
			preparedstatement.setString(3, phoneNumber);
			preparedstatement.setString(4, userName);
			preparedstatement.setString(5, password);
			
			// this execute method for send the data in database this is only for DML Query
			preparedstatement.executeUpdate();
			
			// here send the response to thw Browser by using get Writer belong the ServletResponse Interface create the object
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html><body bgcolor = yellow text=blue><center><h1>");
			printwriter.println("<u>You have Registered Succesfully</u>");
			printwriter.println("<h1></center></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
