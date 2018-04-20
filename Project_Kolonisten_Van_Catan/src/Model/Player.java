package Model;

import java.util.ArrayList;

public class Player {
	private String Name;
	private String Color;
	private int PlayerId;
	private int Points;
	private boolean itsMe = false;
//	private boolean myTurn;
	private ArrayList<ResourceCards> Resources;
	private int GameNumber;
	//private Database.PlayerDAO PlayerDAO;
	
	private ArrayList<ResourceCards> WoodStack;
	private ArrayList<ResourceCards> WheatStack;
	private ArrayList<ResourceCards> StoneStack;
	private ArrayList<ResourceCards> OreStack;
	private ArrayList<ResourceCards> WoolStack;
	
	public Player(String Name, int PlayerID) {
		setArray();
		this.Name = setName(Name);
		this.PlayerId = PlayerID;
		this.Color = "TestColor";
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
	
	public void addResource(ResourceCards Resources, char ResourceType) {
		System.out.println(ResourceType);
		System.out.println(Resources.getResourceID());
		switch(ResourceType) {
		case 'W': this.WoodStack.add(Resources);
		break;
		case 'G': this.WheatStack.add(Resources);
		break;
		case 'B': this.StoneStack.add(Resources);
		break;
		case 'E': this.OreStack.add(Resources);
		break;
		case 'H': this.WoolStack.add(Resources);
		break;
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
//	public boolean isMyTurn() {
//		return myTurn;
//	}
	
	
	
}
