package Controller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sound.sampled.Line;

import Model.Board;
import Model.Corner;
import Model.Game;
import Model.Tile;
import Model.Line;
import View.BoardPanel;

public class BoardController {
	private Game game;
	private Connection connection;
	private Board board;
	private BoardPanel boardPanel;
	private int height;
	
	public BoardController(Game game, Connection connection ) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) (screenSize.getHeight());
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
		ArrayList<Line> lines = new ArrayList<Line>();
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
		// this part is about creating the all the points also known as the corners of the board
		ArrayList<Point> arrayListLocation = new ArrayList<Point>();
		arrayListLocation.addAll(board.getBoardDAOCornerPointsFromDataBase(gameNumber));
		// this loop will create all corners
			for(int i =0; i<arrayListLocation.size();i++) {
				System.out.println(i);
				Point cornPoint = new Point();
				cornPoint.setLocation(arrayListLocation.get(i));
				Corner corner = new Corner();
				corner.setPoint(cornPoint);
				corner.setTilePoints(returnTilesCenters(corner.getPoint(),tiles));
				corner.setLinePoints(returnCorners(corner.getPoint(),tiles));
				corner.setInGamePoint(returnInGamePoint(corner.getPoint(),tiles));
				corner.setInGameTilePoints(returnInGameTilePoints(corner.getPoint(),tiles));
				corner.setInGameLinePoints(returnInGameLinePoints(corner.getInGamePoint(),tiles,heightOfTile));
				corners.add(corner);
			}
		// this loop wil create the lines
			for(Corner corner: corners) {
				
			//	System.out.println(corner.getPoint());////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//	System.out.println(corner.getInGameTilePoints());//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//	System.out.println(corner.getInGamePoint());//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//	System.out.println(corner.getInGameLinePoints());/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// get point
				// get line points
				// set corner object in line object
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
	
		int defaulty = (height / 2) - 23; /*Temporary solution */
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
		int iteration = 0;
		boolean matchIsFound = false;
		for(Tile tile: tiles) {
			ArrayList<Point> tileCornerPoints = new ArrayList<Point>();
			tileCornerPoints.addAll(tile.getCornerPoints());
			
			int matchI = -1;
			for(Point point: tileCornerPoints) {
				int i =0;
				if(point.getX()==databasePoint.getX()&&point.getY()==databasePoint.getY()) {
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
		if(matchIsFound) {
			Point inGamePoint = new Point();
			inGamePoint = inGameCornPoints.get(iteration);
			return inGamePoint;
		}else {
			return null;
		}
	}
	// this returns the inGameTilePoints 
	private ArrayList<Point> returnInGameTilePoints(Point databasePoint,ArrayList<Tile> tiles){
		ArrayList<Tile> matchTiles = new ArrayList<Tile>();
		for(Tile tile: tiles){
			ArrayList<Point> tileCornerPoints = new ArrayList<Point>();
			tileCornerPoints.addAll(tile.getCornerPoints());
			for(Point point: tileCornerPoints) {
				if(point.getX()==databasePoint.getX()&&point.getY()==databasePoint.getY()) {
					matchTiles.add(tile);
				}
			}
		}
		if(matchTiles.size()!=0) {
			ArrayList<Point> inGameTilePoints = new ArrayList<Point>();
			for(Tile tile: matchTiles) {
				inGameTilePoints.add(tile.getInGameCenterPoint());
			}
			return inGameTilePoints;
		}else {
			return null;
		}
	}
	// this returns the inGameLinePoints
	private ArrayList<Point> returnInGameLinePoints(Point inGamePoint,ArrayList<Tile> tiles,int h){
		ArrayList<Point> arrayListInGamePoints = new ArrayList<Point>();
		double a;
		for (int i = 0; i < 6; i++) {
			a = Math.PI / 3.0 * i;
			Point point = new Point((int) (Math.round((int)inGamePoint.getX() + Math.sin(a) * h)), (int) (Math.round((int)inGamePoint.getY() + Math.cos(a) * h)));
			for(Tile tile: tiles){
				ArrayList<Point> tileCornerPoints = new ArrayList<Point>();
				tileCornerPoints.addAll(tile.getInGameCornerPoints());
				for(Point cornerPoint: tileCornerPoints) {
				//	System.out.println("Gets in this for loop");////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//	System.out.println("CornerPoint: "+cornerPoint.getLocation());
				//	System.out.println("point: "+ point.getLocation());
					if(cornerPoint.getX()==point.getX()&&cornerPoint.getY()==point.getY()) {
						arrayListInGamePoints.add(point);
				//		System.out.println("Gets in this if");////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
				}
			}
		}
		if(arrayListInGamePoints.size()!=0) {
			return arrayListInGamePoints;
		}else {
			return null;
		}
	}
	private ArrayList<Line> createLine(ArrayList<Corner> corners,ArrayList<Line> lines, Corner corner) {
		ArrayList<Line> newLines = new ArrayList<Line>();
		ArrayList<Point> cornerLinePoints = new ArrayList<Point>();
		cornerLinePoints.addAll(corner.getLinePoints());
		for(Corner otherCorner: corners) {
			Line line = new Line();
			
		}
		return null;
	}
}
