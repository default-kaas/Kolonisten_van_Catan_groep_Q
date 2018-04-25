package Model;

import java.util.ArrayList;

public class Tile {
	private ArrayList<CornerPoint> arrayListCornerPoints = new ArrayList<CornerPoint>();
	private ArrayList<Line> arrayListLines = new ArrayList<Line>();
	
	public ArrayList<CornerPoint> getArrayListCornerPoints() {
		return arrayListCornerPoints;
	}
	public void setArrayListCornerPoints(ArrayList<CornerPoint> arrayListCornerPoints) {
		this.arrayListCornerPoints = arrayListCornerPoints;
	}
	public ArrayList<Line> getArrayListLines() {
		return arrayListLines;
	}
	public void setArrayListLines(ArrayList<Line> arrayListLines) {
		this.arrayListLines = arrayListLines;
	}
}
