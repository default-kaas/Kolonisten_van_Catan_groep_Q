package Model;

import java.util.ArrayList;

import Database.PlayerDAO;

public class Player {
	private String Name;
	private String Color;
	private int PlayerId;
	private int Points;
	private boolean itsMe = false;
	// private boolean myTurn;
	private ArrayList<ResourceCards> Resources;
	private int GameNumber;
	private boolean hasThrown;

	// private Database.PlayerDAO PlayerDAO;
	private ArrayList<ResourceCards> WoodStack;
	private ArrayList<ResourceCards> WheatStack;
	private ArrayList<ResourceCards> StoneStack;
	private ArrayList<ResourceCards> OreStack;
	private ArrayList<ResourceCards> WoolStack;

	private PlayerDAO playerDBInfo;

	public Player(String Name, int PlayerID, String Color, PlayerDAO playerDBInfo) {
		setArray();
		this.playerDBInfo = playerDBInfo;
		this.Name = setName(Name);
		this.PlayerId = PlayerID;
		this.Color = Color;
		hasThrown = false;
	}

	private void setArray() {
		WoodStack = new ArrayList<ResourceCards>();
		WheatStack = new ArrayList<ResourceCards>();
		StoneStack = new ArrayList<ResourceCards>();
		OreStack = new ArrayList<ResourceCards>();
		WoolStack = new ArrayList<ResourceCards>();
	}

	private String setName(String Name) {
		// TODO Auto-generated method stub
		return Name;
	}

	public void setThrown() {
		hasThrown = true;
	}

	public void itsMe() {
		itsMe = true;
	}

	public boolean isItMe() {
		return itsMe;
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

	public boolean gethasTrown() {
		return hasThrown;
	}

	public void addResource(ResourceCards Resources, char ResourceType) {
		switch (ResourceType) {
		case 'H':
			this.WoodStack.add(Resources);
			break;
		case 'G':
			this.WheatStack.add(Resources);
			break;
		case 'B':
			this.StoneStack.add(Resources);
			break;
		case 'E':
			this.OreStack.add(Resources);
			break;
		case 'W':
			this.WoolStack.add(Resources);
			break;
		}

	}

	public void removeRoadResources(int gameId) {
		for (int i = 0; i < WoodStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WoodStack.get(i).getResourceID());
				WoodStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < StoneStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, StoneStack.get(i).getResourceID());
				StoneStack.remove(i);
				break;
			}
		}
	}

	public void removeHouseResources(int gameId) {

		for (int i = 0; i < WoodStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WoodStack.get(i).getResourceID());
				WoodStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < StoneStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, StoneStack.get(i).getResourceID());
				StoneStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WoolStack.get(i).getResourceID());
				WoolStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < WheatStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WheatStack.get(i).getResourceID());
				WheatStack.remove(i);
				break;
			}
		}

	}

	public void removeCityResources(int gameId) {
		int i = 0;
		int x = 0;
		while (i < 3) {
			playerDBInfo.setPlayerResources(gameId, PlayerId, OreStack.get(0).getResourceID());
			OreStack.remove(0);
			i++;
		}

		while (x < 2) {
			playerDBInfo.setPlayerResources(gameId, PlayerId, WheatStack.get(0).getResourceID());
			WheatStack.remove(0);
			x++;
		}

	}

	public void removeDevResources(int gameId) {

		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WoolStack.get(0).getResourceID());
				WoolStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < OreStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, OreStack.get(0).getResourceID());
				OreStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
				playerDBInfo.setPlayerResources(gameId, PlayerId, WheatStack.get(0).getResourceID());
				WheatStack.remove(i);
				break;
			}
		}
	}

	public int getWoodAmount() {
		return WoodStack.size();
	}

	public int getWheatAmount() {
		return WheatStack.size();
	}

	public int getStoneAmount() {
		return StoneStack.size();
	}

	public int getOreAmount() {
		return OreStack.size();
	}

	public int getWoolAmount() {
		return WoolStack.size();
	}
	// public boolean isMyTurn() {
	// return myTurn;
	// }

}
