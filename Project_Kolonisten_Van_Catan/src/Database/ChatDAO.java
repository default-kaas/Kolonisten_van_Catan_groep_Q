package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class ChatDAO {
	Connection m_Conn;

	public ChatDAO() {
		System.out.println("ChatDAO is made!");
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}

	public boolean setChatMessage(int PlayerID, String Message) {
		try {
			Statement stmt = m_Conn.createStatement();
			stmt.executeUpdate("INSERT INTO chatregel (tijdstip, idspeler, bericht)  VALUES (CURRENT_TIMESTAMP,"+PlayerID+", '"+Message+"')");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}