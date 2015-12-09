package myFirstMySQLJava;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		
		String usuari = "jordi";
		String email = "jordi.com";
		String pagina = "www.ismael.com";
		String resum = "Summary";
		String comentari = " My second comment";
		MyFirstPreparedStatement in = new MyFirstPreparedStatement();
		try {
			in.insertTable(usuari, email, pagina, resum, comentari);
			dao.readDataBase();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
