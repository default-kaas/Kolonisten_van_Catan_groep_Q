package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Corner {
	///Database information///
	private Point point = new Point();
	private ArrayList<Point> tilePoints = new ArrayList<Point>();
	private ArrayList<Point> linePoints = new ArrayList<Point>();
	private boolean dock = false;
	private char idResourceType;
	private boolean town = false;
	private boolean city = false;
	private int playerId;
	///In game information///
	private Point inGamePoint = new Point();
	private ArrayList<Point> inGameTilePoints = new ArrayList<Point>();
	private ArrayList<Point> inGameLinePoints = new ArrayList<Point>();
	///Database information///
	//Point
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	//TilePoints
	public ArrayList<Point> getTilePoints() {
		return tilePoints;
	}
	public void setTilePoints(ArrayList<Point> tilePoints) {
		this.tilePoints = tilePoints;
	}
	//LinePoints
	public ArrayList<Point> getLinePoints() {
		return linePoints;
	}
	public void setLinePoints(ArrayList<Point> linePoints) {
		this.linePoints = linePoints;
	}
	//Dock
	public boolean isDock() {
		return dock;
	}
	public void setDock(int tinyInt) {
		if(tinyInt == 1) {
			this.dock = true;
		}
	}
	//IDResourceType
	public char getIdResourceType() {
		return idResourceType;
	}
	public void setIdResourceType(char idResourceType) {
		this.idResourceType = idResourceType;
	}
	//Town
	public boolean isTown() {
		return town;
	}
	public void setTown(boolean town) {
		this.town = town;
	}
	//City
	public boolean isCity() {
		return city;
	}
	public void setCity(boolean city) {
		this.city = city;
	}
	//PlayerID
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	///In game information///
	//InGamePoint
	public Point getInGamePoint() {
		return inGamePoint;
	}
	public void setInGamePoint(Point inGamePoint) {
		this.inGamePoint = inGamePoint;
	}
	//InGameTilePoints
	public ArrayList<Point> getInGameTilePoints() {
		return inGameTilePoints;
	}
	public void setInGameTilePoints(ArrayList<Point> inGameTilePoints) {
		this.inGameTilePoints = inGameTilePoints;
	}
	//InGameLinePoints
	public ArrayList<Point> getInGameLinePoints() {
		return inGameLinePoints;
	}
	public void setInGameLinePoints(ArrayList<Point> inGameLinePoints) {
		this.inGameLinePoints = inGameLinePoints;
	}
	
	
}
