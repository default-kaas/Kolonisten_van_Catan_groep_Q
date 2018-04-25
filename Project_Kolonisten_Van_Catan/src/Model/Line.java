package Model;

import java.awt.Point;
import java.util.ArrayList;

import Database.BoardDAO;

public class Line {
	private ArrayList<Point> tileCenterPoints = new ArrayList<Point>();
	private ArrayList<Point> inBetweenPoints = new ArrayList<Point>();
	private BoardDAO boardDAO = new BoardDAO();
	
	public Line(BoardDAO boardDAO){
		this.boardDAO = boardDAO;
	}
	
	public ArrayList<Point> getTileCenterPoints() {
		return tileCenterPoints;
	}
	
	public void setTileCenterPoints(ArrayList<Point> tileCenterPoints) {
		this.tileCenterPoints = tileCenterPoints;
	}
	
	public ArrayList<Point> getInBetweenPoints() {
		return inBetweenPoints;
	}
	
	public void setInBetweenPoints(ArrayList<Point> inBetweenPoints) {
		this.inBetweenPoints = inBetweenPoints;
	}
}
