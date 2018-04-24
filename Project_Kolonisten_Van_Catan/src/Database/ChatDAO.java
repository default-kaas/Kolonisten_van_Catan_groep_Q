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

	public boolean updateChat(Game game, ArrayList<String> chatArray) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs;
			ArrayList<String> chatArrayNew = new ArrayList<String>();
		
			
			rs = stmt.executeQuery("select username, kleur, bericht from chatregel join speler on speler.idspeler = chatregel.idspeler where idspel = "+ game.getGameID()+" ORDER BY tijdstip asc");
			while (rs.next()) {
				chatArrayNew.add(rs.getString("username") + "("+ rs.getString("kleur") +") " +rs.getString("bericht"));
			}
			if(chatArray.size() < chatArrayNew.size()) {
				chatArray.clear();
				for(String x : chatArrayNew) {
					chatArray.add(x);
				}
				return true;
			}
			else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("error");
			System.out.println(e);
			return false;
		}
	}

}