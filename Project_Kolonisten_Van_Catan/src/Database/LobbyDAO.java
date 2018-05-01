package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class LobbyDAO {

	private Connection m_Conn;
	Random random = new Random();

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
			Statement statement = m_Conn.createStatement();
			statement.executeUpdate(QUERY2);

			final String QUERY3 = "INSERT INTO speler (idspeler, idspel, username, kleur, speelstatus, shouldrefresh, volgnr) VALUES ("
					+ newSpelerID + ", " + newGameID + ", '" + username + "', \"rood\", \"uitdager\", 0, 1);";

			statement.executeUpdate(QUERY3);

			final String QUERY4 = "INSERT INTO spelergrondstofkaart (idspel, idgrondstofkaart) SELECT idspel, idgrondstofkaart FROM grondstofkaart join spel where idspel = "
					+ newGameID + ";";
			statement.executeUpdate(QUERY4);

			int B = 0;
			int E = 0;
			int G = 0;
			int H = 0;
			int W = 0;

			if (RandomBoard) {
				System.out.println("RandomBoard");
			} else {
				for (int i = 0; i < 19; i++) {
					int randomInt = random.nextInt(5);
					char ResourceType = 0;
					Boolean nextResource = false;
					if (i == 9) {
						final String QUERY5 = "INSERT INTO tegel (idspel, idtegel, x , y , idgrondstofsoort, idgetalfiche) VALUES ("
								+ newGameID + ", " + (i + 1) + ",6,6,'X', null);";
						statement.executeUpdate(QUERY5);
					} else {
						while (!nextResource) {
							if (randomInt == 0 && B < 3) {
								B++;
								ResourceType = 'B';
								nextResource = true;
							} else if (randomInt == 1 && E < 3) {
								E++;
								ResourceType = 'E';
								nextResource = true;
							} else if (randomInt == 2 && G < 4) {
								G++;
								ResourceType = 'G';
								nextResource = true;
							} else if (randomInt == 3 && H < 4) {
								H++;
								ResourceType = 'H';
								nextResource = true;
							} else if (randomInt == 4 && W < 4) {
								W++;
								ResourceType = 'W';
								nextResource = true;
							} else {
								randomInt = random.nextInt(4);
							}
						}
						int[] Position = new int[2];
						int numberChips = -1;
						switch (i) {
						case 0:
							Position[0] = 2;
							Position[1] = 4;
							numberChips = 10;
							break;
						case 1:
							Position[0] = 3;
							Position[1] = 6;
							numberChips = 2;
							break;
						case 2:
							Position[0] = 4;
							Position[1] = 8;
							numberChips = 8;
							break;
						case 3:
							Position[0] = 3;
							Position[1] = 3;
							numberChips = 14;
							break;
						case 4:
							Position[0] = 4;
							Position[1] = 5;
							numberChips = 6;
							break;
						case 5:
							Position[0] = 5;
							Position[1] = 7;
							numberChips = 4;
							break;
						case 6:
							Position[0] = 6;
							Position[1] = 9;
							numberChips = 1;
							break;
						case 7:
							Position[0] = 4;
							Position[1] = 2;
							numberChips = 12;
							break;
						case 8:
							Position[0] = 5;
							Position[1] = 4;
							numberChips = 9;
							break;
						case 10:
							Position[0] = 7;
							Position[1] = 8;
							numberChips = 13;
							break;
						case 11:
							Position[0] = 8;
							Position[1] = 10;
							numberChips = 7;
							break;
						case 12:
							Position[0] = 6;
							Position[1] = 3;
							numberChips = 18;
							break;
						case 13:
							Position[0] = 7;
							Position[1] = 5;
							numberChips = 3;
							break;
						case 14:
							Position[0] = 8;
							Position[1] = 7;
							numberChips = 16;
							break;
						case 15:
							Position[0] = 9;
							Position[1] = 9;
							numberChips = 15;
							break;
						case 16:
							Position[0] = 8;
							Position[1] = 4;
							numberChips = 17;
							break;
						case 17:
							Position[0] = 9;
							Position[1] = 6;
							numberChips = 5;
							break;
						case 18:
							Position[0] = 10;
							Position[1] = 8;
							numberChips = 11;
							break;
						}

						final String QUERY5 = "INSERT INTO tegel (idspel, idtegel, x , y , idgrondstofsoort, idgetalfiche) VALUES ("
								+ newGameID + ", " + (i + 1) + ", " + Position[0] + "," + Position[1] + ",'"
								+ ResourceType + "'," + numberChips + ");";
						statement.executeUpdate(QUERY5);
					}
				}
			}

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
				ArrayList<Object> spel = new ArrayList<>();
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
			final String QUERY = "select count(speelstatus) as count, idspel, username from speler where (speelstatus = 'geaccepteerd' or speelstatus = 'uitdager') and idspel in (select idspel from speler where username = '"
					+ username
					+ "' and (speelstatus = 'geaccepteerd' or speelstatus = 'uitdager')) group by idspel having count = 4;";
			ResultSet rs = statement.executeQuery(QUERY);

			int rowCount = getRowCount(rs); // Row Count
			if (rowCount > 0) {

				rs.beforeFirst();

				data = new Object[rowCount][2];
				for (int i = 0; i < rowCount; i++) {
					rs.next();
					data[i][0] = rs.getInt("idspel");
					data[i][1] = rs.getString("username");

				}
			} else {
				data = new Object[1][2];
				data[0][0] = " Geen";
				data[0][1] = " game";
			}
		}

		catch (SQLException e) {

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
