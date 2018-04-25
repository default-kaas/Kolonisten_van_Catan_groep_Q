package Model;

import java.util.ArrayList;

import Database.BoardDAO;

public class Tile {
	private ArrayList<CornerPoint> arrayListCornerPoints = new ArrayList<CornerPoint>();
	private ArrayList<Line> arrayListLines = new ArrayList<Line>();
	private BoardDAO boardDAO;
	
	public Tile(BoardDAO boardDAO){
		this.boardDAO = boardDAO;
	}
	
	public ArrayList<CornerPoint> getArrayListCornerPoints() {
		return arrayListCornerPoints;
	}
	public void setArrayListCornerPoints(ArrayList<CornerPoint> arrayListCornerPoints) {
		this.arrayListCornerPoints = arrayListCornerPoints;
	}
	public ArrayList<Line> getArrayListLines() {
		return arrayListLines;
	}
	public void setArrayListLines(ArrayList<Line> arrayListLines) {
		this.arrayListLines = arrayListLines;
	}
}
