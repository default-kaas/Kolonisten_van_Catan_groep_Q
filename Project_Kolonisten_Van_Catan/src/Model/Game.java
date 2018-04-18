package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.PlayerDAO;

public class Game {
	private int GameId;
	private int PlayersRound;
	private ArrayList<Player> Players;
	private PlayerDAO PlayerDBInfo;
	
	public Game(int GameId) {
		this.GameId = GameId;
		PlayerDBInfo = new PlayerDAO();	
		Players = new ArrayList<Player>();
		
		for(int i =0; i<4; i++) {
			try {
				Players.add(new Player(PlayerDBInfo.getName(i, GameId)));
				System.out.println(Players.get(i).getName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Player> GetPlayers(){
		return Players;
	}
}
