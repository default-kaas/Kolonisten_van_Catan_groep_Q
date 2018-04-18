package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class PlayerDAO {
	Connection m_Conn;

	public PlayerDAO() {
		System.out.println("PlayerDAO is made!");
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}

	public String getName() throws SQLException {
		Statement stmt = m_Conn.createStatement();
		ResultSet rs = stmt.executeQuery("select username from account");
		rs.next();
		String name = rs.getString("username");
		return name;
	}
}