package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import DatabaseConnect.DatabaseConnect;

public class LoginDAO {
	Connection m_Conn;
	
	public LoginDAO() {
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}
	/**
	 * 
	 * This is used by the model to control if the username exists in the database
	 */
	public boolean searchUserName(String username) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account WHERE '" + username + "' ");
			if(rs.getString(0) == username) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean searchPasswordWithUserName(String username, char[] password) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT wachtwoord FROM account WHERE '" + username + "' ");
			rs.next();
			String passwordQuerie = rs.getString("wachtwoord");
			char[] passwordToCompare = passwordQuerie.toCharArray();
			if(Arrays.equals(password, passwordToCompare)) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
}
