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
				// left first 
				Point point = new Point();
				int xpoint = x - 1;
				int ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				
				// left second
				xpoint = x - 1;
				ypoint = y;
				point.setLocation(xpoint, ypoint);
				
				// center first
				xpoint = x;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				
				// center second
				xpoint = x;
				ypoint = y - 1;
				point.setLocation(xpoint, ypoint);
				

				// right first
				xpoint = x + 1;
				ypoint = y + 1;
				point.setLocation(xpoint, ypoint);
				
				// right second
				xpoint = x + 1;
				ypoint = y ;
				point.setLocation(xpoint, ypoint);
				
			}
		}
	}
}
