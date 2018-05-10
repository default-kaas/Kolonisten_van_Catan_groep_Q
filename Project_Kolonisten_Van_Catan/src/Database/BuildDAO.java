package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuildDAO {
	Connection db_conn;

	public BuildDAO(Connection db_conn) {
		this.db_conn = db_conn;
	}

	public int checkIfPlayerHasHouse(int gameId, int playerId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select count(spelerstuk.idspeler) AS aantal from spelerstuk join stuk ON spelerstuk.idstuk = stuk.idstuk join speler ON speler.idspeler = spelerstuk.idspeler where stuk.stuksoort = 'dorp' AND speler.idspel = "
							+ gameId + " AND spelerstuk.idspeler = " + playerId
							+ " AND spelerstuk.x_van IS NOT null  AND spelerstuk.y_van IS NOT null");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {

			return 0;
		}
	}
	
	public int checkIfCardsLeft(int gameId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select count(idontwikkelingskaart) AS aantal from spelerontwikkelingskaart where idspel = " +gameId+ " AND idspeler IS null ");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public int checkIfStreetLeft(int gameId, int playerId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select COUNT(spelerstuk.idstuk) AS aantal from spelerstuk join speler on spelerstuk.idspeler = speler.idspeler where speler.idspel = "+gameId+" AND speler.idspeler = "+playerId+" AND spelerstuk.x_van IS null AND spelerstuk.y_van IS null AND spelerstuk.x_naar IS null AND spelerstuk.y_naar IS null AND spelerstuk.idstuk LIKE 'r%'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	} 
	
	public int checkIfHouseLeft(int gameId, int playerId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select COUNT(spelerstuk.idstuk) AS aantal from spelerstuk join speler on spelerstuk.idspeler = speler.idspeler where speler.idspel = "+gameId+" AND speler.idspeler = "+playerId+" AND spelerstuk.x_van IS null AND spelerstuk.y_van IS null AND spelerstuk.idstuk LIKE 'd%'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public int checkIfCityLeft(int gameId, int playerId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select COUNT(spelerstuk.idstuk) AS aantal from spelerstuk join speler on spelerstuk.idspeler = speler.idspeler where speler.idspel = "+gameId+" AND speler.idspeler = "+playerId+" AND spelerstuk.x_van IS null AND spelerstuk.y_van IS null AND spelerstuk.idstuk LIKE 'c%'");
			rs.next();
			int amount = rs.getInt("aantal");
			return amount;
		} catch (SQLException e) {
			return 0;
		}
	}

	public void givePlayerRandomCard(int playerId) {
		try {
			Statement stmt = db_conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idontwikkelingskaart from spelerontwikkelingskaart where idspeler IS null ORDER BY rand() limit 1;");
			rs.next();
			stmt.executeUpdate("update spelerontwikkelingskaart set idspeler = "+playerId+" where idontwikkelingskaart = '"+rs.getString("idontwikkelingskaart")+"';");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
