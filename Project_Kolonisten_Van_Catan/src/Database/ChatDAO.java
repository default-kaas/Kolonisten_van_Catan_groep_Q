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
			rs = stmt.executeQuery("select * from chatregel where idspeler !=" + game.getMe().getPlayerID());
			while (rs.next()) {
				System.out.println(rs.getString("bericht"));
				chatArray.add(rs.getString("bericht"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}