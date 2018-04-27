package Model;

import java.awt.Point;
import java.util.ArrayList;

import Database.BoardDAO;

public class Tile {
	private Point CenterPoint = new Point();
	private ArrayList<Point> cornerPoints = new ArrayList<Point>();
	///
	public Point getCenterPoint() {
		return CenterPoint;
	}
	public void setCenterPoint(Point centerPoint) {
		CenterPoint = centerPoint;
	}
	
	public ArrayList<Point> getCornerPoints() {
		return cornerPoints;
	}
	public void setCornerPoints(ArrayList<Point> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	
	
}
