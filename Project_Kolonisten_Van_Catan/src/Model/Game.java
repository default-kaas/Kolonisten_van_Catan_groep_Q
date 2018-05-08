package Model;

import java.sql.Connection;
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
		WoodStack = new ArrayList<ResourceCards>();
		WheatStack = new ArrayList<ResourceCards>();
		StoneStack = new ArrayList<ResourceCards>();
		OreStack = new ArrayList<ResourceCards>();
		WoolStack = new ArrayList<ResourceCards>();
		addResources();
	}

	private void addPlayers() {
		for (int i = 0; i < 4; i++) {

			String Color = "";
			switch (i) {
			case 0:
				Color = "rood";
				break;
			case 1:
				Color = "wit";
				break;
			case 2:
				Color = "blauw";
				break;
			case 3:
				Color = "oranje";
				break;
			}
			Players.add(new Player(PlayerDBInfo.getName(i, GameId), PlayerDBInfo.getPlayerID(i, GameId), Color,
					PlayerDBInfo));
			if (Players.get(i).getName().equals(userName)) {
				Players.get(i).itsMe();
			}

		}
	}

	public void addResources() {
		for (int i = 0; i < 5; i++) {
			Object[][] PlayerResources = GameDB.getResourceAmount(GameId, userName, i);
			for (Object[] x : PlayerResources) {
				this.getMe().addResource(new ResourceCards((char) x[1], (String) x[0]), (char) x[1]);
			}
		}
	}

	public void removeStreet() {
		getMe().removeRoadResources(GameId);
	}

	public void removeHouse() {
		getMe().removeHouseResources(GameId);
	}

	public void removeCity() {
		getMe().removeCityResources(GameId);
	}

	public void removeDev() {
		getMe().removeDevResources(GameId);
	}

	public ArrayList<Player> GetPlayers() {
		return Players;
	}

	public int getPlayerResources() {
		int stone = getMe().getStoneAmount();
		int wood = getMe().getWoodAmount();
		int wheat = getMe().getWheatAmount();
		int whool = getMe().getWoolAmount();
		int ore = getMe().getOreAmount();
		int sum = stone + wood + wheat + whool + ore;
		return sum;
	}

	public PlayerDAO getPlayerDAO() {
		return PlayerDBInfo;
	}

	public int getRound() {
		return PlayersRound;
	}

	public void setRound() {
		switch (getMe().getColor()) {
		case "oranje":
			PlayersRound -= 3;
			break;
		default:
			PlayersRound++;
		}
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
