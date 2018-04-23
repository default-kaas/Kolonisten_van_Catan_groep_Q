package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Game;

public class ChatDAO {
	Connection connection;

	public ChatDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean setChatMessage(String Message, int PlayerID) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO chatregel (tijdstip, idspeler, bericht)  VALUES (CURRENT_TIMESTAMP,"
					+ PlayerID + ", '" + Message + "')");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public void updateChat(Game game, ArrayList<String> chatArray) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs;
			chatArray.clear();
			rs = stmt.executeQuery("select username, kleur, bericht from chatregel join speler on speler.idspeler = chatregel.idspeler and idspel = "+ game.getGameID());
			while (rs.next()) {
				chatArray.add(rs.getString("username") + "("+ rs.getString("kleur") +") " +rs.getString("bericht"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}