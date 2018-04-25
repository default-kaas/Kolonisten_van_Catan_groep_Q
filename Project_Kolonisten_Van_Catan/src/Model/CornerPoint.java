package Model;

import java.awt.Point;
import java.util.ArrayList;

public class CornerPoint {
	private ArrayList<Line> arrayLine = new ArrayList<Line>();
	private ArrayList<Point> arrayTileCenter = new ArrayList<Point>();
	private Point point = new Point();
	
	
	public ArrayList<Line> getArrayLine() {
		return arrayLine;
	}
	public void setArrayLine(ArrayList<Line> arrayLine) {
		this.arrayLine = arrayLine;
	}
	
	public ArrayList<Point> getArrayTileCenter() {
		return arrayTileCenter;
	}
	
	public void setArrayTileCenter(ArrayList<Point> arrayTileCenter) {
		this.arrayTileCenter = arrayTileCenter;
	}
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	
	
}
