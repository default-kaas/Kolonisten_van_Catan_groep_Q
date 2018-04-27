package Model;

import java.util.ArrayList;

public class Line {
	private ArrayList<Corner> cornerPoints = new ArrayList<Corner>();
	private ArrayList<Tile> tilePoints = new ArrayList<Tile>();
	//
	public ArrayList<Corner> getCornerPoints() {
		return cornerPoints;
	}
	public void setCornerPoints(ArrayList<Corner> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	
	public ArrayList<Tile> getTilePoints() {
		return tilePoints;
	}
	public void setTilePoints(ArrayList<Tile> tilePoints) {
		this.tilePoints = tilePoints;
	}
	
}
