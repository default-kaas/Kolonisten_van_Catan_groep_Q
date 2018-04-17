package DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	Connection m_Conn;

	public DatabaseConnect() throws SQLException {
		m_Conn = null;
		if ((loadDataBaseDriver("com.mysql.jdbc.Driver")) && (makeConnection())) {
			doSomeQuerying();

			// TODO Auto-generated catch block

		}
	}

	public boolean loadDataBaseDriver(String driverName) {

		try {
			Class.forName(driverName);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);

			return false;
		}
	}

	public boolean makeConnection() {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://databases.aii.avans.nl:3306/rswester_db2";
		String user = "rswester";
		String pwd = "Ab12345";
		try {
			m_Conn = DriverManager.getConnection(url, user, pwd);

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	public void doSomeQuerying() throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = m_Conn.createStatement();
		ResultSet rs = stmt.executeQuery("select gebruikersnaam from gebruiker");

		while (rs.next()) {
			System.out.println(rs.getString("gebruikersnaam"));

		}
	}

}
