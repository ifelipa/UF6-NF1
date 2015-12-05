package myFirstMySQLJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
			statement = connect.createStatement();

			resultSet = statement.executeQuery("select * from feedback.comments");
			writeResultSet(resultSet);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeResultSet(ResultSet resultSet2) throws SQLException {
		while (resultSet.next()) {
		
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
			System.out.println("*************************");
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

}
