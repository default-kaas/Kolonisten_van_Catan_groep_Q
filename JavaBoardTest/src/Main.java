import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;

	private Font font = new Font("Arial", Font.BOLD, 18);
	FontMetrics metrics;

	public static final int SIDES = 6;

	private int rotation = 90;
	private Point[] points = new Point[SIDES];
	int[] xpoints = new int[SIDES];
	int[] ypoints = new int[SIDES];
	private Point center = new Point(0, 0);
	public Main() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		// Graphics2D g2d = (Graphics2D) g;
		// Point origin = new Point(WIDTH / 2, HEIGHT / 2);
		//
		// g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE,
		// BasicStroke.JOIN_MITER));
		// g2d.setFont(font);
		// metrics = g.getFontMetrics();
		g.setColor(Color.red);

		int npoints = 6;
		center = new Point(500, 400);
		updatePoints();

		g.fillPolygon(xpoints, ypoints, npoints);
		g.setColor(Color.blue);
		center = new Point(673, 400);
		updatePoints();

		g.fillPolygon(xpoints, ypoints, npoints);

		g.setColor(Color.red);
		center = new Point(846, 400);
		updatePoints();

		g.fillPolygon(xpoints, ypoints, npoints);
		
		
		g.setColor(Color.blue);
		center = new Point(586, 00);
		updatePoints();

		g.fillPolygon(xpoints, ypoints, npoints);
		
		// drawCircle(g2d, origin, 380, true, true, 0x4488FF, 0);
		// drawHexGridLoop(g2d, origin, 5, 60, 0);
	}

	private double findAngle(double fraction) {
		return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
	}

	private Point findPoint(double angle) {
		int x = (int) (center.x + Math.cos(angle) * 100);
		int y = (int) (center.y + Math.sin(angle) * 100);

		return new Point(x, y);
	}

	protected void updatePoints() {
		for (int p = 0; p < SIDES; p++) {
			double angle = findAngle((double) p / SIDES);
			Point point = findPoint(angle);
			xpoints[p] = point.x;
			ypoints[p] = point.y;
			System.out.println(point.x);
			System.out.println(point.y);
			points[p] = point;
		}
	}
	// private void drawHexGridLoop(Graphics g, Point origin, int size, int radius,
	// int padding) {
	// double ang30 = Math.toRadians(30);
	// double xOff = Math.cos(ang30) * (radius + padding);
	// double yOff = Math.sin(ang30) * (radius + padding);
	// int half = size / 2;
	//
	// for (int row = 0; row < size; row++) {
	// int cols = size - java.lang.Math.abs(row - half);
	//
	// for (int col = 0; col < cols; col++) {
	//
	// int xLbl = row < half ? col - row : col - half;
	// int yLbl = row - half;
	// int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
	// int y = (int) (origin.y + yOff * (row - half) * 3);
	//
	// drawHex(g, xLbl, yLbl, x, y, radius);
	// }
	// }
	// }

	// private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
	// Graphics2D g2d = (Graphics2D) g;
	//
	// System.out.println("x-Pos: " + posX + " - y-Pos: " + posY);
	// Hex hex = new Hex(x, y, r);
	// // String text = String.format("%s : %s", coord(posX), coord(posY));
	// // int w = metrics.stringWidth(text);
	// int h = metrics.getHeight();
	//
	// if (posX == 0 && posY == -2) {
	// hex.draw(g2d, x, y, 0, 0xCC0000, true);
	// hex.draw(g2d, x, y, 4, 0x33FF33, false);
	//
	// } else {
	// hex.draw(g2d, x, y, 0, 0x008844, true);
	// hex.draw(g2d, x, y, 4, 0x33FF33, false);
	// }
	//
	//
	// // g.setColor(new Color(0xFFFFFF));
	// // g.drawString(text, x - w/2, y + h/2);
	// }
	//
	// private String coord(int value) {
	// return (value > 0 ? "+" : "") + Integer.toString(value);
	// }

	// public void drawCircle(Graphics2D g, Point origin, int radius, boolean
	// centered, boolean filled, int colorValue,
	// int lineThickness) {
	// // Store before changing.
	// Stroke tmpS = g.getStroke();
	// Color tmpC = g.getColor();
	//
	// g.setColor(new Color(colorValue));
	// g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
	// BasicStroke.JOIN_ROUND));
	//
	// int diameter = radius * 2;
	// int x2 = centered ? origin.x - radius : origin.x;
	// int y2 = centered ? origin.y - radius : origin.y;
	//
	// if (filled)
	// g.fillOval(x2, y2, diameter, diameter);
	// else
	// g.drawOval(x2, y2, diameter, diameter);
	//
	// // Set values to previous when done.
	// g.setColor(tmpC);
	// g.setStroke(tmpS);
	// }

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Main p = new Main();

		f.setContentPane(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}