package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	Connection m_Conn;

	public LoginDAO(Connection db_conn) {
		this.m_Conn = db_conn;
	}

	/**
	 * 
	 * This is used by the model to control if the username exists in the database
	 */

	public boolean searchPasswordWithUserName(String username,String password) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT wachtwoord FROM account WHERE username = '" + username + "'");
			rs.next();
			if (rs.getString("wachtwoord").equals(password)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
}
