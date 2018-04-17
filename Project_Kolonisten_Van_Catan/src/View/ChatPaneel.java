package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ChatPaneel extends JPanel {
	public ChatPaneel() {

		// Dit is ff blauw voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int)(screenSize.getHeight()*0.2);
		this.setPreferredSize(new Dimension(450, Height));
		this.setBackground(Color.BLUE);
	}
}
