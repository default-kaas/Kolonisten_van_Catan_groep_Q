package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.Board;
import Model.Dock;
import Model.Tile;

public class BoardPanel extends JPanel /*implements MouseListener*/ {
	private Board board;
	private int height;

	private final Color Wheat = Color.YELLOW;
	private final Color Wood = new Color(0x99, 0x66, 0x33);
	private final Color Wool = Color.GREEN;
	private final Color Ore = Color.LIGHT_GRAY;
	private final Color Brick = new Color(0xAD, 0x33, 0x33);
	private final Color Dessert = new Color(0xFF, 0xFF, 0xA9);
	private File folderInput = new File("images/Other/knight.png");
	private BufferedImage img;

	private int xMouse;
	private int yMouse;

	public BoardPanel(Board board) {
		this.board = board;
		
		// Dit is ff groen voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		height = (int) (screenSize.getHeight());
		this.setPreferredSize(new Dimension(height, height - 23));

		try {
			img = ImageIO.read(folderInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(1, 207, 203));
		g.fillRect(0, 0, height, height);
		ArrayList<Tile> Tiles = board.getTiles();
		for (Tile tile : Tiles) {
			ArrayList<Point> CornerPoints = tile.getInGameCornerPoints();

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

			int TileNumber = tile.getIdNumberChip();
			if (TileNumber != 0) {
				// Draw fiches
				g.setColor(Color.black);
				g.fillOval(tile.getInGameCenterPoint().x - 20, tile.getInGameCenterPoint().y - 20, 40, 40);
				g.setColor(Color.white);
				g.fillOval(tile.getInGameCenterPoint().x - 19, tile.getInGameCenterPoint().y - 19, 38, 38);

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
				// Draw number on fiches
				if (TileNumber >= 10) {
					g.drawString(number, tile.getInGameCenterPoint().x - 8, tile.getInGameCenterPoint().y + 5);
				} else {
					g.drawString(number, tile.getInGameCenterPoint().x - 4, tile.getInGameCenterPoint().y + 5);
				}
			}

			if (tile.isRobber()) {
				g.drawImage(img, tile.getInGameCenterPoint().x - (img.getWidth() / 2),
						tile.getInGameCenterPoint().y - (img.getHeight() / 2), null);
			}
		}
		ArrayList<Dock> docks = board.getDocks();
		for (Dock dock : docks) {
			if (dock.getDockPoint() != null) {
				g.setColor(Color.blue);
				int[] xPoints = new int[3];
				xPoints[0] = dock.getCorner(0).getInGamePoint().x;
				xPoints[1] = dock.getCorner(1).getInGamePoint().x;
				xPoints[2] = dock.getDockPoint().x;
				System.out.println(xPoints[0]);
				int[] yPoints = new int[3];
				yPoints[0] = dock.getCorner(0).getInGamePoint().y;
				yPoints[1] = dock.getCorner(1).getInGamePoint().y;
				yPoints[2] = dock.getDockPoint().y;
				System.out.println(yPoints[0]);
				g.fillPolygon(xPoints, yPoints, 3);
				g.setColor(Color.white);
				g.fillOval(dock.getDockPoint().x - 19, dock.getDockPoint().y - 19, 38, 38);
				g.setColor(Color.black);
				if (dock.getType().equals("3:1")) {
					g.drawString(dock.getType(), dock.getDockPoint().x - 11, dock.getDockPoint().y + 5);
				} else if (dock.getType().equals("W")) {
					g.drawString(dock.getType(), dock.getDockPoint().x - 7, dock.getDockPoint().y + 5);
				} else {
					g.drawString(dock.getType(), dock.getDockPoint().x - 6, dock.getDockPoint().y + 5);
				}
			}
		}
	}
	
	public void paintStreet(Graphics g, int player, int x, int y, int width, int height) {
		Color c = Color.BLACK;
		g.setColor(c);
		g.drawRect(x, y, width, height);
		switch (player) {
		case 1:
			c = new Color(1f, 0f, 0f, .5f);
			break;
		case 2:
			c = new Color(1f, 1f, 1f, .5f);
			break;
		case 3:
			c = new Color(0f, 0f, 1f, .5f);
			break;
		case 4:
			c = new Color(1f, 0.5f, 0f, .5f);
			break;
		default:
			c = Color.BLACK;
			break;
		}
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	public void paintTown(Graphics g, int player, int x, int y, int r) {
		Color c = Color.BLACK;
		g.setColor(c);
		g.drawOval(x, y, r, r);
		switch (player) {
		case 1:
			c = new Color(1f, 0f, 0f, .5f);
			break;
		case 2:
			c = new Color(1f, 1f, 1f, .5f);
			break;
		case 3:
			c = new Color(0f, 0f, 1f, .5f);
			break;
		case 4:
			c = new Color(1f, 0.5f, 0f, .5f);
			break;
		default:
			c = Color.BLACK;
			break;
		}
		g.setColor(c);
		g.fillOval(x, y, r, r);
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
/*
	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		xMouse = me.getX();
		yMouse = me.getY();

		repaint();
	}

	public int getX() {
		return xMouse;
	}

	public int getY() {
		return yMouse;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}*/
}
