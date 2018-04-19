package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import DatabaseConnect.DatabaseConnect;

public class LobbyDAO {
	private boolean status;
	DatabaseConnect Connection;
	Connection m_Conn;

	public LobbyDAO() {

		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}

	}

	public Object[][] getUserList() {

		Object[][] data = null;

		final String QUERY = "Select username from account";

		try {

			Statement statement = (Statement) m_Conn.createStatement();

			ResultSet rs = statement.executeQuery(QUERY);

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();

			int i = 0;

			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getInt("username");

				i++;
			}

			status = true;

			statement.close();

		} catch (Exception e) {

			e.printStackTrace();
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
