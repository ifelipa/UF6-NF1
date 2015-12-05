package myFirstMySQLJava;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		try {
			dao.readDataBase();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String usuari = "Ismael5";
		String email = "ismael@ismael.com";
		String pagina = "www.ismael.com";
		String resum = "Summary";
		String comentari = " My second comment";
		MyFirstPreparedStatement in = new MyFirstPreparedStatement();
		try {
			in.insertTable(usuari, email, pagina, resum, comentari);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
