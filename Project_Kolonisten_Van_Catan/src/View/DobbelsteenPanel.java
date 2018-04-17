package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DobbelsteenPanel extends JPanel {
	private ImageIcon dice;	
	private JLabel label1;
	public DobbelsteenPanel() {

		dice = new ImageIcon("/Project_Kolonisten_Van_Catan/images/dice.png");
		label1 = new JLabel(dice);
		label1.setSize(this.getWidth(), getHeight());
		
		// Dit is ff ORANGE voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.19);
		this.add(label1);
		this.setPreferredSize(new Dimension(256, Height));
		this.setBackground(Color.WHITE);
		
		
	}
}
