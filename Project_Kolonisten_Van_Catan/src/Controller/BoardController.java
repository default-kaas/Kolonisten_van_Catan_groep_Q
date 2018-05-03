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
		ArrayList<Integer> arrayListIdTile = new ArrayList<Integer>();
		arrayListIdTile.addAll(board.getBoardDAOIDTile(gameNumber));
		ArrayList<Point> arrayListTileCenter = new ArrayList<Point>();
		arrayListTileCenter.addAll(board.getBoardDAOTilePointsFromDataBase(gameNumber));
		ArrayList<Character> arrayListIdResoucreType = new ArrayList<Character>();
		arrayListIdResoucreType.addAll(board.getBoardDOAIdResoucreType(gameNumber));
		ArrayList<Integer> arrayListIdNumberChip = new ArrayList<Integer>();
		arrayListIdNumberChip.addAll(board.getBoardDOAIdNumberChip(gameNumber));
		int roberTileId = board.getBoardDOARobberTile(game.getGameID());
		int heightOfTile = 114;
		// this is to create the values that are going to get returend to the board
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Corner> corners = new ArrayList<Corner>();
		// this loop will create all tiles with their tile points
			for (int i = 0; i < arrayListTileCenter.size(); i++) {
				// this to get the tile centerpoint for the calculation for the other points
				Point tileCenter = new Point();
				tileCenter.setLocation(arrayListTileCenter.get(i));
				Tile tile = new Tile();
				tile.setTileID(arrayListIdTile.get(i));
				tile.setCenterPoint(tileCenter);
				tile.setIdResourceType(arrayListIdResoucreType.get(i));
				tile.setIdNumberChip(arrayListIdNumberChip.get(i));
				tile.setCornerPoints(returnTileCornPoints(tile.getCenterPoint()));
				tile.setRobber(hasRobber(tile.getTileID(),roberTileId));
				tile.setInGameCenterPoint(returnInGameCenterPointTileInGame(tile.getTileID()));
				tile.setInGameCornerPoints(returnInGameCornerPointsOfTile(tile.getInGameCenterPoint(),heightOfTile));
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
				corner.setInGamePoint(returnInGamePoint(corner.getPoint(),tiles));
				//corner.setInGameTilePoints();
				//corner.setInGameLinePoints();
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
		// center bottom
		int xpoint = x;
		int ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		arrayList.add(pointcs);
		// right bottom
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		arrayList.add(pointrs);		
		// right top
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		arrayList.add(pointrf);
		// center top
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		arrayList.add(pointcf);
		// left top
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		arrayList.add(pointls);	
		//left bottom
		xpoint = x - 1;
		ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		arrayList.add(pointlf);
		return arrayList;
	}
	
	// this is to create the tile center points that surround the corner
	private ArrayList<Point> returnTilesCenters(Point cornerPoint, ArrayList<Tile> tilesCenters){
		ArrayList<Point> arrayList = new ArrayList<Point>();
		int x = (int) cornerPoint.getX();
		int y = (int) cornerPoint.getY();
		// center bottom
		int xpoint = x;
		int ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointcs,tilesCenters)) {
		arrayList.add(pointcs);
		}
		// right bottom
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointrs,tilesCenters)) {
		arrayList.add(pointrs);
		}
		// right top
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointrf,tilesCenters)) {
		arrayList.add(pointrf);
		}
		// center top
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointcf,tilesCenters)) {
		arrayList.add(pointcf);
		}
		// left top
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointls,tilesCenters)) {
		arrayList.add(pointls);
		}
		//left bottom
		xpoint = x - 1;
		ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		if(tileCenterExists(pointlf,tilesCenters)) {
			arrayList.add(pointlf);
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
		// center bottom
		int	xpoint = x;
		int ypoint = y - 1;
		Point pointcs = new Point();
		pointcs.setLocation(xpoint, ypoint);
		if(cornExists(pointcs,tilesCenters)) {
		arrayList.add(pointcs);
		}
		// right bottom
		xpoint = x + 1;
		ypoint = y;
		Point pointrs = new Point();
		pointrs.setLocation(xpoint, ypoint);
		if(cornExists(pointrs,tilesCenters)) {
		arrayList.add(pointrs);
		}
		// right top
		xpoint = x + 1;
		ypoint = y + 1;
		Point pointrf = new Point();
		pointrf.setLocation(xpoint, ypoint);
		if(cornExists(pointrf,tilesCenters)) {
		arrayList.add(pointrf);
		}
		// center top
		xpoint = x;
		ypoint = y + 1;
		Point pointcf = new Point();
		pointcf.setLocation(xpoint, ypoint);
		if(cornExists(pointcf,tilesCenters)) {
		arrayList.add(pointcf);
		}
		//left top
		xpoint = x - 1;
		ypoint = y - 1;
		Point pointlf = new Point();
		pointlf.setLocation(xpoint, ypoint);
		if(cornExists(pointlf,tilesCenters)) {
			arrayList.add(pointlf);
		}
		// left bottom
		xpoint = x - 1;
		ypoint = y;
		Point pointls = new Point();
		pointls.setLocation(xpoint, ypoint);
		if(cornExists(pointls,tilesCenters)) {
			arrayList.add(pointls);
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
	// this checks of the robber is on this tile
	private boolean hasRobber(int tileID, int robberTileID) {
		if(tileID == robberTileID) {
			return true;
		}else {
			return false;
		}
	}
	// this returns the boardPanel
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}
	// this returns the in game centerPoint of a tile
	private Point returnInGameCenterPointTileInGame(int tileNumber) {
		Point point = new Point();
		int x = 0;
		int defaultx = 140;
		int defaulty = 517; /*Temporary solution */
		for(int i=0;i<tileNumber;i++) {
			switch (i) {
			case 3:
			case 7:
				x = 0;
				defaultx += 100;
				defaulty += 174;
				break;
			case 12:
			case 16:
				x = 0;
				defaultx += 200;
				break;
			}
			switch(i) {
			case 0:case 3:case 7:case 12:case 16: break;
			default: x++;
			}
		}
		int middleX = defaultx + x * 100;
		int middleY = defaulty - x * 174;
		point.setLocation(middleX, middleY);
		return point;
	}
	// this return the in game game cornerPoints
	private ArrayList<Point> returnInGameCornerPointsOfTile(Point centerPoint, int h) {
		ArrayList<Point> arrayListInGamePoints = new ArrayList<Point>();
		double a;
		for (int i = 0; i < 6; i++) {
			a = Math.PI / 3.0 * i;
			Point point = new Point((int) (Math.round((int)centerPoint.getX() + Math.sin(a) * h)), (int) (Math.round((int)centerPoint.getY() + Math.cos(a) * h)));
			arrayListInGamePoints.add(point);
		}
		return arrayListInGamePoints;
	}
	// this returns the inGamePoint of corner 
	private Point returnInGamePoint(Point databasePoint,ArrayList<Tile> tiles) {
		ArrayList<Point> inGameCornPoints = new ArrayList<Point>();
		int iteration = -1;
		for(Tile tile: tiles) {
			ArrayList<Point> tileCornerPoints = new ArrayList<Point>();
			tileCornerPoints.addAll(tile.getCornerPoints());
			boolean matchIsFound = false;
			int matchI = -1;
			for(Point point: tileCornerPoints) {
				int i =0;
				if(point.getLocation()==databasePoint.getLocation()) {
					matchIsFound = true;
					matchI = i;
					break;
				}else {
					i++;
				}
			}
			if(matchIsFound){
				inGameCornPoints.addAll(tile.getInGameCornerPoints());
				iteration = matchI;
				break;
			}
		}
		Point inGamePoint = new Point();
		inGamePoint = inGameCornPoints.get(iteration);
		return inGamePoint;
	}
}
