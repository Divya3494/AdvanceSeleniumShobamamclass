package databaseJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
public class DatabaseJdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverrefrence=new Driver();
		DriverManager.registerDriver(driverrefrence);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/QSpiders_info","root","root");
		Statement statment = connection.createStatement();
		String query= "Select * from student_information";
		
		 ResultSet reult = statment.executeQuery(query);
		 
		 while(reult.next())
		 {
			 System.out.println(reult.getString(1)+ "\t" +reult.getString(2)+ "\t" +reult.getString(3)+ "\t" +reult.getString(4)+ "\t" );
		 }
		 connection.close();
	}

}
