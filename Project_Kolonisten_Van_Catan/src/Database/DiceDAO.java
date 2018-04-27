package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiceDAO {

	private Connection m_Conn;

	public DiceDAO(Connection db_conn) {
		m_Conn = db_conn;

	}

	public boolean hasTrownDice(int GameID) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT gedobbeld FROM spel where idspel = " + GameID);
			if (rs.next()) {
				if (rs.getInt("gedobbeld") == 1) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
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

	public int getOldValue1(int gameID) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT laatste_worp_steen1 FROM spel where idspel = " + gameID);
			if (rs.next()) {
				return rs.getInt("laatste_worp_steen1");
			}
			return -1;
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}

	public int getOldValue2(int gameID) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT laatste_worp_steen2 FROM spel where idspel = " + gameID);
			if (rs.next()) {
				return rs.getInt("laatste_worp_steen2");
			}
			return -1;
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}
}
