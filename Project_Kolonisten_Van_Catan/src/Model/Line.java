package Model;

import java.util.ArrayList;

public class Line {
	private ArrayList<Corner> cornerPoints = new ArrayList<Corner>();
	
	public ArrayList<Corner> getCornerPoints() {
		return cornerPoints;
	}
	public void setCornerPoint(Corner corner) {
		cornerPoints.add(corner);
	}
	public void setCornerPoints(ArrayList<Corner> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	public boolean compareIfCornerIsInLine(Corner corner) {
		for(Corner cornerOfLine: cornerPoints) {
			if(cornerOfLine.getInGamePoint().getX()==corner.getInGamePoint().getX()
			&&cornerOfLine.getInGamePoint().getY()==corner.getInGamePoint().getY()) {
			return true;
			}
		}
		return false;
	}
	
	
	
}
