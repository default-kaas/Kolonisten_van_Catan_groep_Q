package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Dock {
	private char type;
	private ArrayList<Corner> cornerPoints = new ArrayList<Corner>();
	// in game point for type of dock display
	private Point dockPoint;
	
	// with this you can set what type of dock it is
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	// with this you can set which corners belong to the dock
	public ArrayList<Corner> getCornerPoints() {
		return cornerPoints;
	}
	public Corner getCorner(int index) {
		return cornerPoints.get(index);
	}
	
	public void setCornerPoints(ArrayList<Corner> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	public void setCornerPoint(Corner corner) {
		this.cornerPoints.add(corner);
	}
	// with this you can set the location of the point that has to be displayed for the dock (What type of dock it is)
	public Point getDockPoint() {
		return dockPoint;
	}
	public void setDockPoint(Point dockPoint) {
		this.dockPoint = dockPoint;
	}
}
