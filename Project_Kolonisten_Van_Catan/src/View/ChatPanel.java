package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ChatPanel extends JPanel {
	public ChatPanel() {

		// Dit is ff blauw voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int)(screenSize.getHeight()*0.19);
		this.setPreferredSize(new Dimension(400, Height));
		this.setBackground(Color.BLUE);
	}
}
