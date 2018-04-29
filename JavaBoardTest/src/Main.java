import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;

	private Font font = new Font("Arial", Font.BOLD, 18);
	FontMetrics metrics;


	public Main() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
	
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(200, 400, 58));
		g.setColor(Color.CYAN);
		g.fillPolygon(getHexagon(200, 400, 56));
		
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(250, 487, 58));
		g.setColor(Color.blue);
		g.fillPolygon(getHexagon(250, 487, 56));
		
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(300, 400, 58));
		g.setColor(Color.red);
		g.fillPolygon(getHexagon(300, 400, 56));
		
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(250, 313, 58));
		g.setColor(Color.blue);
		g.fillPolygon(getHexagon(250, 313, 56));
		
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(300, 226, 58));
		g.setColor(Color.cyan);
		g.fillPolygon(getHexagon(300, 226, 56));
		
		g.setColor(Color.black);
		g.fillPolygon(getHexagon(300, 574, 58));
		g.setColor(Color.cyan);
		g.fillPolygon(getHexagon(300, 574, 56));
		g.setColor(Color.ORANGE);
		g.drawLine(350, 200, 350, 258);

	}

	Polygon getHexagon(int x, int y, int h) {
		Polygon hexagon = new Polygon();
		
		double a;
		for (int i = 0; i < 6; i++) {
			a = Math.PI / 3.0 * i;
			Point point = new Point((int) (Math.round(x + Math.sin(a) * h)), (int) (Math.round(y + Math.cos(a) * h)));
			System.out.println("x: "+ point.x+ " y: "+  point.y);
			hexagon.addPoint(point.x, point.y);
		}
		System.out.println();
		return hexagon;
	}

	
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