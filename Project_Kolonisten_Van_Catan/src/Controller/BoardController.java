package Controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sound.sampled.Line;

import Model.Board;
import Model.Corner;
import Model.Game;
import Model.Tile;
import View.BoardPanel;

public class BoardController {
	private Game game;
	private Connection connection;
	private Board board;
	private BoardPanel boardPanel;
	
	public BoardController(Game game, Connection connection ) {
		this.game = game;
		this.connection = connection;
		board = new Board(game, connection);
		createBoardSaveValues(game.getGameID());
		boardPanel = new BoardPanel(board);
	
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
		arrayListLocation.addAll(board.getBoardDAOCornerPointsFromDataBase(gameNumber));
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
		int x = (int) tilePoint.getX();
		int y = (int) tilePoint.getY();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		arrayList.add(pointlf);
		// left second
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		arrayList.add(pointls);
		// center first
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		arrayList.add(pointcf);
		// center second
		xpoint = x;
		ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		arrayList.add(pointcs);
		// right first
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		arrayList.add(pointrf);
		// right second
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		arrayList.add(pointrs);
		return arrayList;
	}
	
	// this is to create the tile center points that surround the corner
	private ArrayList<Point> returnTilesCenters(Point cornerPoint, ArrayList<Tile> tilesCenters){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		int x = (int) cornerPoint.getX();
		int y = (int) cornerPoint.getY();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointlf,tilesCenters)) {
			arrayList.add(pointlf);
		}
		// left second
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointls,tilesCenters)) {
			arrayList.add(pointls);
		}
		// center first
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointcf,tilesCenters)) {
			arrayList.add(pointcf);
		}
		// center second
		xpoint = x;
		ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointcs,tilesCenters)) {
			arrayList.add(pointcs);
		}
		// right first
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointrf,tilesCenters)) {
			arrayList.add(pointrf);
		}
		// right second
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointrs,tilesCenters)) {
			arrayList.add(pointrs);
		}
		return arrayList;
	}
	
	// this is the check if the tile center points exist
	private boolean tileCenterExists(Point possiblePoint, ArrayList<Tile> tilesCenters) {
		for(Tile tileCenter: tilesCenters) {
			if(tileCenter.getCenterPoint().equals(possiblePoint)) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Point> returnCorners(Point cornerPoint, ArrayList<Tile> tilesCenters){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		int x = (int) cornerPoint.getX();
		int y = (int) cornerPoint.getY();
		//left first
		int xpoint = x - 1;
		int ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		if(cornExists(pointlf,tilesCenters)) {
			arrayList.add(pointlf);
		}
		// left second
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		if(cornExists(pointls,tilesCenters)) {
			arrayList.add(pointls);
		}
		// center first
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		if(cornExists(pointcf,tilesCenters)) {
			arrayList.add(pointcf);
		}
		// center second
		xpoint = x;
		ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		if(cornExists(pointcs,tilesCenters)) {
			arrayList.add(pointcs);
		}
		// right first
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		if(cornExists(pointrf,tilesCenters)) {
			arrayList.add(pointrf);
		}
		// right second
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		if(cornExists(pointrs,tilesCenters)) {
			arrayList.add(pointrs);
		}
		return arrayList;
	}
	
	// this is to check if the corn point exists
	private boolean cornExists(Point pointPossibleTile, ArrayList<Tile> tilePoints) {
		for(Tile tilepoint: tilePoints) {
			ArrayList<Point> pointList = new ArrayList<Point>();
            pointList.addAll(tilepoint.getCornerPoints());
			for(Point point: pointList) {
				if(point.getLocation().equals(pointPossibleTile)) {
					return true;
				}
			}
		}
		return false;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}
}
