package Controller;

import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sound.sampled.Line;

import Model.Board;
import Model.Corner;
import Model.Game;
import Model.Tile;

public class BoardController {
	private Game game;
	private Connection connection;
	private Board board;
	
	public BoardController(Game game, Connection connection ) {
		this.game = game;
		this.connection = connection;
		board = new Board(game, connection);
	}
	
	public void createBoardSaveValues(int gameNumber) {
		ArrayList<Point> arrayListTileCenter = new ArrayList<Point>();
		arrayListTileCenter.addAll(board.getBoardDAOTilePointsFromDataBase(gameNumber));
		// this is to create the values that are going to get returend to the board
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Corner> conrers = new ArrayList<Corner>();
		ArrayList<Line> lines = new ArrayList<Line>();
		
			for (int i = 0; i < arrayListTileCenter.size(); i++) {
				// this to get the tile centerpoint for the calcution for the other poins
				Point tileCenter = new Point();
				tileCenter.setLocation(arrayListTileCenter.get(i));
				Tile tile = new Tile();
				tile.setCenterPoint(tileCenter);
				//this is needed to get the int values to find the other point that are with the tile
				int x = (int) tileCenter.getX();
				int y = (int) tileCenter.getY();

				// left first
				Point point = new Point();
				int xpoint = x - 1;
				int ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornerlf = new Corner();
				cornerlf.setPoint(point);
				// This for loop is needed to see which tile centers lay around the corner point
					int xlf = (int) cornerlf.getPoint().getX();
					int ylf = (int) cornerlf.getPoint().getY();
				
					Point pointlf = new Point();
					// left first
					int xpointlf = xlf - 1;
					int ypointlf = ylf - 1;
					pointlf.setLocation(xpointlf, ypointlf);
					for(Point listTileCenter: arrayListTileCenter) {
						if(listTileCenter.getLocation() == pointlf) {
							cornerlf.set
						}
					}
					
					// left second
					xpointlf = xlf - 1;
					ypointlf = ylf;
					pointlf.setLocation(xpointlf, ypointlf);
				
					// center first
					xpointlf = xlf;
					ypointlf = ylf + 1;
					pointlf.setLocation(xpointlf, ypointlf);
				
					// center second
					xpointlf = xlf;
					ypointlf = ylf - 1;
					pointlf.setLocation(xpointlf, ypointlf);
				

					// right first
					xpointlf = xlf;
					ypointlf = ylf + 1;
					pointlf.setLocation(xpointlf, ypointlf);
				
					// right second
					xpointlf = xlf;
					ypointlf = ylf + 1;
					pointlf.setLocation(xpointlf, ypointlf);
				
				
				
				// left second
				xpoint = x - 1;
				ypoint = y;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornerls = new Corner();
				cornerls.setPoint(point);
				
				// center first
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornercf = new Corner();
				cornercf.setPoint(point);
				
				// center second
				xpoint = x;
				ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornercs = new Corner();
				cornercs.setPoint(point);	

				// right first
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornerrf = new Corner();
				cornerrf.setPoint(point);
				
				// right second
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				// Corner object
				Corner cornerrs = new Corner();
				cornerrs.setPoint(point);
				
				
			}
	}	
}
