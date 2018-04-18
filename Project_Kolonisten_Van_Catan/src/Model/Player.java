package Model;

import java.sql.SQLException;

public class Player {
	private String Name;
	private String Color;
	private int Points;
	private boolean myTurn;
	
	private Database.PlayerDAO PlayerDAO;
	
	public Player() {
		System.out.println("Player is made!");
		PlayerDAO = new Database.PlayerDAO();
		try {
			Name = PlayerDAO.getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("First name in account table: "+ Name);
	}
	
}
