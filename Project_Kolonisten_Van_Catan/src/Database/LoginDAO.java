package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import DatabaseConnect.DatabaseConnect;

public class LoginDAO {
	Connection m_Conn;

	public LoginDAO(Connection db_conn) {
		this.m_Conn = db_conn;
	}

	/**
	 * 
	 * This is used by the model to control if the username exists in the database
	 */

	public boolean searchPasswordWithUserName(String username, char[] password) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT wachtwoord FROM account WHERE username = '" + username + "'");
			rs.next();
			String passwordQuerie = rs.getString("wachtwoord");
			char[] passwordToCompare = passwordQuerie.toCharArray();
			if (Arrays.equals(password, passwordToCompare)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean activeGame(String name) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT count(idspel) FROM speler WHERE username = '" + name
					+ "' and (speelstatus = 'uitdager' or speelstatus = 'geaccepteerd')");
			rs.next();

			if (rs.getInt("count(idspel)") == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
