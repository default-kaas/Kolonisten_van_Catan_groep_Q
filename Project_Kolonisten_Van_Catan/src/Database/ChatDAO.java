package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatDAO {
	Connection connection;

	public ChatDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean setChatMessage(String Message, int PlayerID) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO chatregel (tijdstip, idspeler, bericht)  VALUES (CURRENT_TIMESTAMP,"+PlayerID+", '"+ Message +"')");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}