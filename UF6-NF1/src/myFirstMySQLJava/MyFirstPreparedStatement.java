package myFirstMySQLJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MyFirstPreparedStatement {
	 private Connection connect = null;


	public void insertTable(String usuari, String email, String pagina, String resum, String comentari) throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/feedback?";
		String user = "sqluser";
		String pass = "sqluserpw";

		try {

			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO feedback.comments" + "(MYUSER, EMAIL, WEBPAGE,DATUM, SUMMARY, COMMENTS) VALUES"
					+ "(?,?,?,CURRENT_TIMESTAMP,?,?)";

			PreparedStatement prStatement = connect.prepareStatement(sql);
			prStatement.setString(1, usuari);
			prStatement.setString(2, email);
			prStatement.setString(3, pagina);
			prStatement.setString(4, resum);
			prStatement.setString(5, comentari);
			prStatement.execute();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			connect.close();
		}


	}
	
	  

}
