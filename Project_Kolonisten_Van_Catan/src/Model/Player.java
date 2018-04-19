package Model;

import java.sql.SQLException;

public class Player {
	private String Name;
	private String Color;
	private int PlayerId;
	private int Points;
	private boolean itsMe = false;
//	private boolean myTurn;
	private int GameNumber;
	//private Database.PlayerDAO PlayerDAO;
	
	public Player(String Name, int PlayerID) {
		this.Name = setName(Name);
		this.PlayerId = PlayerID;
	}

	private String setName(String Name) {
		// TODO Auto-generated method stub
		return Name;
	}
	public void itsMe() {
		itsMe = true;
	}
	public String getName() {
		return Name;
	}
	public int getPlayerID() {
		return PlayerId;
	}
	
	public String getColor() {
		return Color;
	}

	public int getPoints() {
		return Points;
	}
	
//	public boolean isMyTurn() {
//		return myTurn;
//	}
	
	
	
}
