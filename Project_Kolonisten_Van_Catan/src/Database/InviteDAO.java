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

	// select max(idspeler+1) from speler;

	public Object[][] getUserList(String username, int idspel) {

		Object[][] data = null;

		try {

			Statement statement = m_Conn.createStatement();
			final String QUERY = "SELECT * FROM speler WHERE not speelstatus = 'uitdager' and idspel = "+idspel;
			ResultSet rs = statement.executeQuery(QUERY);

			if (rs.next()) {

				int rowCount = getRowCount(rs); // Row Count
				int columnCount = getColumnCount(rs); // Column Countt

				data = new Object[rowCount][columnCount];

				// Starting from First Row for Iteration
				rs.beforeFirst();

				int i = 0;

				while (rs.next()) {

					int j = 0;

					data[i][j++] = rs.getInt("username");

					data[i][j++] = rs.getString("speelstatus");

					i++;
				}

				status = true;

				// statement.close();

			} else {
				// Nep data xD
				data = new Object[1][2];
				data[0][0] = " Niemand";
				data[0][1] = " uitgenodigd!";
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return data;

	}
	
	public void invitePlayer(String username, int idspel) {
		
	}

	public Object[] getInviteUserList(String username) {

		Object[] data = null;
		try {
			final String QUERY = "select * from account where username != '" + username + "'";
			Statement statement = m_Conn.createStatement();
			ResultSet rs = statement.executeQuery(QUERY);
			int getRowCount = getRowCount(rs); // Column Count
			System.out.println(getRowCount);

			data = new Object[getRowCount];

			// Starting from First Row for Iteration
			 rs.beforeFirst();

			int i = 0;

			while (rs.next()) {

				data[i] = rs.getString("username");
				System.out.println(data[i]);
				i++;
			}
			// statement.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return data;

	}

	public void invitePlayers(int playerID) {
		try {

			final String QUERY = "UPDATE speler SET speelstatus = 'uitgedaagde' WHERE idspeler = " + playerID;
			Statement statement = m_Conn.createStatement();
			statement.executeUpdate(QUERY);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	private int getColumnCount(ResultSet rs) {
		try {
			if (rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				// System.out.println(columnsNumber);
				return columnsNumber;
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
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

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

}
