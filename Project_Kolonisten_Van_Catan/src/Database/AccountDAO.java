package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	Connection m_Conn;

	public AccountDAO(Connection db_conn) {
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
			if(rs.next()) {
			
			if (rs.getString("wachtwoord").equals(password)) {
				return true;
			} else {
				return false;
			}}else {
				System.out.println("No pass");
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean createAccountDOA(String username, String password) {
		try {
            Statement stmt = m_Conn.createStatement();
            stmt.executeUpdate("INSERT INTO account (username, wachtwoord)  VALUES ('"+username+"', '"+password+"')");
            return true;
        } catch (SQLException e) {
        	System.out.println(e);
            return false;
        }
	}
}
