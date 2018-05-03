package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.ResourceCards;

public class PlayerDAO {
	Connection m_Conn;

	public PlayerDAO(Connection db_conn) {
		m_Conn = db_conn;
	}

	public String getName(int volgnr, int GameID) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select username from speler where idspel=" + GameID + " and volgnr = " + (volgnr + 1));
			rs.next();
			String name = rs.getString("username");
			return name;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public int getPlayerID(int i, int gameId) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select idspeler from speler where idspel=" + gameId + " and volgnr = " + (i + 1));
			rs.next();
			int PlayerID = rs.getInt("idspeler");
			return PlayerID;
		} catch (SQLException e) {
			return 0;
		}
	}

	public String getLargestArmyID(int gameId) {

		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select username from spel join speler on spel.grootste_rm_idspeler = speler.idspeler  where spel.idspel = " + gameId);
			rs.next();
			String LargestArmy = rs.getString("username");
			return LargestArmy;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	public String getLongestRoadID(int gameId) {

		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select username from spel join speler on spel.grootste_hr_idspeler = speler.idspeler  where spel.idspel = " + gameId);
			rs.next();
			String LargestRoute = rs.getString("username");
			return LargestRoute;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	public void setPlayerResources(ResourceCards Card,int gameId, String idPlayer) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE spelergrondstofkaart SET idspeler = "+idPlayer+" WHERE idspel = " + gameId + " and idgrondstofkaart = 'b01'";
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {
		}
	}

}