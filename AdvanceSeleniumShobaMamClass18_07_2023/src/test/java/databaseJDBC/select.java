package databaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class select {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver drivref=new Driver();
		DriverManager.registerDriver(drivref);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QSpiders_info","root","root");
		Statement stat=conn.createStatement();
		String query = "select * from student_information ";
		ResultSet reult = stat.executeQuery(query);
		while(reult.next())
		{
			System.out.println(reult.getString(1)+ "\t" +reult.getString(2)+ "\t" +reult.getString(3)+ "\t" +reult.getString(4)+ "\t" );
		}
		
	}

}
