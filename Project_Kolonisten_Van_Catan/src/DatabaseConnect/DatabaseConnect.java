package DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	Connection m_Conn;

	public DatabaseConnect() {
		if ((loadDataBaseDriver("com.mysql.jdbc.Driver")) && (makeConnection())) {
			System.out.println("Database is connected");
			
		} else {
			System.out.println("Database can't connected");
		}
	}

	public boolean loadDataBaseDriver(String driverName) {

		try {
			Class.forName(driverName);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public Connection getConnection() {
		return m_Conn;
	}

}
