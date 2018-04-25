package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LobbyDAO {

	Connection m_Conn;

	public LobbyDAO(Connection db_conn) {

		try {
			m_Conn = db_conn;
		} catch (Exception e) {
			e.getMessage();

		}

	}

	public int makeGame(String username, boolean RandomBoard) {
		try {

			final String querySpelID = "select max(idspel+1) as id from spel";

			Statement spelIDstatement = m_Conn.createStatement();
			ResultSet rs = spelIDstatement.executeQuery(querySpelID);
			int newGameID = 0;
			if (rs.next()) {
				newGameID = rs.getInt("id");
			}

			final String querySpelerID = "select max(idspeler+1) as id from speler;";
			Statement spelerIDstatement = m_Conn.createStatement();
			ResultSet rs2 = spelerIDstatement.executeQuery(querySpelerID);
			int newSpelerID = 0;
			if (rs2.next()) {
				newSpelerID = rs2.getInt("id");
			}

			final String QUERY2 = "INSERT INTO spel (idspel, israndomboard, eersteronde) VALUES (" + newGameID + ", "
					+ RandomBoard + ", 1)";
			Statement statement2 = m_Conn.createStatement();
			statement2.executeUpdate(QUERY2);

			final String QUERY3 = "INSERT INTO speler (idspeler, idspel, username, kleur, speelstatus, shouldrefresh, volgnr) VALUES ("
					+ newSpelerID + ", " + newGameID + ", '" + username + "', \"rood\", \"uitdager\", 0, 1);";
			Statement statement3 = m_Conn.createStatement();
			statement3.executeUpdate(QUERY3);
			return newGameID;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return -1;
	}

	public Object[][] getInvitedGames(String username) {
		Object[][] data = null;
		try {

			Statement statement = m_Conn.createStatement();
			final String QUERY = "SELECT * FROM speler WHERE username = '" + username
					+ "' and speelstatus = 'uitgedaagde'";
			ResultSet rs = statement.executeQuery(QUERY);

			if (rs.next()) {
				rs.beforeFirst();
				ArrayList spel = new ArrayList<>();
				while (rs.next()) {
					spel.add(rs.getInt("idspel"));
				}
				int rowCount = getRowCount(rs);

				data = new Object[rowCount][2];

				// Starting from First Row for Iteration

				for (int i = 0; i < spel.size(); i++) {
					Statement statement2 = m_Conn.createStatement();
					final String QUERY2 = "SELECT * FROM speler WHERE idspel = " + spel.get(i)
							+ " and speelstatus = 'uitdager';";
					ResultSet rx = statement2.executeQuery(QUERY2);
					rx.next();
					data[i][0] = rx.getInt("idspel");
					data[i][1] = rx.getString("username");

				}

			} else {
				// Nep data xD
				data = new Object[1][2];
				data[0][0] = " Geen";
				data[0][1] = " game";
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return data;

	}

	public Object[][] getUserList(String username) {
		Object[][] data = null;
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "select * from speler where speelstatus = 'uitdager' and idspel in (SELECT idspel FROM speler WHERE username = '"+ username + "' and (speelstatus = 'geaccepteerd' or speelstatus = 'uitdager'))";
			ResultSet rs = statement.executeQuery(QUERY);
			
			int rowCount = getRowCount(rs); // Row Count
			
			rs.beforeFirst();

			data = new Object[rowCount][2];
			for (int i = 0; i < rowCount; i++) {
				rs.next();
				data[i][0] = rs.getInt("idspel");
				data[i][1] = rs.getString("username");
			}
		}

		catch (

		SQLException e) {
			data = new Object[1][2];
			data[0][0] = " Geen";
			data[0][1] = " game";
			System.out.println(e);
		}

		return data;

	}

	public boolean respondToInvite(String userName, int gameId, boolean Accept) {
		try {
			Statement stmt = m_Conn.createStatement();
			if (Accept) {
				stmt.executeUpdate("UPDATE speler SET speelstatus = 'geaccepteerd' WHERE idspel = " + gameId
						+ " and username = '" + userName + "'");
			} else {
				stmt.executeUpdate("UPDATE speler SET speelstatus = 'geweigerd' WHERE idspel = " + gameId
						+ " and username = '" + userName + "'");
			}

			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	private int getColumnCount(ResultSet rs) {

		try {

			if (rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	private int getRowCount(ResultSet rs) {

		try {

			if (rs != null) {

				rs.last();

				return rs.getRow();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
