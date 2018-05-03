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

	public int playerPoints(int gameId, int playerId) {
		try {

			Statement stmt = m_Conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery(
					"select count(stuksoort) AS amountHouse	 from stuk join spelerstuk on spelerstuk.idstuk = stuk.idstuk join speler on speler.idspeler = spelerstuk.idspeler where speler.idspel = "
							+ gameId + " AND   spelerstuk.idspeler = " + playerId
							+ " AND stuk.stuksoort = 'dorp' AND spelerstuk.x_van IS NOT null AND spelerstuk.y_van IS NOT null");
			rs.next();
			int amountHouse = rs.getInt("amountHouse");

			ResultSet bs;
			bs = stmt.executeQuery(
					"select count(stuksoort) AS amountCity from stuk join spelerstuk on spelerstuk.idstuk = stuk.idstuk join speler on speler.idspeler = spelerstuk.idspeler where speler.idspel = "
							+ gameId + " AND   spelerstuk.idspeler = " + playerId
							+ " AND stuk.stuksoort = 'stad' AND spelerstuk.x_van IS NOT null AND spelerstuk.y_van IS NOT null ");
			bs.next();
			int amountStad = bs.getInt("amountCity");

			int amount = amountHouse + (amountStad * 2);

			return amount;
		} catch (SQLException e) {
			System.out.println(e);
			return 0;

		}
	}

	public String getLargestArmyID(int gameId) {

		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select username from spel join speler on spel.grootste_rm_idspeler = speler.idspeler  where spel.idspel = "
							+ gameId);
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
			rs = stmt.executeQuery(
					"select username from spel join speler on spel.langste_hr_idspeler = speler.idspeler  where spel.idspel = "
							+ gameId);
			rs.next();
			String LargestRoute = rs.getString("username");
			return LargestRoute;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public void setPlayerResources(int gameId, int idPlayer, String resourceID) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE spelergrondstofkaart SET idspeler = null WHERE idspel = " + gameId
					+ " and idgrondstofkaart = '" + resourceID + "'";
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {
		}
	}

}