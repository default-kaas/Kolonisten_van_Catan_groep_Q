package Model;

import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

import Database.BoardDAO;

public class Board {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	private ArrayList<Street> streets = new ArrayList<Street>();
	private ArrayList<Dock> docks = new ArrayList<Dock>();
	
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

	public ArrayList<Integer> getBoardDAOIDTile(int gameNumber){
		return boardDOA.getIDTile(gameNumber);
	}
	
	public ArrayList<Point> getBoardDAOTilePointsFromDataBase(int gameNumber){
		return boardDOA.getTilePointsFromDataBase(gameNumber);
	}
	
	public ArrayList<Point> getBoardDAOCornerPointsFromDataBase(){
		return boardDOA.getLocationsFromDataBase();
	}
	
	public ArrayList<Character> getBoardDAOIdResoucreType(int gameNumber){
		return boardDOA.getIdResoucreType(gameNumber);
	}
	
	public ArrayList<Integer> getBoardDAOIdNumberChip(int gameNumber){
		return boardDOA.getIdNumberChip(gameNumber);
	}
	
	public int getBoardDAORobberTile(int gameNumber) {
		return boardDOA.getRobberTile(gameNumber);
	}
	
	public ArrayList<Point> getBoardDAODocks(){
		return boardDOA.getDocksFromDataBase();
	}
	
	public ArrayList<Street> getStreets() {
		return streets;
	}

	public void setStreets(ArrayList<Street> streets) {
		this.streets = streets;
	}

	public ArrayList<Dock> getDocks() {
		return docks;
	}

	public void setDocks(ArrayList<Dock> docks) {
		this.docks = docks;
	}
	
	public ArrayList<Point> getBoughtCity(int gameID){
		return boardDOA.getBoughtCityLocation(gameID);
	}
	
	public ArrayList<Point> getBoughtTown(int gameID){
		return boardDOA.getBoughtTownLocation(gameID);
	}
	
	
	public ArrayList<Integer> getBoughtPlayerID(int gameID){
		return boardDOA.getBoughtPlayerID(gameID);
	}
	
	public ArrayList<Corner> getBoadDAOGetTowns(int gameID){
		return boardDOA.getTowns(gameID);
	}
	
	public ArrayList<Corner> getBoadDAOGetCities(int gameID){
		return boardDOA.getCities(gameID);
	}
	
	public ArrayList<Street> getBoardDAOGetStreets(int gameID){
		return boardDOA.getStreets(gameID);
	}
}
