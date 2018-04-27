package Model;

import java.awt.Point;
import java.util.ArrayList;

import Database.BoardDAO;

public class Tile {
	private Point CenterPoint = new Point();
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	private ArrayList<Line> lines = new ArrayList<Line>();
	
	public Point getCenterPoint() {
		return CenterPoint;
	}
	public void setCenterPoint(Point centerPoint) {
		CenterPoint = centerPoint;
	}
	
	public ArrayList<Corner> getCorners() {
		return corners;
	}
	public void setCorners(ArrayList<Corner> corners) {
		this.corners = corners;
	}
	
	public ArrayList<Line> getLines() {
		return lines;
	}
	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
}
