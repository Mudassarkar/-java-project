package EmailDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class EmailDBConnection {
	 static Connection con=null;
	 public static Connection getConnection()
	 
	 {
	
	
	try {
		System.out.println("=====================Before Connection=================");
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emaildb?useTimezone=true&serverTimezone=UTC","root","");
	System.out.println("======================connection successful===================");
	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
return con;
	
	

	 }
}
