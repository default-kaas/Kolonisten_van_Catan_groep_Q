package Database;

import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Corner;
import Model.Street;

public class BoardDAO {
	private Connection connection;

	public BoardDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<Integer> getIDTile(int game) {
		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idtegel FROM tegel WHERE idspel =" + game + " ORDER BY idtegel ");
			while (rs.next()) {
				int idTile = rs.getInt("idtegel");
				arrayList.add(idTile);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Point> getTilePointsFromDataBase(int game) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y,idgetalfiche FROM tegel WHERE idspel =" + game + " ORDER BY idtegel ");
			while (rs.next()) {
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Point point = new Point(x, y);
				arrayList.add(point);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Character> getIdResoucreType(int game) {
		try {
			ArrayList<Character> arrayList = new ArrayList<Character>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idgrondstofsoort FROM tegel WHERE idspel =" + game + " ORDER BY idtegel ");
			while (rs.next()) {
				String idRS = rs.getString("idgrondstofsoort");
				char idR = idRS.charAt(0);
				arrayList.add(idR);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Integer> getIdNumberChip(int game) {
		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT idgetalfiche FROM tegel WHERE idspel =" + game + " ORDER BY idtegel ");
			while (rs.next()) {
				int idGetalfiche = rs.getInt("idgetalfiche");
				arrayList.add(switchForIdNumberChip(idGetalfiche));
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	private int switchForIdNumberChip(int idNumber) {
		switch (idNumber) {
		case 1:
			return 2;
		case 2:
		case 3:
			return 3;
		case 4:
		case 5:
			return 4;
		case 6:
		case 7:
			return 5;
		case 8:
		case 9:
			return 6;
		case 10:
		case 11:
			return 8;
		case 12:
		case 13:
			return 9;
		case 14:
		case 15:
			return 10;
		case 16:
		case 17:
			return 11;
		case 18:
			return 12;
		default:
			return 0;
		}
	}

	public ArrayList<Point> getLocationsFromDataBase() {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"SELECT x,y FROM locatie WHERE NOT EXISTS (SELECT x,y FROM tegel where locatie.x = tegel.x AND  locatie.y = tegel.y) order by x");
			while (rs.next()) {
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Point point = new Point(x, y);
				arrayList.add(point);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			;
			return null;
		}
	}

	public int getRobberTile(int game) {
		try {
			// The cheese way of solving a problem.
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT struikrover_idtegel FROM spel WHERE idspel =" + game);
			rs.next();
			int idTile = rs.getInt("struikrover_idtegel");
			return idTile;
		} catch (SQLException e) {
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
			while (rs.next()) {
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Point point = new Point(x, y);
				arrayList.add(point);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			;
			return null;
		}
	}

	public ArrayList<Point> getBoughtCityLocation(int gameID) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'c%' ");
			while (rs.next()) {
				int x = rs.getInt("x_van");
				int y = rs.getInt("y_van");
				Point point = new Point(x, y);
				arrayList.add(point);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			;
			return null;
		}
	}

	public ArrayList<Point> getBoughtTownLocation(int gameID) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'd%' ");
			while (rs.next()) {
				int x = rs.getInt("x_van");
				int y = rs.getInt("y_van");
				Point point = new Point(x, y);
				arrayList.add(point);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			;
			return null;
		}
	}

	public ArrayList<Integer> getBoughtPlayerID(int gameID) {
		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select spelerstuk.idspeler,spelerstuk.x_van,spelerstuk.y_van from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel ="
							+ gameID + " and spelerstuk.idstuk LIKE 'c%'");
			while (rs.next()) {
				int idTile = rs.getInt("idspeler");
				arrayList.add(idTile);
			}
			return arrayList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Corner> getTowns(int gameID){
		try {
			ArrayList<Corner> townCorners = new ArrayList<Corner>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van,speler.idspeler from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'd%' ");
			while (rs.next()) {
				Corner corner = new Corner();
				int x = rs.getInt("x_van");
				int y = rs.getInt("y_van");
				Point point = new Point(x, y);
				corner.setPoint(point);
				corner.setPlayerId(rs.getInt("speler.idspeler"));
				townCorners.add(corner);
			}
			return townCorners;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Corner> getCities(int gameID){
		try {
			ArrayList<Corner> cityCorners = new ArrayList<Corner>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van,speler.idspeler from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'c%' ");
			while (rs.next()) {
				Corner corner = new Corner();
				int x = rs.getInt("x_van");
				int y = rs.getInt("y_van");
				Point point = new Point(x, y);
				corner.setPoint(point);
				corner.setPlayerId(rs.getInt("speler.idspeler"));
				cityCorners.add(corner);
			}
			return cityCorners;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Street> getStreets(int gameID){
		try {
			ArrayList<Street> streets = new ArrayList<Street>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(
					"select DISTINCT(x_van),y_van,x_naar,y_naar,speler.idspeler from spelerstuk join speler on speler.idspeler = spelerstuk.idspeler join spel on spel.idspel = speler.idspel where x_van is not null and y_van is not null and spel.idspel = "
							+ gameID + " and spelerstuk.idstuk LIKE 'r%' ");
			while (rs.next()) {
				ArrayList<Corner> cornerOfStreet = new ArrayList<Corner>();
				Street street = new Street();
				Corner corner1 = new Corner();
				int x1 = rs.getInt("x_van");
				int y1 = rs.getInt("y_van");
				Point point1 = new Point(x1, y1);
				corner1.setPoint(point1);
				cornerOfStreet.add(corner1);
				Corner corner2 = new Corner();
				int x2 = rs.getInt("x_naar");
				int y2 = rs.getInt("y_naar");
				Point point2 = new Point(x2, y2);
				corner2.setPoint(point2);
				cornerOfStreet.add(corner2);
				street.setPlayer(rs.getInt("speler.idspeler"));
				street.setCorners(cornerOfStreet);
				streets.add(street);
			}
			return streets;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
