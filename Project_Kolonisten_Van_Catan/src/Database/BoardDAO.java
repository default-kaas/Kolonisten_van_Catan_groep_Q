package Database;

import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDAO {
	private Connection connection;

	
	public BoardDAO(Connection connection) {
		this.connection = connection;
	}
	
	public ArrayList<Integer> getIDTile(int game){
		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idtegel FROM tegel WHERE idspel ="+ game +" ORDER BY idtegel ");
			while(rs.next()) {
				int idTile =rs.getInt("idtegel");
				arrayList.add(idTile);
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Point> getTilePointsFromDataBase(int game) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y,idgetalfiche FROM tegel WHERE idspel ="+ game +" ORDER BY idtegel ");
			while(rs.next()) {
				int x =rs.getInt("x");
				int y =rs.getInt("y");
				Point point = new Point(x,y);
				arrayList.add(point);
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Character> getIdResoucreType(int game){
		try {
			ArrayList<Character> arrayList = new ArrayList<Character>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idgrondstofsoort FROM tegel WHERE idspel ="+ game +" ORDER BY idtegel ");
			while(rs.next()) {
				String idRS = rs.getString("idgrondstofsoort");
				char idR = idRS.charAt(0);
				arrayList.add(idR);
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Integer> getIdNumberChip(int game){
		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idgetalfiche FROM tegel WHERE idspel ="+ game +" ORDER BY idtegel ");
			while(rs.next()) {
				int idGetalfiche =rs.getInt("idgetalfiche");
				arrayList.add(switchForIdNumberChip(idGetalfiche));
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	private int switchForIdNumberChip(int idNumber) {
		switch(idNumber) {
			case 1: return 2;
			case 2: case 3: return 3;
			case 4: case 5: return 4;
			case 6: case 7: return 5;
			case 8: case 9: return 6;
			case 10: case 11: return 8;
			case 12: case 13: return 9;
			case 14: case 15: return 10;
			case 16: case 17: return 11;
			case 18: return 12;
			default: return 0;
		}
	}
	
	public ArrayList<Point> getLocationsFromDataBase() {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y FROM locatie WHERE NOT EXISTS (SELECT x,y FROM tegel where locatie.x = tegel.x AND  locatie.y = tegel.y) order by x");
			while(rs.next()) {
				int x =rs.getInt("x");
				int y =rs.getInt("y");
				Point point = new Point(x,y);
				arrayList.add(point);
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);;
			return null;
		}
	}
	
	public int getRobberTile(int game) {
		try {
			//The cheese way of solving a problem.
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT struikrover_idtegel FROM spel WHERE idspel ="+game);
			rs.next();
			int idTile = rs.getInt("struikrover_idtegel");
			return idTile;
		}catch(SQLException e) {
			System.out.println(e);
			return 20;
		}
		
	}
	
	public ArrayList<Point> getDocksFromDataBase() {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y FROM locatie WHERE haven = 1");
			while(rs.next()) {
				int x =rs.getInt("x");
				int y =rs.getInt("y");
				Point point = new Point(x,y);
				arrayList.add(point);
			}
			return arrayList;
		}catch(SQLException e) {
			System.out.println(e);;
			return null;
		}
	}
}
