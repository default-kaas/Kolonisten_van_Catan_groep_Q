package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.GameDAO;
import Database.PlayerDAO;

public class Game {
	private int GameId;
	private int PlayersRound;
	private ArrayList<Player> Players;

	private ArrayList<ResourceCards> WoodStack;
	private ArrayList<ResourceCards> WheatStack;
	private ArrayList<ResourceCards> StoneStack;
	private ArrayList<ResourceCards> OreStack;
	private ArrayList<ResourceCards> WoolStack;

	private PlayerDAO PlayerDBInfo;
	private GameDAO GameDB;
	private String userName;

	public Game(int GameId, String userName, Connection db_conn) {
		this.GameId = GameId;
		this.userName = userName;

		// PlayersRound moet elke keer worden geupdate vanuit de DAO
		GameDB = new GameDAO(db_conn);
		PlayersRound = GameDB.getPlayersRound(GameId);
		PlayerDBInfo = new PlayerDAO(db_conn);

		Players = new ArrayList<Player>();
		addPlayers();

		addResources();
	}

	private void addPlayers() {
		for (int i = 0; i < 4; i++) {
			try {
				String Color = "";
				switch(i) {
				case 0: Color = "rood"; break;
				case 1: Color = "wit"; break;
				case 2: Color = "blauw"; break;
				case 3: Color = "orangje"; break;
				}
				
				Players.add(new Player(PlayerDBInfo.getName(i, GameId), PlayerDBInfo.getPlayerID(i, GameId), Color));
				if (Players.get(i).getName().equals(userName)) {
					Players.get(i).itsMe();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addResources() {
		WoodStack = new ArrayList<ResourceCards>();
		WheatStack = new ArrayList<ResourceCards>();
		StoneStack = new ArrayList<ResourceCards>();
		OreStack = new ArrayList<ResourceCards>();
		WoolStack = new ArrayList<ResourceCards>();
		for (int x = 1; x <= 19; x++) {
			WoodStack.add(new ResourceCards('W', ("w" + x)));
		}
		for (int x = 1; x <= 19; x++) {
			WheatStack.add(new ResourceCards('G', ("G" + x)));
		}
		for (int x = 1; x <= 19; x++) {
			StoneStack.add(new ResourceCards('B', ("B" + x)));
		}
		for (int x = 1; x <= 19; x++) {
			OreStack.add(new ResourceCards('E', ("E" + x)));
		}
		for (int x = 1; x <= 19; x++) {
			WoolStack.add(new ResourceCards('H', ("H" + x)));
		}
		
		getMe().addResource(StoneStack.get(0), 'B');
		StoneStack.remove(StoneStack.get(0));
		
		getMe().addResource(WoodStack.get(0), 'W');
		WoodStack.remove(WoodStack.get(0));
		
		System.out.println(getMe().getStoneAmount());
		System.out.println(StoneStack.size());

//		getMe().addResource(WoodStack.get(0), 'G');
//		WoodStack.remove(WoodStack.get(0));
//		getMe().addResource(WoodStack.get(0), 'E');
//		WoodStack.remove(WoodStack.get(0));
	}

	public ArrayList<Player> GetPlayers() {
		return Players;
	}

	public int getRound() {
		return PlayersRound;
	}
	
	public int getGameID() {
		return GameId;
	}

	public Player getMe() {
		for (Player x : Players) {
			if (x.isItMe()) {
				return x;
			}
		}
		return null;
	}
	

}
