package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BordPaneel extends JPanel {
	public BordPaneel() {
		
		//Dit is ff groen voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int)(screenSize.getHeight()*0.7);
		this.setPreferredSize(new Dimension(size, size));
		
		System.out.println(size);
		this.setBackground(Color.GREEN);
	}
	
}
