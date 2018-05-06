package Model;

import java.awt.Point;
import java.util.ArrayList;

public class Street {
	private int player;
	private ArrayList<Corner> cornerPoints = new ArrayList<Corner>();
	
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	
	public ArrayList<Corner> getCornerPoints() {
		return cornerPoints;
	}
	public void setCorner(Corner corner) {
		cornerPoints.add(corner);
	}
	public void setCorners(ArrayList<Corner> cornerPoints) {
		this.cornerPoints = cornerPoints;
	}
	public boolean compareIfCornersIsInLine(Corner corner1,Corner corner2) {
		// this is to count the amount of matches of corners with this line
		int match =0;
		for(Corner cornerOfLine: cornerPoints) {
			//this will check if there is a match with the first corner
			if(cornerOfLine.getPoint().getX()==corner1.getPoint().getX()
			&&cornerOfLine.getPoint().getY()==corner1.getPoint().getY()) {
				match++;
			//this will check if there is a match with the second corner
			}else if(cornerOfLine.getPoint().getX()==corner2.getPoint().getX()
					&&cornerOfLine.getPoint().getY()==corner2.getPoint().getY()) {
				match++;
			}
		}
		// if the match is two that means that street object exists that has both corner objects already
		if(match==2) {
			return true;
		}else {
			return false;
		}
	}
}
