package registration;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
public class Login extends GenericServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;  
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
		try {
			// here it is used to load driver dynamically Specific JDBC Driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Driver Name - package . sub package . sub package . ClassName  
			
			//Connection established here b/w Java Application and database
			connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL","MYDB11AM","123");
													//Protocol name : Sub protocol name : logical name : Domain Name : Port Number : Service Id			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// here we get the data form html registration form by using getParameter method of ServletRequest Interface
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		
		try {
			// here we write of SQL query for insert the data in Database by using the prepareStatement method of belong the Connection Interface
			PreparedStatement preparedstatement = connection.prepareStatement("select * from registration where username = ? and password = ?");
//			PreparedStatement preparedstatement = connection.prepareStatement("select * form registration where username =? and password =?");
			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, password);
			
			// here we get the data form the database and store the ResultSet Interface 
			ResultSet resultset = preparedstatement.executeQuery();
			
			// here we get the column name 
			ResultSetMetaData resultSetMetaDeta = resultset.getMetaData();
			int columnCount = resultSetMetaDeta.getColumnCount();
			
			// here we create the object of  PrintWriter for give the response in browser
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html><body bgcolor = yellow text=blue><center><h1>");
			printwriter.println("<u>Welcome</u>"+userName+"<br><br>");
		
			
			for(int i=1;i<=columnCount;i++) {
				printwriter.println(resultSetMetaDeta.getColumnName(i));
			}
			
			if(resultset.next()) {
				for(int i=1;i<=columnCount;i++) {
					printwriter.println(resultset.getString(i));
				}
			}
			
			printwriter.println("<h1></center></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
