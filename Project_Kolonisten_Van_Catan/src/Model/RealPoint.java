package Model;

import java.awt.Point;

public class RealPoint {
	private Point dataBasePoint;
	private Point realPoint;
	
	public void setDataBasePoint(Point point) {
		this.dataBasePoint = point;
	}
	
	public void setRealPoint(Point point) {
		this.realPoint = point;
	}
	
	public Point getDataBasePoint() {
		return dataBasePoint;
	}
	
	public Point getRealPoint() {
		return realPoint;
	}
}
