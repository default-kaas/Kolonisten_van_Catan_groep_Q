package Model;

import java.awt.Point;
import java.util.ArrayList;

import Database.BoardDAO;

public class Corner {
	private Point point = new Point();
	private ArrayList<Point> tilePoints = new ArrayList<Point>();
	private ArrayList<Point> linePoints = new ArrayList<Point>();
	//
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public ArrayList<Point> getTilePoints() {
		return tilePoints;
	}
	public void setTilePoints(ArrayList<Point> tilePoints) {
		this.tilePoints = tilePoints;
	}
	
	public ArrayList<Point> getLinePoints() {
		return linePoints;
	}
	public void setLinePoints(ArrayList<Point> linePoints) {
		this.linePoints = linePoints;
	}
	
	
}
