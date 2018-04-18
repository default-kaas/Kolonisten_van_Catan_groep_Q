package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class PlayerDAO {
	Connection m_Conn;
	private int Game;
	
	public PlayerDAO(int Game) {
		System.out.println("PlayerDAO is made!");
		this.Game = Game;
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}

	public String getName() throws SQLException {
		Statement stmt = m_Conn.createStatement();
		ResultSet rs = stmt.executeQuery("select username from speler where idspel="+ Game + " and speelstatus = 'uitdager'" );
		rs.next();
		String name = rs.getString("username");
		return name;
	}
}