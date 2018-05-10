package Database;

import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Corner;

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

	public boolean giveResourceToPlayers(int gameID, int playerID, char resourceType, int amount) {

		try {
			for (int i = 0; i < amount; i++) {
				Statement stmt = m_Conn.createStatement();
				stmt.executeUpdate("UPDATE spelergrondstofkaart SET idspeler = + " + playerID
						+ " WHERE idspeler is null and idspel = " + gameID + " and idgrondstofkaart LIKE '"
						+ resourceType + "%' ");
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Integer> getPlayerCities(int gameID) {
		try {
			ArrayList<Integer> playerCity = new ArrayList<Integer>();
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van,speler.idspeler from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'c%' ");
			while (rs.next()) {

				int playerID = (rs.getInt("speler.idspeler"));
				playerCity.add(playerID);
			}
			return playerCity;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	public ArrayList<Integer> getPlayerTowns(int gameID) {
		try {
			ArrayList<Integer> playerTown = new ArrayList<Integer>();
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van,speler.idspeler from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'd%' ");
			while (rs.next()) {

				int playerID = (rs.getInt("speler.idspeler"));
				playerTown.add(playerID);
			}
			return playerTown;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

}
