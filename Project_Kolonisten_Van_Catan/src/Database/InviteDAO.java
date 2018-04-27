package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.InviteController;

public class InviteDAO {
	private boolean status;

	Connection m_Conn;
	InviteController inviteController;

	public InviteDAO(Connection db_conn) {
		try {
			m_Conn = db_conn;
		} catch (Exception e) {
		}
	}

	public int getAcceptedPlayerAmount(int idspel) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "select count(idspeler) as count from speler where idspel = " + idspel
					+ " and speelstatus = 'geaccepteerd'";
			ResultSet rs = statement.executeQuery(QUERY);
			rs.next();
			return rs.getInt("count");
		} catch (SQLException e) {
		}
		return -1;
	}

	public int getRejectedVolgnr(int idspel) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "select volgnr from speler where idspel = " + idspel
					+ " and speelstatus = 'geweigerd' and not volgnr in (select volgnr from speler where idspel = "
					+ idspel + " and speelstatus = 'uitgedaagde' and speelstatus = 'geaccepteerd')";
			ResultSet rs = statement.executeQuery(QUERY);
			rs.next();
			return rs.getInt("volgnr");
		} catch (SQLException e) {
		}
		return -1;
	}

	public Object[][] getUserList(String username, int idspel) {
		Object[][] data = null;
		try {

			Statement statement = m_Conn.createStatement();
			final String QUERY = "SELECT * FROM speler WHERE not speelstatus = 'uitdager' and idspel = " + idspel;
			ResultSet rs = statement.executeQuery(QUERY);

			if (rs.next()) {
				int rowCount = getRowCount(rs); // Row Count
				int columnCount = getColumnCount(rs); // Column Countt

				data = new Object[rowCount][columnCount];
				rs.beforeFirst();
				int i = 0;
				while (rs.next()) {
					data[i][0] = rs.getString("username");
					data[i][1] = rs.getString("speelstatus");
					i++;
				}
				status = true;

			} else {
				// Nep data xD
				data = new Object[1][2];
				data[0][0] = " Niemand";
				data[0][1] = " uitgenodigd!";
			}
		} catch (Exception e) {
		}
		return data;

	}

	public Object[][] getInviteUserList(String username) {
		Object[][] data = null;
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "select * from account where username != '" + username + "'";
			ResultSet rs = statement.executeQuery(QUERY);
			
			int getRowCount = getRowCount(rs); // Row Count
			data = new Object[getRowCount][2];

			rs.beforeFirst();

			for (int i = 0; i < getRowCount; i++) {
				rs.next();
				data[i][0] = rs.getString("username");
				data[i][1] = " - ";
			}
		} catch (SQLException e) {
		}

		return data;

	}

	public int invitePlayers(String userName, int gameID, int newVolgNr) {
		try {
			final String querySpelerID = "select max(idspeler+1) as id from speler;";
			Statement spelerIDstatement = m_Conn.createStatement();
			ResultSet rs2 = spelerIDstatement.executeQuery(querySpelerID);
			int newSpelerID = 0;
			if (rs2.next()) {
				newSpelerID = rs2.getInt("id");
			}
			String newColor = "";
			switch (newVolgNr) {
			case 2:
				newColor = "wit";
				break;
			case 3:
				newColor = "blauw";
				break;
			case 4:
				newColor = "oranje";
				break;
			}
			final String InvitePlayer = "INSERT INTO speler (idspeler, idspel, username, kleur, speelstatus, shouldrefresh, volgnr) VALUES ("
					+ newSpelerID + "," + gameID + ", '" + userName + "', '" + newColor + "', 'uitgedaagde', 0, "
					+ newVolgNr + ")";
			Statement statement = m_Conn.createStatement();
			statement.executeUpdate(InvitePlayer);
			return newVolgNr;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return -1;
	}

	public int getNumberInvited(int idspel) {
		try {
			Statement statement = m_Conn.createStatement();
			final String QUERY = "select count(idspeler) as count from speler where idspel = " + idspel
					+ " and (speelstatus = 'geaccepteerd'  or speelstatus = 'uitgedaagde')";
			ResultSet rs = statement.executeQuery(QUERY);
			rs.next();
			return rs.getInt("count");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return -1;
	}

	private int getColumnCount(ResultSet rs) {
		try {
			if (rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				return columnsNumber;
			}
		} catch (SQLException e) {
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
		}

		return 0;
	}

}
