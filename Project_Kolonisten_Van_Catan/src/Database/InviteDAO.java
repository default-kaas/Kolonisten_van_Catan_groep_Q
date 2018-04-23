package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InviteDAO {
	private boolean status;

	Connection m_Conn;

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
			if(rs.next()) {
				
			

			int spel = rs.getInt("idspel");

			final String QUERY2 = "select * from speler where idspel = " + spel + " and speelstatus = 'uitdager'";
			ResultSet rx = statement.executeQuery(QUERY2);
			int rowCount = getRowCount(rx); // Row Count
			int columnCount = getColumnCount(rx); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rx.beforeFirst();

			int i = 0;

			while (rx.next()) {

				int j = 0;
				
				data[i][j++] = rx.getInt("idspel");
				System.out.println(j);
				data[i][j++] = rx.getString("username");
				System.out.println(j);
				i++;
			}

			statement.close();

		}else {
			//Nep data xD
			data = new Object[1][2];
			data[0][0] = " Geen";
			data[0][1] = " game";
		}
			
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
