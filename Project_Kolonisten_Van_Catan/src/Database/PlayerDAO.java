package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Game;
import Model.Player;

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

	public ArrayList<Integer> getPlayerCards(int gameId, int idPlayer) {
		ArrayList<Integer> getplayerCards = new ArrayList<Integer>();
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select ontwikkelingskaart.naam, count(idspeler) "
					+ "AS amount from ontwikkelingskaart left join spelerontwikkelingskaart ON "
					+ "ontwikkelingskaart.idontwikkelingskaart = spelerontwikkelingskaart.idontwikkelingskaart join spel"
					+ " ON spel.idspel = spelerontwikkelingskaart.idspel group by ontwikkelingskaart.naam "
					+ "	order by  ontwikkelingskaart.naam");
			while (rs.next()) {
				int m = rs.getInt("amount");
				getplayerCards.add(m);
			}
		} catch (SQLException e) {

		}

		return getplayerCards;
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

	public void addResources(int gameid, Player playerid, String card, int amount) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE spelergrondstofkaart SET idspeler = " + playerid
					+ " WHERE idspeler IS NULL AND idgrondstofkaart LIKE '" + card + "%' AND idspel IS " + gameid
					+ " LIMIT " + amount;
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {
		}
	}

	public void endTurn(int gameid, int playerid) {
		try {
			Statement statement = m_Conn.createStatement();
			String QUERY = "UPDATE spel SET gedobbeld = 0, laatste_worp_steen1 = null, laatste_worp_steen2 = null, beurt_idspeler = "
					+ playerid + " where idspel = " + gameid + ";";
			statement.executeUpdate(QUERY);
			
			String QUERY2 = "UPDATE speler SET shouldrefresh = 1 where idspeler = " + playerid + ";";
			statement.executeUpdate(QUERY2);
		} catch (SQLException e) {
		}
	}

	boolean yes = false;

	public boolean getyes() {
		return yes;
	}

	public boolean checkBank(int gameID, String card) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"SELECT idspeler FROM spelergrondstofkaart WHERE idspeler IS NULL AND idgrondstofkaart LIKE '"
							+ card + "%' AND idspel IS " + gameID + " LIMIT 1");
			rs.next();
			yes = true;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			yes = false;
			return false;
		}
	}

}