package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseConnect.DatabaseConnect;

public class DiceDAO {
	
	Connection m_Conn;
	
	public DiceDAO() {
		System.out.println("DiceDAO is made!");
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			m_Conn = Connection.getConnection();
		} catch (Exception e) {

		}
	}
	
	
	public boolean setDiceValues(int value1,int value2) {
		try {
			Statement stmt = m_Conn.createStatement();
			stmt.executeUpdate("INSERT INTO spel (gedobbeld,laatste_worp_steen1,laatste_worp_steen2)  VALUES (1,"+value1+","+value2+")");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
