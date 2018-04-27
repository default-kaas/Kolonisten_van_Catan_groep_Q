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
	
	public ArrayList<Point> getTilePointsFromDataBase(int game) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y FROM tegel WHERE idspel ="+ game +" ");
			for(int i=0; i<19;i++) {
				rs.next();
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
	
	public ArrayList<Point> getLocationsFromDataBase(int game) {
		try {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT x,y FROM locatie");
			for(int i=0; i<73;i++) {
				rs.next();
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
}
