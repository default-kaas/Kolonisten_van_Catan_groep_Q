package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Corner {
	private Point point = new Point();
	private ArrayList<Tile> tilePoints = new ArrayList<Tile>();
	private ArrayList<Line> lines = new ArrayList<Line>();
	//
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public ArrayList<Tile> getTilePoints() {
		return tilePoints;
	}
	public void setTilePoints(ArrayList<Tile> tilePoints) {
		this.tilePoints = tilePoints;
	}
	
	public ArrayList<Line> getLines() {
		return lines;
	}
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
}
