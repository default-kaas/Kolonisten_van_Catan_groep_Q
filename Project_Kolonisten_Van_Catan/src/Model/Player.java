package Model;

import java.util.ArrayList;

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

	public Player(String Name, int PlayerID, String Color) {
		setArray();
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
		System.out.println(ResourceType);
		System.out.println(Resources.getResourceID());
		switch (ResourceType) {
		case 'W':
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
		case 'H':
			this.WoolStack.add(Resources);
			break;
		}

	}

	public void removeRoadResources() {
		for (int i = 0; i < WoodStack.size(); i++) {
			if (i == 0) {
				WoodStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < StoneStack.size(); i++) {
			if (i == 0) {
				StoneStack.remove(i);
				break;
			}
		}

	}

	public void removeHouseResources() {

		for (int i = 0; i < WoodStack.size(); i++) {
			if (i == 0) {
				WoodStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < StoneStack.size(); i++) {
			if (i == 0) {
				StoneStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
				WoolStack.remove(i);
				break;
			}
		}

		for (int i = 0; i < WheatStack.size(); i++) {
			if (i == 0) {
				WheatStack.remove(i);
				break;
			}
		}

	}

	public void removeCityResources() {
		int i = 0;
		while (i < 3) {
			OreStack.remove(i);
			i++;
		}

		while (i < 2) {
			WheatStack.remove(i);
			i++;
		}

	}

	public void removeDevResources() {
		
		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
				WoolStack.remove(i);
				break;
			}
		}
		
		for (int i = 0; i < OreStack.size(); i++) {
			if (i == 0) {
				OreStack.remove(i);
				break;
			}
		}
		
		for (int i = 0; i < WoolStack.size(); i++) {
			if (i == 0) {
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
