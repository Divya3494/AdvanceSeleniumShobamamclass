package databaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
public class Insertdata {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver drivref=new Driver();
		DriverManager.registerDriver(drivref);
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/QSpiders_info","root","root");
		Statement stat=con.createStatement();
	   String query = "insert into student_information values(4,'add','adar','aadadada')";
	   
	   int result = stat.executeUpdate(query);
	   
	   if(result==1)
	   {
		   System.out.println("sucess");
	   }
	   else
		   System.out.println("insert failed");
	
	
	}

}
