package Model;

import java.sql.SQLException;

public class Player {
	private String Name;
	private String Color;
	private int Points;
	private boolean myTurn;
	private int GameNumber;
	private Database.PlayerDAO PlayerDAO;
	
	public Player() {
		System.out.println("Player is made!");
		GameNumber = 770;
		PlayerDAO = new Database.PlayerDAO(770);
		try {
			Name = PlayerDAO.getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("First name in account table: "+ Name);
	}

	public String getName() {
		return Name;
	}

	public String getColor() {
		return Color;
	}

	public int getPoints() {
		return Points;
	}

	public boolean isMyTurn() {
		return myTurn;
	}
	
	
	
}
