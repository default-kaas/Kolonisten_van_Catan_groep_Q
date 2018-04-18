package Model;

import java.sql.SQLException;

public class Player {
	private String Name;
	private String Color;
	private int Points;
	private boolean myTurn;
	private int GameNumber;
	//private Database.PlayerDAO PlayerDAO;
	
	public Player(String Name) {
		this.Name = setName(Name);
		
	}

	private String setName(String Name) {
		// TODO Auto-generated method stub
		return Name;
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
