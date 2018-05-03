package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.Board;
import Model.Corner;
import Model.Tile;

public class BoardPanel extends JPanel {
	private Board board;
	private int height;

	public BoardPanel(Board board) {
		this.board = board;
		// Dit is ff groen voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		height = (int) (screenSize.getHeight());
		this.setPreferredSize(new Dimension(height, height - 23));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(1, 207, 203));
		g.fillRect(0, 0, height, height);
		ArrayList<Tile> Tiles = board.getTiles();
		for (Tile tile : Tiles) {
			ArrayList<Point> CornerPoints = tile.getInGameCornerPoints();

			Color Wheat = Color.YELLOW;
			Color Wood = new Color(0x99, 0x66, 0x33);
			Color Wool = Color.GREEN;
			Color Ore = Color.LIGHT_GRAY;
			Color Brick = new Color(0xAD, 0x33, 0x33);
			Color Dessert = new Color(0xFF, 0xFF, 0xA9);
			
			switch (tile.getIdResourceType()) {
			case 'B':
				g.setColor(Brick);
				break;
			case 'E':
				g.setColor(Ore);
				break;
			case 'G':
				g.setColor(Wheat);
				break;
			case 'H':
				g.setColor(Wood);
				break;
			case 'W':
				g.setColor(Wool);
				break;
			case 'X':
				g.setColor(Dessert);
				break;
			}
			
			Polygon hexagon = new Polygon();
			for (Point Corner : CornerPoints) {
				hexagon.addPoint(Corner.x, Corner.y);
			}

			g.fillPolygon(hexagon);

			g.setColor(Color.black);
			g.fillOval(tile.getInGameCenterPoint().x - 20, tile.getInGameCenterPoint().y - 20, 40, 40);
			g.setColor(Color.white);
			g.fillOval(tile.getInGameCenterPoint().x - 19, tile.getInGameCenterPoint().y - 19, 38, 38);

			int TileNumber = tile.getIdNumberChip();

			String number = null;
			switch (TileNumber) {
			case 6:
				g.setColor(Color.red);
				number = TileNumber + ".";
				break;
			case 8:
				g.setColor(Color.red);
				number = "" + TileNumber;
				break;
			case 9:
				g.setColor(Color.black);
				number = TileNumber + ".";
				break;
			default:
				g.setColor(Color.black);
				number = "" + TileNumber;
				break;
			}

			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.drawString(number, tile.getInGameCenterPoint().x - 4, tile.getInGameCenterPoint().y + 5);

		}

	}

	Polygon getHexagon(int x, int y, int h) {
		Polygon hexagon = new Polygon();
		double a;
		for (int i = 0; i < 6; i++) {
			a = Math.PI / 3.0 * i;
			Point point = new Point((int) (Math.round(x + Math.sin(a) * h)), (int) (Math.round(y + Math.cos(a) * h)));
			hexagon.addPoint(point.x, point.y);
		}
		return hexagon;
	}

}
