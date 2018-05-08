package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDAO {
	private Connection m_Conn;

	public GameDAO(Connection db_conn) {
		m_Conn = db_conn;

	}

	public int getPlayersRound(int gameId) {
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select beurt_idspeler from spel where idspel=" + gameId);
			rs.next();
			int beurt = rs.getInt("beurt_idspeler");
			return beurt;
		} catch (SQLException e) {
			return 0;
		}

	}

	public Object[][] getResourceAmount(int gameId, String userName, int i2) {
		Object[][] x = null;
		try {
			Statement stmt = m_Conn.createStatement();
			ResultSet rs;
			String query = null;
			switch (i2) {
			case 0:
				query = "select sgk.idgrondstofkaart as id, gk.idgrondstofsoort as soort from spelergrondstofkaart as sgk join speler as s on sgk.idspeler = s.idspeler join grondstofkaart as gk on gk.idgrondstofkaart = sgk.idgrondstofkaart   where sgk.idspel = "
						+ gameId + " and username = '" + userName + "' and gk.idgrondstofsoort = 'W'";
				break;
			case 1:
				query = "select sgk.idgrondstofkaart as id, gk.idgrondstofsoort as soort from spelergrondstofkaart as sgk join speler as s on sgk.idspeler = s.idspeler join grondstofkaart as gk on gk.idgrondstofkaart = sgk.idgrondstofkaart   where sgk.idspel = "
						+ gameId + " and username = '" + userName + "' and gk.idgrondstofsoort = 'G'";
				break;
			case 2:
				query = "select sgk.idgrondstofkaart as id, gk.idgrondstofsoort as soort from spelergrondstofkaart as sgk join speler as s on sgk.idspeler = s.idspeler join grondstofkaart as gk on gk.idgrondstofkaart = sgk.idgrondstofkaart   where sgk.idspel = "
						+ gameId + " and username = '" + userName + "' and gk.idgrondstofsoort = 'B'";
				break;
			case 3:
				query = "select sgk.idgrondstofkaart as id, gk.idgrondstofsoort as soort from spelergrondstofkaart as sgk join speler as s on sgk.idspeler = s.idspeler join grondstofkaart as gk on gk.idgrondstofkaart = sgk.idgrondstofkaart   where sgk.idspel = "
						+ gameId + " and username = '" + userName + "' and gk.idgrondstofsoort = 'E'";
				break;
			case 4:
				query = "select sgk.idgrondstofkaart as id, gk.idgrondstofsoort as soort from spelergrondstofkaart as sgk join speler as s on sgk.idspeler = s.idspeler join grondstofkaart as gk on gk.idgrondstofkaart = sgk.idgrondstofkaart   where sgk.idspel = "
						+ gameId + " and username = '" + userName + "' and gk.idgrondstofsoort = 'H'";
				break;
			}

			rs = stmt.executeQuery(query);

			x = new Object[getRowCount(rs)][2];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				x[i][0] = rs.getString("id");
				String test = rs.getString("soort");
				char test1 = test.charAt(0);
				x[i][1] = test1;
				i++;
			}

			return x;
		} catch (SQLException e) {
			return x;
		}

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
