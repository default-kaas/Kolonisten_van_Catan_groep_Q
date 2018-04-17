package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BouwPanel extends JPanel {
	public BouwPanel() {

		// Dit is ff LightGray voor een test, mag je weghalen
		// this.setPreferredSize(new Dimension(300,475));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size)/2);
		this.setPreferredSize(new Dimension(width, 475));
		this.setBackground(Color.LIGHT_GRAY);
	}
}
