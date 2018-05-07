package Model;

import java.util.ArrayList;

public class Dock {
	private char type;
	private ArrayList<Corner> cornerPoints = new ArrayList<Corner>();
	
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
	public void setCornerPoints(ArrayList<Corner> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
}
