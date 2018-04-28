import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;

public class Hex extends Polygon {

	private static final long serialVersionUID = 1L;

	public static final int SIDES = 6;

	private Point[] points = new Point[SIDES];
	private Point center = new Point(0, 0);
	private int radius;

	public Hex(Point center, int radius) {
		npoints = SIDES;
		xpoints = new int[SIDES];
		ypoints = new int[SIDES];

		this.center = center;
		this.radius = radius;

		updatePoints();
	}

	public Hex(int x, int y, int radius) {
		this(new Point(x, y), radius);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;

		updatePoints();
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;

		updatePoints();
	}

	public void setCenter(Point center) {
		this.center = center;

		updatePoints();
	}

	public void setCenter(int x, int y) {
		setCenter(new Point(x, y));
	}

	private double findAngle(double fraction) {
		return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
	}

	private Point findPoint(double angle) {
		int x = (int) (center.x + Math.cos(angle) * radius);
		int y = (int) (center.y + Math.sin(angle) * radius);

		return new Point(x, y);
	}

	protected void updatePoints() {
		for (int p = 0; p < SIDES; p++) {
			double angle = findAngle((double) p / SIDES);
			Point point = findPoint(angle);
			xpoints[p] = point.x;
			ypoints[p] = point.y;
			points[p] = point;
		}
	}

	public void draw(Graphics2D g, int x, int y, int lineThickness, int colorValue, boolean filled) {

		
		
		// Store before changing.
		Stroke tmpS = g.getStroke();
		Color tmpC = g.getColor();

		g.setColor(new Color(colorValue));
		g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		

		if (filled)
			g.fillPolygon(xpoints, ypoints, npoints);
		else
			g.drawPolygon(xpoints, ypoints, npoints);

		// Set values to previous when done.
		g.setColor(tmpC);
		g.setStroke(tmpS);

		g.setColor(Color.WHITE);
		g.fillOval(x - 15, y - 15, 30, 30);
		
		g.setColor(Color.RED);

			for(int i = 0; i<6; i++) {
				if(filled) {
					System.out.println("X-cord: " + xpoints[i]+ " - Y-cord: "+ ypoints[i]);
					g.fillRect(xpoints[i]-10, ypoints[i]-10, 20, 20);
				}
			}
			
		
	}
}