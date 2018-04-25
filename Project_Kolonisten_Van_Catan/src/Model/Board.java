package Model;

import java.sql.Connection;
import java.util.ArrayList;

import Database.BoardDAO;

public class Board {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<CornerPoint> cornerPoints = new ArrayList<CornerPoint>();
	private ArrayList<Line> lines = new ArrayList<Line>();
	private BoardDAO boardDOA;
	private Game game;
	
	public Board(Game game, Connection connection){
		boardDOA = new BoardDAO(connection);
		
	}
	
	public void createBoard() {
		
	}
}
