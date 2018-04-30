package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Tile {
	///Database information///
	private Point CenterPoint = new Point();
	private ArrayList<Point> cornerPoints = new ArrayList<Point>();
	private char idResourceType;
	private int idGetalFiche;
	///In game information///
	private Point inGameCenterPoint = new Point();
	private ArrayList<Point> inGameCornerPoints = new ArrayList<Point>();
	
	/// Database information///
	//CenterPoint
	public Point getCenterPoint() {
		return CenterPoint;
	}
	public void setCenterPoint(Point centerPoint) {
		CenterPoint = centerPoint;
	}
	//CornerPoints
	public ArrayList<Point> getCornerPoints() {
		return cornerPoints;
	}
	public void setCornerPoints(ArrayList<Point> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	//IDResourceType
	public char getIdResourceType() {
		return idResourceType;
	}
	public void setIdResourceType(char idResourceType) {
		this.idResourceType = idResourceType;
	}
	//IDGetalFiche
	public int getIdGetalFiche() {
		return idGetalFiche;
	}
	public void setIdGetalFiche(int idGetalFiche) {
		this.idGetalFiche = idGetalFiche;
	}
	///In game information///
	//InGameCenterPoint
	public Point getInGameCenterPoint() {
		return inGameCenterPoint;
	}
	public void setInGameCenterPoint(Point inGameCenterPoint) {
		this.inGameCenterPoint = inGameCenterPoint;
	}
	//InGameCornerPoints
	public ArrayList<Point> getInGameCornerPoints() {
		return inGameCornerPoints;
	}
	public void setInGameCornerPoints(ArrayList<Point> inGameCornerPoints) {
		this.inGameCornerPoints = inGameCornerPoints;
	}
}
