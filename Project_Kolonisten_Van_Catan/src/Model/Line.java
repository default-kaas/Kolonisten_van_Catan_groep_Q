package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Line {
	ArrayList<Point> tileCenterPoints = new ArrayList<Point>();
	ArrayList<Point> inBetweenPoints = new ArrayList<Point>();
	
	public ArrayList<Point> getTileCenterPoints() {
		return tileCenterPoints;
	}
	public void setTileCenterPoints(ArrayList<Point> tileCenterPoints) {
		this.tileCenterPoints = tileCenterPoints;
	}
	
	public ArrayList<Point> getInBetweenPoints() {
		return inBetweenPoints;
	}
	public void setInBetweenPoints(ArrayList<Point> inBetweenPoints) {
		this.inBetweenPoints = inBetweenPoints;
	}
	
	
}
