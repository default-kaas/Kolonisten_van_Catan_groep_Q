package Database;

import java.sql.Connection;
import java.sql.ResultSet;
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

	public Object[][] getUserList(String username) {

		Object[][] data = null;

		try {

			Statement statement = m_Conn.createStatement();
			final String QUERY = "SELECT idspel FROM speler WHERE username = '" + username
					+ "' and (speelstatus = 'geaccepteerd' or speelstatus = 'uitdager')";
			ResultSet rs = statement.executeQuery(QUERY);

			if (rs.next()) {
				int spel = rs.getInt("idspel");
				final String QUERY2 = "select * from speler where idspel = " + spel + " and speelstatus = 'uitdager'";
				ResultSet rx = statement.executeQuery(QUERY2);
				int rowCount = getRowCount(rx); // Row Count
				int columnCount = getColumnCount(rx); // Column Countt

				data = new Object[rowCount][columnCount];

				// Starting from First Row for Iteration
				rs.beforeFirst();

				int i = 0;

				while (rs.next()) {

					int j = 0;

					data[i][j++] = rx.getInt("idspel");

					data[i][j++] = rx.getString("username");

					i++;
				}

				status = true;

				statement.close();

			} else {
				// Nep data xD
				data = new Object[1][2];
				data[0][0] = " Geen";
				data[0][1] = " game";
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return data;

	}

	public Object[][] getInviteUserList() {

		Object[][] data = null;

		try {

			final String QUERY = "select * from speler where not speelstatus = 'uitdager'";
			Statement statement = m_Conn.createStatement();
			ResultSet rs = statement.executeQuery(QUERY);

				
				int rowCount = getRowCount(rs); // Row Count
				int columnCount = getColumnCount(rs); // Column Count

				data = new Object[rowCount][columnCount];

				// Starting from First Row for Iteration
				rs.beforeFirst();

				int i = 0;

				while (rs.next()) {

					int j = 0;

					data[i][j++] = rs.getString("username");

					data[i][j++] = rs.getString("speelstatus");

					i++;
				}

				status = true;

				statement.close();
		}

		 catch (Exception e) {
			System.out.println(e);
		}

		return data;

	}

	
	
	private int getColumnCount(ResultSet rs) {

		try {

			if (rs != null)
				return rs.getMetaData().getColumnCount();

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
