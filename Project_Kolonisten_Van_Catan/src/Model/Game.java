package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.GameDAO;
import Database.PlayerDAO;

public class Game {
	private int GameId;
	private int PlayersRound;
	private ArrayList<Player> Players;
	private PlayerDAO PlayerDBInfo;
	private GameDAO GameDB;
	
	public Game(int GameId, String userName) {
		this.GameId = GameId;
		
		//PlayersRound moet elke keer worden geupdate vanuit de DAO
		GameDB = new GameDAO();
		
		PlayersRound = GameDB.getPlayersRound(GameId);
		
		PlayerDBInfo = new PlayerDAO();	
		Players = new ArrayList<Player>();
		
		for(int i =0; i<4; i++) {
			try {
				Players.add(new Player(PlayerDBInfo.getName(i, GameId), PlayerDBInfo.getPlayerID(i,GameId)));
				if(Players.get(i).getName().equals(userName)) {
					Players.get(i).itsMe();
				}
				System.out.println(Players.get(i).getName()+ ", ID: "+Players.get(i).getPlayerID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<Player> GetPlayers(){
		return Players;
	}
	public int getRound() {
		return PlayersRound;
	}
	
	
}
