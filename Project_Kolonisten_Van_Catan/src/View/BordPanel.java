package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BordPanel extends JPanel {
	public BordPanel() {
		
		//Dit is ff groen voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int)(screenSize.getHeight());
		this.setPreferredSize(new Dimension(size, size));
		this.setBackground(Color.GREEN);
	}
	
}
