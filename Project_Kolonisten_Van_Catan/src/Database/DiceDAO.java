package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DiceDAO {

	Connection m_Conn;

	public DiceDAO(Connection db_conn) {
		m_Conn = db_conn;

	}

	public boolean setDiceValues(int value1, int value2, int GameID) {
		try {
			Statement stmt = m_Conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET gedobbeld = 1, laatste_worp_steen1 = " + value1
					+ ", laatste_worp_steen2 = " + value2 + " WHERE idspel = " + GameID);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
