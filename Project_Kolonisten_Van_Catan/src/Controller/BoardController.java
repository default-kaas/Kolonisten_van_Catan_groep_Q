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
		createBoardSaveValues(game.getGameID());
	}
	
	public void createBoardSaveValues(int gameNumber) {
		ArrayList<Point> arrayListTileCenter = new ArrayList<Point>();
		arrayListTileCenter.addAll(board.getBoardDAOTilePointsFromDataBase(gameNumber));
		// this is to create the values that are going to get returend to the board
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Corner> corners = new ArrayList<Corner>();
		// this loop will create all tiles with their tile points
			for (int i = 0; i < arrayListTileCenter.size(); i++) {
				// this to get the tile centerpoint for the calculation for the other points
				Point tileCenter = new Point();
				tileCenter.setLocation(arrayListTileCenter.get(i));
				Tile tile = new Tile();
				tile.setCenterPoint(tileCenter);
				tile.setCornerPoints(returnTileCornPoints(tile.getCenterPoint()));
				tiles.add(tile);
			}
		ArrayList<Point> arrayListLocation = new ArrayList<Point>();
		arrayListLocation.addAll(board.getBoardDAOTilePointsFromDataBase(gameNumber));
		// this loop will create all corners
			for(int i =0; i<arrayListLocation.size();i++) {
				Point cornPoint = new Point();
				cornPoint.setLocation(arrayListLocation.get(i));
				Corner corner = new Corner();
				corner.setPoint(cornPoint);
				corner.setTilePoints(returnTilesCenters(corner.getPoint(),tiles));
				corner.setLinePoints(returnCorners(corner.getPoint(),tiles));
				corners.add(corner);
			}
		board.setTiles(tiles);
		board.setCorners(corners);
	}
	
	
	// this to create the tile cornPoints
	private ArrayList<Point> returnTileCornPoints(Point tilePoint){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		Point point = new Point();
		int x = (int) tilePoint.getX();
		int y = (int) tilePoint.getY();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		// left second
		xpoint = x - 1;
		ypoint = y;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		// center first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		// center second
		xpoint = x;
		ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		// right first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		// right second
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		arrayList.add(point);
		return arrayList;
	}
	
	// this is to create the tile center points that surround the corner
	private ArrayList<Point> returnTilesCenters(Point cornerPoint, ArrayList<Tile> tilesCenters){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		int x = (int) cornerPoint.getX();
		int y = (int) cornerPoint.getY();
		Point point = new Point();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// left second
		xpoint = x - 1;
		ypoint = y;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// center first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// center second
		xpoint = x;
		ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// right first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// right second
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(tileCenterExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		return arrayList;
	}
	
	// this is the check if the tile center points exist
	private boolean tileCenterExists(Point possiblePoint, ArrayList<Tile> tilesCenters) {
		for(Tile tileCenter: tilesCenters) {
			if(tileCenter.getCenterPoint() == possiblePoint) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Point> returnCorners(Point cornerPoint, ArrayList<Tile> tilesCenters){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		int x = (int) cornerPoint.getX();
		int y = (int) cornerPoint.getY();
		Point point = new Point();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// left second
		xpoint = x - 1;
		ypoint = y;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// center first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// center second
		xpoint = x;
		ypoint = y - 1;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// right first
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		// right second
		xpoint = x;
		ypoint = y + 1;
		point.setLocation(xpoint, ypoint);
		if(cornExists(point,tilesCenters)) {
			arrayList.add(point);
		}
		return arrayList;
	}
	
	// this is to check if the corn point exists
	private boolean cornExists(Point pointPossibleTile, ArrayList<Tile> tilePoints) {
		for(Tile tilepoint: tilePoints) {
			ArrayList<Point> pointList = tilepoint.getCornerPoints();
			for(Point point: pointList) {
				if(point.getLocation() == pointPossibleTile) {
					return true;
				}
			}
		}
		return false;
	}
}
