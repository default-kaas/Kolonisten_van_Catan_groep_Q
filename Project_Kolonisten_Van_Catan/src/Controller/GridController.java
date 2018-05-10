package Controller;

import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

import Model.Board;
import Model.Corner;
import Model.Game;
import Model.Street;
import View.GridPanel;

public class GridController {
	private GridPanel gridPanel;
	private int x;
	private int y;
	private int x1; // x locatie eerste hoekpunt
	private int y1; // y locatie eerste hoekpunt
	private int x2; // x locatie tweede hoekpunt
	private int y2; // y locatie tweede hoekpunt
	private Game gameNr;
	private Connection db_conn;
	private Board myBoard;
	private Street myStreet;

	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();
		myBoard = new Board(gameNr, db_conn);
		myStreet = new Street();
	}

	public void checkStreets() {
		ArrayList<Corner> streets = myStreet.getCornerPoints();
		ArrayList<Point> pointsStreet = new ArrayList<Point>();
		
		for(Corner street:streets) {
			Point StreetCorner = street.getInGamePoint();
			pointsStreet.add(StreetCorner);
		}
		
		x1 = (int) pointsStreet.get(0).getX();
		y1 = (int) pointsStreet.get(0).getY();
		x2 = (int) pointsStreet.get(1).getX();
		y2 = (int) pointsStreet.get(1).getY();	
		int counter = 0;
		Point location;

		if (x1 == x2) {
			if (x > (x1 - 5) && x < (x2 + 5) && y > (y1 - 5) && y < y2 + 5) {
				location = new Point(x,y);
				counter++;
			}
		}
		else {
			double Dx;
			double Dy;
			int D;
			int W = 10;

			Dx = x2 - x1;
			Dy = y2 - y1;
			D = (int) Math.sqrt((Dx * Dx) + (Dy * Dy));
			Dx = (((0.5 * W) * Dx) / D);
			Dy = (((0.5 * W) * Dy) / D);

			double aX = x1 - Dy;
			double aY = y1 + Dx;
			double bX = x1 + Dy;
			double bY = x1 - Dy;
			double cX = x2 - Dy;
			double cY = y2 + Dx;
			double dX = x2 + Dx;
			double dY = y2 - Dx;

			int L = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
			int oppABP = (int) (0.5 * ((aX - x) * (bY - aY) - (aX - bX) * (y - aY)));
			int oppBCP = (int) (0.5 * ((cX - x) * (bY - cY) - (cX - bX) * (y - cY)));
			int oppCDP = (int) (0.5 * ((cX - x) * (dY - cY) - (cX - dX) * (y - cY)));
			int oppADP = (int) (0.5 * ((aX - x) * (dY - aY) - (aX - dX) * (y - aY)));

			if ((L * W) == (oppABP + oppBCP + oppCDP + oppADP) || oppABP == 0 || oppBCP == 0 || oppCDP == 0
					|| oppADP == 0) {
				location = new Point(x,y);
				counter++;
			}
		}
		
		if (counter == 1) {
			// build
		}
	}

	public void showStreets(int player) {
		ArrayList<Corner> streets = myStreet.getCornerPoints();
		boolean yourStreet = (myStreet.getPlayer() == player);
		if (x1 == x2) {
			// a (x1-5),y1
			// b (x1+5),y1
			// c (x2-5),y2
			// d (x2+5),y2
		} else {
			double Dx;
			double Dy;
			int D;
			int W = 10;

			Dx = x2 - x1;
			Dy = y2 - y1;
			D = (int) Math.sqrt((Dx * Dx) + (Dy * Dy));
			Dx = (((0.5 * W) * Dx) / D);
			Dy = (((0.5 * W) * Dy) / D);

			double aX = x1 - Dy;
			double aY = y1 + Dx;
			double bX = x1 + Dy;
			double bY = x1 - Dy;
			double cX = x2 - Dy;
			double cY = y2 + Dx;
			double dX = x2 + Dx;
			double dY = y2 - Dx;
		}

		// g.setColor(kleur van speler)
		// maak transparant
		// g.fill
	}

	public void checkTowns() {
		ArrayList<Corner> allPoints = myBoard.getCorners();
		for (Corner corner : allPoints) {
			x1 = (int) corner.getInGamePoint().getX();
			y1 = (int) corner.getInGamePoint().getY();
			int r = 10;
			int counter = 0;
			Corner location;

			if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
				location = corner;
				counter++;
			}
			if (counter == 1) {
				// build
			}
		}
	}

	public void showTowns(int player) {
		ArrayList<Corner> allPoints = myBoard.getCorners();
		ArrayList<Corner> streets = myStreet.getCornerPoints();
		ArrayList<Corner> possibleTowns = new ArrayList<Corner>();

		for (Corner corner : allPoints) {
			boolean hasTown = corner.isTown();
			boolean hasCity = corner.isCity();
			boolean hasNeighbor = false;
			boolean connectedToYourStreet = false;

			for(Corner street:streets) {
				connectedToYourStreet = myStreet.compareIfCornersIsInLine(corner, street);
			}			

			if (!hasTown || !hasCity) {
				if (connectedToYourStreet) {
					if (!hasNeighbor) {
						possibleTowns.add(corner);
					}

				}

			}

		}
		// g.drawOval(x,y,w,h);
		// g.setColor(kleur van speler, transparantie)
		// g.fill
	}

	public void showCities(int player) {
		Corner myCorner = new Corner();
		ArrayList<Corner> allPoints = myBoard.getCorners();
		ArrayList<Corner> yourTowns = new ArrayList<Corner>();

		for (Corner corner : allPoints) {
			Boolean yourTown = corner.isTown();
			if (yourTown) {
				if (player == corner.getPlayerId())
					yourTowns.add(corner);
			}
		}

		// g.drawOval(x,y,w,h);
		// g.setColor(kleur van speler, transparantie)
		// g.fill
	}

}
