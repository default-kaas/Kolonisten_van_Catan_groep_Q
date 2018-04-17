package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DobbelsteenPaneel extends JPanel {
	public DobbelsteenPaneel() {

		// Dit is ff ORANGE voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.19);
		this.setPreferredSize(new Dimension(256, Height));
		this.setBackground(Color.ORANGE);
	}
}
