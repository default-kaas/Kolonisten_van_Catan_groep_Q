package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.TradeController;
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

	public int getPlayerKnightCards(int gameId, int playerId) { // Returns the amount of Knight Cards a player has in
																// possession

		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select count(ontwikkelingskaart.naam) AS aantal from spelerontwikkelingskaart join "
					+ "ontwikkelingskaart on spelerontwikkelingskaart.idontwikkelingskaart = ontwikkelingskaart.idontwikkelingskaart "
					+ "join speler on spelerontwikkelingskaart.idspeler = speler.idspeler "
					+ "where spelerontwikkelingskaart.idspel = " + gameId + " AND speler.idspeler = " + playerId + " "
					+ "AND ontwikkelingskaart.naam = 'ridder' AND spelerontwikkelingskaart.gespeeld = 0");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}

	}

	public int getPlayerInventionCards(int gameId, int playerId) { // returns the amount of Invention Cards a player has
																	// in possession
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(ontwikkelingskaart.naam) AS aantal from spelerontwikkelingskaart join ontwikkelingskaart on"
							+ " spelerontwikkelingskaart.idontwikkelingskaart = ontwikkelingskaart.idontwikkelingskaart join speler on spelerontwikkelingskaart.idspeler = speler.idspeler	"
							+ "where spelerontwikkelingskaart.idspel = " + gameId + " AND speler.idspeler = " + playerId
							+ " AND ontwikkelingskaart.naam = 'uitvinding'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int getPlayerMonopolyCards(int gameId, int playerId) { // returns the amount of Monopoly Cards a player has
																	// in possession
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(ontwikkelingskaart.naam) AS aantal from spelerontwikkelingskaart join ontwikkelingskaart on"
							+ " spelerontwikkelingskaart.idontwikkelingskaart = ontwikkelingskaart.idontwikkelingskaart join speler on spelerontwikkelingskaart.idspeler = speler.idspeler	"
							+ "where spelerontwikkelingskaart.idspel = " + gameId + " AND speler.idspeler = " + playerId
							+ " AND ontwikkelingskaart.naam = 'monopolie'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int getPlayerToolsCards(int gameId, int playerId) { // returns the amount of Tools Cards a player has in
																// possession
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(ontwikkelingskaart.naam) AS aantal from spelerontwikkelingskaart join ontwikkelingskaart on"
							+ " spelerontwikkelingskaart.idontwikkelingskaart = ontwikkelingskaart.idontwikkelingskaart join speler on spelerontwikkelingskaart.idspeler = speler.idspeler	"
							+ "where spelerontwikkelingskaart.idspel = " + gameId + " AND speler.idspeler = " + playerId
							+ " AND ontwikkelingskaart.naam = 'stratenbouw'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int getPlayerVictoryPointCards(int gameId, int playerId) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(ontwikkelingskaart.naam) AS aantal from spelerontwikkelingskaart join ontwikkelingskaart on"
							+ " spelerontwikkelingskaart.idontwikkelingskaart = ontwikkelingskaart.idontwikkelingskaart join speler on spelerontwikkelingskaart.idspeler = speler.idspeler	"
							+ "where spelerontwikkelingskaart.idspel = " + gameId + " AND speler.idspeler = " + playerId
							+ " AND (ontwikkelingskaart.naam = 'universiteit' OR ontwikkelingskaart.naam = 'parlement' OR ontwikkelingskaart.naam = 'kathedraal' OR ontwikkelingskaart.naam  = 'bibliotheek' OR ontwikkelingskaart.naam = 'markt')");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public int getPlayerKnightPlayed(int gameId, int playerId) { //Query returns the amount of Knights a player has activated/played. 
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(gespeeld) as aantal from spelerontwikkelingskaart where idontwikkelingskaart LIKE '%r' AND spelerontwikkelingskaart.idspel = "+gameId+" AND idspeler = "+playerId+"  AND gespeeld = 1");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
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
	

	public void addResources(int gameid, int playerid, String card, int amount) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE spelergrondstofkaart SET idspeler = " + playerid
					+ " WHERE idspeler IS NULL AND idgrondstofkaart LIKE '" + card + "%' AND idspel = " + gameid
					+ " LIMIT " + amount;
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void removeResources(int gameid, int playerid, String card, int amount) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE spelergrondstofkaart SET idspeler = null WHERE idspeler = " + playerid
					+ " AND idgrondstofkaart LIKE '" + card + "%' AND idspel = " + gameid + " LIMIT " + amount;
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {
			System.out.println(e);
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

	public boolean checkBank(int gameID, String card) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"SELECT idspeler FROM spelergrondstofkaart WHERE idspeler IS NULL AND idgrondstofkaart LIKE '"
							+ card + "%' AND idspel = " + gameID + " LIMIT 1");
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public boolean shouldRefresh(int gameID, int playerID) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select shouldrefresh from speler where idspel = " + gameID + " and idspeler = " + playerID);
			rs.next();
			if (rs.getInt("shouldrefresh") == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public void setRefresh(int idspeler) {

		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "UPDATE speler SET shouldrefresh = 0 WHERE idspeler = " + idspeler;
			statement.executeUpdate(QUERY);
		} catch (SQLException e) {

		}

	}

	public String checkHaven(int player, String resource) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT x,y,idgrondstofsoort FROM locatie WHERE haven = 1 AND idgrondstofsoort = '"+ resource +"' AND EXISTS (SELECT x,y FROM spelerstuk where locatie.x = spelerstuk.x_van AND  locatie.y = spelerstuk.y_van AND idspeler="+player+")");
			Statement stmt2 = m_Conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT x,y,idgrondstofsoort FROM locatie WHERE haven = 1 AND idgrondstofsoort IS NULL AND EXISTS (SELECT x,y FROM spelerstuk where locatie.x = spelerstuk.x_van AND  locatie.y = spelerstuk.y_van AND idspeler="+player+")");
			if (rs.next()) {
				String grondstof = rs.getString("idgrondstofsoort");
				return grondstof;
			} else if (rs2.next()) {
				return null;
			} else {
				return "false";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "false";
		}
	}

}