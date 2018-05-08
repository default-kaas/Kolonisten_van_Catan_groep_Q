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
			rs = stmt.executeQuery("select count(spelerstuk.idspeler) AS aantal from spelerstuk join stuk ON spelerstuk.idstuk = stuk.idstuk join speler ON speler.idspeler = spelerstuk.idspeler where stuk.stuksoort = 'dorp' AND speler.idspel = "+gameId+ 
					" AND spelerstuk.idspeler = "+playerId+" AND spelerstuk.x_van IS NOT null  AND spelerstuk.y_van IS NOT null");
			rs.next();
			int amount = rs.getInt("aantal");
			System.out.println(amount);
			return amount;
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		}
	}
}
