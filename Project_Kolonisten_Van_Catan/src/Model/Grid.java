package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Grid {
	private HashMap<RealPoint, DataBasePointRealPoint> pointAndAdjacentPoints = new HashMap<RealPoint, DataBasePointRealPoint>();

	public void saveData() {
		// Excute sql querie
		for (int i = 1; i < 20; i++) {
			// .next for the sql data object
			Point tileCenter = new Point();
			tileCenter.setLocation(3 /** X */
					, 4/** y */
			);
			int x = (int) tileCenter.getX();
			int y = (int) tileCenter.getY();
			for (int points = 0; points < 6; points++) {
				// left first x2 y4
				RealPoint realPoint = new RealPoint();
				
				
				Point point = new Point();
				int xpoint = x - 1;
				int ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey( point) != true) {

				}
				// left second
				xpoint = x - 1;
				ypoint = y;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey(point) != true) {

				}
				// center first
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey(point) != true) {

				}
				// center second
				xpoint = x;
				ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey(point) != true) {

				}

				// right first
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey(point) != true) {

				}
				// right second
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				if (pointAndAdjacentPoints.containsKey(point) != true) {

				}
			}
		}
	}

	// ultra aids methode
	public void switchArray(Point point) {

		int x = (int) point.getX();
		int y = (int) point.getY();
		String Sx = Integer.toString(x);
		String Sy = Integer.toString(y);
		String Sc = Sx + Sy;
		int pointValue = Integer.parseInt(Sc);
		Point point1 = new Point();
		Point point2 = new Point();
		Point point3 = new Point();
		
		ArrayList<RealPoint> arrayList = new ArrayList<RealPoint>();

		switch (pointValue) {
		case 13:
			point1.setLocation(1, 4);
			point2.setLocation(2, 3);
			break;
		case 14:
			point1.setLocation(1, 3);
			point2.setLocation(2, 5);
			break;
		case 22:
			point1.setLocation(2, 3);
			point2.setLocation(3, 2);
			break;
		case 23:
			point1.setLocation(1, 3);
			point2.setLocation(2, 2);
			point3.setLocation(3, 4);
			break;
		case 25:
			point1.setLocation(1, 4);
			point2.setLocation(2, 6);
			point3.setLocation(3, 5);
			break;
		case 26:
			point1.setLocation(2, 5);
			point2.setLocation(3, 7);
			break;
		case 31:
			point1.setLocation(3, 2);
			point2.setLocation(4, 1);
			break;
		case 32:
			point1.setLocation(2, 2);
			point2.setLocation(3, 1);
			point3.setLocation(4, 3);
			break;
		case 34:
			point1.setLocation(2, 3);
			point2.setLocation(3, 5);
			point3.setLocation(4, 4);
			break;
		case 35:
			point1.setLocation(2, 5);
			point2.setLocation(3, 4);
			point3.setLocation(4, 6);
			break;
		case 37:
			point1.setLocation(2, 6);
			point2.setLocation(3, 8);
			point3.setLocation(4, 7);
			break;
		case 38:
			point1.setLocation(3, 7);
			point2.setLocation(4, 9);
			break;
		case 41:
			point1.setLocation(3, 1);
			point2.setLocation(5, 2);
			break;
		case 43:
			point1.setLocation(3, 2);
			point2.setLocation(4, 4);
			point3.setLocation(5, 3);
			break;
		case 44:
			point1.setLocation(3, 4);
			point2.setLocation(4, 3);
			point3.setLocation(5, 5);
			break;
		case 46:
			point1.setLocation(3, 5);
			point2.setLocation(4, 7);
			point3.setLocation(5, 6);
			break;
		case 47:
			point1.setLocation(3, 7);
			point2.setLocation(4, 6);
			point3.setLocation(5, 8);
			break;
		case 49:
			point1.setLocation(3, 8);
			point2.setLocation(5, 9);
			break;
		case 52:
			point1.setLocation(4, 1);
			point2.setLocation(5, 3);
			point3.setLocation(6, 2);
			break;
		case 53:
			point1.setLocation(4, 3);
			point2.setLocation(5, 2);
			point3.setLocation(6, 4);
			break;
		case 55:
			point1.setLocation(4, 4);
			point2.setLocation(5, 6);
			point3.setLocation(6, 5);
			break;
		case 56:
			point1.setLocation(4, 6);
			point2.setLocation(5, 5);
			point3.setLocation(6, 7);
			break;
		case 58:
			point1.setLocation(4, 7);
			point2.setLocation(5, 9);
			point3.setLocation(6, 8);
			break;
		case 59:
			point1.setLocation(4, 9);
			point2.setLocation(5, 8);
			point3.setLocation(6, 10);
			break;
		case 62:
			point1.setLocation(5, 2);
			point2.setLocation(7, 3);
			break;
		case 64:
			point1.setLocation(5, 3);
			point2.setLocation(6, 5);
			point3.setLocation(7, 4);
			break;
		case 65:
			point1.setLocation(5, 5);
			point2.setLocation(6, 4);
			point3.setLocation(7, 6);
			break;
		case 67:
			point1.setLocation(5, 6);
			point2.setLocation(6, 8);
			point3.setLocation(7, 7);
			break;
		case 68:
			point1.setLocation(5, 8);
			point2.setLocation(6, 7);
			point3.setLocation(7, 9);
			break;
		case 610:
			point1.setLocation(5, 9);
			point2.setLocation(7, 10);
			break;
		case 73:
			point1.setLocation(6, 2);
			point2.setLocation(7, 4);
			point3.setLocation(8, 3);
			break;
		case 74:
			point1.setLocation(6, 4);
			point2.setLocation(7, 3);
			point3.setLocation(8, 5);
			break;
		case 76:
			point1.setLocation(6, 5);
			point2.setLocation(7, 7);
			point3.setLocation(8, 6);
			break;
		case 77:
			point1.setLocation(6, 7);
			point2.setLocation(7, 6);
			point3.setLocation(8, 8);
			break;
		case 79:
			point1.setLocation(6, 8);
			point2.setLocation(7, 10);
			point3.setLocation(8, 9);
			break;
		case 710:
			point1.setLocation(6, 10);
			point2.setLocation(7, 9);
			point3.setLocation(8, 11);
			break;
		case 83:
			point1.setLocation(7, 3);
			point2.setLocation(9, 4);
			break;
		case 85:
			point1.setLocation(7, 4);
			point2.setLocation(8, 6);
			point3.setLocation(9, 5);
			break;
		case 86:
			point1.setLocation(7, 6);
			point2.setLocation(8, 5);
			point3.setLocation(9, 7);
			break;
		case 88:
			point1.setLocation(7, 7);
			point2.setLocation(8, 9);
			point3.setLocation(9, 8);
			break;
		case 89:
			point1.setLocation(7, 9);
			point2.setLocation(8, 8);
			point3.setLocation(9, 10);
			break;
		case 811:
			point1.setLocation(7, 10);
			point2.setLocation(9, 11);
			break;
		case 94:
			point1.setLocation(8, 3);
			point2.setLocation(9, 5);
			break;
		case 95:
			point1.setLocation(8, 5);
			point2.setLocation(9, 4);
			point3.setLocation(10, 6);
			break;
		case 97:
			point1.setLocation(8, 6);
			point2.setLocation(9, 8);
			point3.setLocation(10, 7);
			break;
		case 98:
			point1.setLocation(8, 8);
			point2.setLocation(9, 7);
			point3.setLocation(10, 9);
			break;
		case 910:
			point1.setLocation(8, 9);
			point2.setLocation(9, 11);
			point3.setLocation(10, 10);
			break;
		case 911:
			point1.setLocation(8, 11);
			point2.setLocation(9, 10);
			break;
		case 106:
			point1.setLocation(9, 5);
			point2.setLocation(10, 7);
			break;
		case 107:
			point1.setLocation(9, 7);
			point2.setLocation(10, 6);
			point3.setLocation(11, 8);
			break;
		case 109:
			point1.setLocation(9, 8);
			point2.setLocation(10, 10);
			point3.setLocation(11, 9);
			break;
		case 1010:
			point1.setLocation(9, 10);
			point2.setLocation(10, 9);
			break;
		case 118:
			point1.setLocation(10, 7);
			point2.setLocation(11, 9);
			break;
		case 119:
			point1.setLocation(10, 9);
			point2.setLocation(11, 8);
			break;
		}
	
	
	}
}
