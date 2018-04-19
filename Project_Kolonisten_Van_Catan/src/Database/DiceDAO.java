package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class DiceDAO {
	
	Connection m_Conn;
	
	public DiceDAO() {
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}
	
	
	public boolean setDiceValues(int value1,int value2, int GameID) {
		try {
			Statement stmt = m_Conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET gedobbeld = 1, laatste_worp_steen1 = "+value1+", laatste_worp_steen2 = "+value2+" WHERE idspel = "+ GameID);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
