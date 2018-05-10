package Controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;

import Model.Board;
import Model.Corner;
import Model.Dock;
import Model.Game;
import Model.Street;
import Model.Tile;
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
		arrayListIdResoucreType.addAll(board.getBoardDAOIdResoucreType(gameNumber));
		ArrayList<Integer> arrayListIdNumberChip = new ArrayList<Integer>();
		arrayListIdNumberChip.addAll(board.getBoardDAOIdNumberChip(gameNumber));
		int roberTileId = board.getBoardDAORobberTile(game.getGameID());
		int heightOfTile = 114;
		ArrayList<Point> docks = new ArrayList<Point>();
		docks.addAll(board.getBoardDAODocks());
		// this is to create the values that are going to get returend to the board
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Corner> corners = new ArrayList<Corner>();
		ArrayList<Street> streets = new ArrayList<Street>();
		// this loop will create all tiles with their tile points
			for (int i = 0; i < arrayListTileCenter.size(); i++) {
				// this to get the tile center point for the calculation of the other points
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
		board.setTiles(tiles);
		// this part is about creating the all the points also known as the corners of the board
		ArrayList<Point> arrayListLocation = new ArrayList<Point>();
		arrayListLocation.addAll(board.getBoardDAOCornerPointsFromDataBase());
		// this loop will create all corners
			for(int i =0; i<arrayListLocation.size();i++) {
				Point cornPoint = new Point();
				cornPoint.setLocation(arrayListLocation.get(i));
				Corner corner = new Corner();
				corner.setPoint(cornPoint);
				corner.setTilePoints(returnTilesCenters(corner.getPoint(),tiles));
				corner.setLinePoints(returnCorners(corner.getPoint(),tiles));
				corner.setInGamePoint(returnInGamePoint(corner.getPoint(),tiles));
				corner.setInGameTilePoints(returnInGameTilePoints(corner.getPoint(),tiles));
//				corner.setInGameLinePoints(returnInGameStreetPoints(corner.getInGamePoint(),tiles,heightOfTile));
				corner.setDock(comparePointToDockPoints(docks,corner.getPoint()));
				corners.add(corner);
			}
			board.setCorners(corners);
		//This will add Cities and Towns to the Corners	
			updateCitiesAndTowns();
		// this loop will create the Streets
			for(Corner corner: corners) {
				ArrayList<Street> newStreets = createStreet(corners, streets, corner);
				if(newStreets!=null) {
					streets.addAll(newStreets);
				}
			}
		board.setStreets(streets);
		updateStreets();
		board.setDocks(returnDocks(corners));
		System.out.println();
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
			int i =0;
			for(Point point: tileCornerPoints) {
				
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
	// this returns the inGameStreetPoints
//	private ArrayList<Point> returnInGameStreetPoints(Point inGamePoint,ArrayList<Tile> tiles,int h){
//		ArrayList<Point> arrayListInGamePoints = new ArrayList<Point>();
//		double a;
//		for (int i = 0; i < 6; i++) {
//			a = Math.PI / 3.0 * i;
//			Point point = new Point((int) (Math.round((int)inGamePoint.getX() + Math.sin(a) * h)), (int) (Math.round((int)inGamePoint.getY() + Math.cos(a) * h)));
//			for(Tile tile: tiles){
//				ArrayList<Point> tileCornerPoints = new ArrayList<Point>();
//				tileCornerPoints.addAll(tile.getInGameCornerPoints());
//				for(Point cornerPoint: tileCornerPoints) {
//				//	System.out.println("Gets in this for loop");////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				//	System.out.println("CornerPoint: "+cornerPoint.getLocation());
//				//	System.out.println("point: "+ point.getLocation());
//					if(cornerPoint.getX()==point.getX()&&cornerPoint.getY()==point.getY()) {
//						arrayListInGamePoints.add(point);
//				//		System.out.println("Gets in this if");////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//					}
//				}
//			}
//		}
//		if(arrayListInGamePoints.size()!=0) {
//			return arrayListInGamePoints;
//		}else {
//			return null;
//		}
//	}
	private ArrayList<Street> createStreet(ArrayList<Corner> corners,ArrayList<Street> streets, Corner corner) {
		ArrayList<Street> newStreets = new ArrayList<Street>();
		ArrayList<Point> cornerStreetPoints = new ArrayList<Point>();
		// this will add all linePoints of the corner
		cornerStreetPoints.addAll(corner.getLinePoints());
		// this will look at all corners in the board
		for(Corner otherCorner: corners) {
			// this will match corner with the cornerStreet point of corner
			for(Point cornerStreetPoint: cornerStreetPoints) {
				// this will look if there is a match between the point and the street point
				if(otherCorner.getPoint().getX()==cornerStreetPoint.getX()&&otherCorner.getPoint().getY()==cornerStreetPoint.getY()) {
					boolean match = false;
					// this will search in all streets if this combination of corners already exists 
					for(Street street: streets) {
						// if this compare is true it means that the combination of these two corners already exists in the street ArrayList
						if(street.compareIfCornersIsInLine(corner, otherCorner)==true) {
							match = true;
						}
					}
					if(match != true) {
						Street newStreet = new Street();
						newStreet.setCorner(corner);
						newStreet.setCorner(otherCorner);
						newStreets.add(newStreet);
					}
				}
			}
		}
		if(newStreets.size()==0) {
			return null;
		}else {
			return newStreets;
		}
	}
	
	private boolean comparePointToDockPoints(ArrayList<Point> docks,Point point) {
		for(Point dockPoint: docks) {
			if(dockPoint.getX()==point.getX()&&dockPoint.getY()==point.getY()) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Dock> returnDocks(ArrayList<Corner> corners){
		ArrayList<Dock> docks = new ArrayList<Dock>();
		for(Corner corner: corners) {
			int x = (int)corner.getPoint().getX();
			int y = (int)corner.getPoint().getY();
			for(Corner secondCorner: corners) {
				int sx = (int)secondCorner.getPoint().getX();
				int sy = (int)secondCorner.getPoint().getY();
				if(x==2&&y==2&&sx==2&&sy==3) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()/2, (pointCorner.getY()+pointSecondCorner.getY())/2);
					dock.setDockPoint(point);
					dock.setType("B");
					docks.add(dock);
				}else if(x==2&&y==5&&sx==2&&sy==6) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()/2, (pointCorner.getY()+pointSecondCorner.getY())/2);
					dock.setDockPoint(point);
					dock.setType("H");
					docks.add(dock);
				}else if(x==3&&y==8&&sx==4&&sy==9) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*1.12, (pointCorner.getY()+pointSecondCorner.getY())*0.25);
					dock.setDockPoint(point);
					dock.setType("3:1");
					docks.add(dock);
				}else if(x==6&&y==10&&sx==7&&sy==10) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*1.15, (pointCorner.getY()+pointSecondCorner.getY())*0.25);
					dock.setDockPoint(point);
					dock.setType("G");
					docks.add(dock);
				}else if(x==9&&y==10&&sx==10&&sy==10) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*1.09, (pointCorner.getY()+pointSecondCorner.getY())*0.42);
					dock.setDockPoint(point);
					dock.setType("E");
					docks.add(dock);
				}else if(x==11&&y==9&&sx==11&&sy==8) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*1.02, (pointCorner.getY()+pointSecondCorner.getY())/2);
					dock.setDockPoint(point);
					dock.setType("3:1");
					docks.add(dock);
				}else if(x==10&&y==6&&sx==9&&sy==5) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*0.97, (pointCorner.getY()+pointSecondCorner.getY())*0.52);
					dock.setDockPoint(point);
					dock.setType("W");
					docks.add(dock);
				}else if(x==7&&y==3&&sx==6&&sy==2) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*0.97, (pointCorner.getY()+pointSecondCorner.getY())*0.52);
					dock.setDockPoint(point);
					dock.setType("3:1");
					docks.add(dock);
				}else if(x==4&&y==1&&sx==3&&sy==1) {
					Dock dock = new Dock();
					dock.setCornerPoint(corner);
					dock.setCornerPoint(secondCorner);
					Point point = new Point();
					Point pointCorner = corner.getInGamePoint();
					Point pointSecondCorner = secondCorner.getInGamePoint();
					point.setLocation(pointCorner.getX()*0.8, (pointCorner.getY()+pointSecondCorner.getY())*0.52);
					dock.setDockPoint(point);
					dock.setType("3:1");
					docks.add(dock);
				}
			}
		}
		if(docks.size()==0) {
			return null;
		}else {
			return docks;
		}
	}
	
	public ArrayList<Point> getBoughtCity(int gameID){
		return board.getBoughtCity(gameID);
	}
	
	public ArrayList<Point> getBoughtTown(int gameID){
		return board.getBoughtTown(gameID);
	}
	
	public ArrayList<Integer> getBoughtPlayerID(int gameID){
		return board.getBoughtPlayerID(gameID);
	}
	
	public ArrayList<Tile> getTiles(){
		return board.getTiles();
	}
	
	public void updateCitiesAndTowns() {
		// @Ruben Look if this is like you would like it to be done?
		int gameID = game.getGameID();
		ArrayList<Corner> corners = board.getCorners();
		ArrayList<Corner> cities = board.getBoadDAOGetCities(gameID);
		ArrayList<Corner> towns = board.getBoadDAOGetTowns(gameID);
		
		for(Corner conrer: corners) {
			for(Corner cornerTown: towns) {
				if(conrer.getPoint().equals(cornerTown.getPoint())) {
					conrer.setTown(true);
					conrer.setPlayerId(cornerTown.getPlayerId());
				}
			}
			for(Corner cornerCity: cities) {
				if(conrer.getPoint().equals(cornerCity.getPoint())) {
					conrer.setTown(false);
					conrer.setCity(true);
					conrer.setPlayerId(cornerCity.getPlayerId());
				}
			}
		}
	}
	public void updateRobber() {
		ArrayList<Tile> tiles = board.getTiles();
		int roberTileId = board.getBoardDAORobberTile(game.getGameID());
		for(Tile tile: tiles) {
			tile.setRobber(hasRobber(tile.getTileID(),roberTileId));
		}
	}
	public void updateStreets() {
		// @Ruben Look if this is like you would like it to be done?
		int gameID = game.getGameID();
		ArrayList<Street> streets = board.getStreets();
		ArrayList<Street> newStreets = board.getBoardDAOGetStreets(gameID);
		for(Street street: streets) {
			for(Street newStreet: newStreets) {
				if((street.getCorner(0).getPoint().equals(newStreet.getCorner(0).getPoint())) && (street.getCorner(1).getPoint().equals(newStreet.getCorner(1).getPoint()))
						||
				(street.getCorner(0).getPoint().equals(newStreet.getCorner(1).getPoint())) && (street.getCorner(1).getPoint().equals(newStreet.getCorner(0).getPoint()))) {
					street.setPlayer(newStreet.getPlayer());
				}
			}
		}
	}
}
