package myFirstMySQLJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement= null;
	private ResultSet result = null;
	
	public void readDataBase() {
		String driver ="com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		//	connect = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
