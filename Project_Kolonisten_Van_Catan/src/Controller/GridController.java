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
	private double Dx;
	private double Dy;
	private int D;
	private int W = 10;
	private double aX;
	private double aY;
	private double bX;
	private double bY;
	private double cX;
	private double cY;
	private double dX;
	private double dY;
	private ArrayList<Corner> streets;
	private ArrayList<Corner> allPoints;

	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();
		myBoard = new Board(gameNr, db_conn);
		myStreet = new Street();
		streets = myStreet.getCornerPoints();
		allPoints = myBoard.getCorners();
	}

	public void checkStreets() {
		ArrayList<Point> pointsStreet = new ArrayList<Point>();
		int counter = 0;
		for (Corner street : streets) {
			Point StreetCorner = street.getInGamePoint();
			pointsStreet.add(StreetCorner);

			for (Point points : pointsStreet) {
				x1 = (int) pointsStreet.get(0).getX();
				y1 = (int) pointsStreet.get(0).getY();
				x2 = (int) pointsStreet.get(1).getX();
				y2 = (int) pointsStreet.get(1).getY();

				Point location;

				if (x1 == x2) {
					if (x > (x1 - 5) && x < (x2 + 5) && y > (y1 - 5) && y < y2 + 5) {
						location = new Point(x, y);
						counter++;
					}
				} else {
					Dx = x2 - x1;
					Dy = y2 - y1;
					D = (int) Math.sqrt((Dx * Dx) + (Dy * Dy));
					Dx = (((0.5 * W) * Dx) / D);
					Dy = (((0.5 * W) * Dy) / D);

					aX = x1 - Dy;
					aY = y1 + Dx;
					bX = x1 + Dy;
					bY = x1 - Dy;
					cX = x2 - Dy;
					cY = y2 + Dx;
					dX = x2 + Dx;
					dY = y2 - Dx;

					int L = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
					int oppABP = (int) (0.5 * ((aX - x) * (bY - aY) - (aX - bX) * (y - aY)));
					int oppBCP = (int) (0.5 * ((cX - x) * (bY - cY) - (cX - bX) * (y - cY)));
					int oppCDP = (int) (0.5 * ((cX - x) * (dY - cY) - (cX - dX) * (y - cY)));
					int oppADP = (int) (0.5 * ((aX - x) * (dY - aY) - (aX - dX) * (y - aY)));

					if ((L * W) == (oppABP + oppBCP + oppCDP + oppADP) || oppABP == 0 || oppBCP == 0 || oppCDP == 0
							|| oppADP == 0) {
						location = new Point(x, y);
						counter++;
					}
				}
			}

		}
		if (counter == 1) {
			// build
		}
	}

	public void showStreets(int player) {
		boolean yourStreet = (myStreet.getPlayer() == player);
		for (Corner street : streets) {
			
		}
		if (x1 == x2) {
			// a (x1-5),y1
			// b (x1+5),y1
			// c (x2-5),y2
			// d (x2+5),y2
		} else {
			Dx = x2 - x1;
			Dy = y2 - y1;
			D = (int) Math.sqrt((Dx * Dx) + (Dy * Dy));
			Dx = (((0.5 * W) * Dx) / D);
			Dy = (((0.5 * W) * Dy) / D);

			aX = x1 - Dy;
			aY = y1 + Dx;
			bX = x1 + Dy;
			bY = x1 - Dy;
			cX = x2 - Dy;
			cY = y2 + Dx;
			dX = x2 + Dx;
			dY = y2 - Dx;
		}

		// g.setColor(kleur van speler)
		// maak transparant
		// g.fill
	}

	public void checkTowns() {
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
		ArrayList<Corner> possibleTowns = new ArrayList<Corner>();

		for (Corner corner : allPoints) {
			boolean hasTown = corner.isTown();
			boolean hasCity = corner.isCity();
			boolean hasNeighbor = false;
			boolean connectedToYourStreet = false;

			for (Corner street : streets) {
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
