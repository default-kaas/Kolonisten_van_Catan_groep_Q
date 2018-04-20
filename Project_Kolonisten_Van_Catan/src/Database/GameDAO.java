package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class GameDAO {
	private Connection m_Conn;

	public GameDAO(Connection db_conn) {
		m_Conn = db_conn;

	}

	public int getPlayersRound(int gameId) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("select beurt_idspeler from spel where idspel=" + gameId);
			rs.next();
			int beurt = rs.getInt("beurt_idspeler");
			return beurt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}

}
