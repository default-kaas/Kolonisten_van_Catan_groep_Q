package Model;

import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

import Database.BoardDAO;

public class Board {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	
	private BoardDAO boardDOA;
	private Game game;
	
	public Board(Game game, Connection connection){
		boardDOA = new BoardDAO(connection);
		
	}
	//

	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}

	public ArrayList<Corner> getCorners() {
		return corners;
	}
	public void setCorners(ArrayList<Corner> corners) {
		this.corners = corners;
	}

	public ArrayList<Point> getBoardDAOTilePointsFromDataBase(int gameNumber){
		return boardDOA.getTilePointsFromDataBase(gameNumber);
	}
	
	public ArrayList<Point> getBoardDAOCornerPointsFromDataBase(int gameNumber){
		return boardDOA.getLocationsFromDataBase(gameNumber);
	}
}
