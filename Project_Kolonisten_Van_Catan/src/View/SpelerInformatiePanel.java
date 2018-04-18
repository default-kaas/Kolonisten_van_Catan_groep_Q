package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Player;

public class SpelerInformatiePanel extends JPanel implements ActionListener{
	//private Player speler1 = new Player();
	private JButton close;
	public SpelerInformatiePanel() {
		close = new JButton("Close game!");
		this.add(close);
		close.addActionListener(this);
		//Dit is ff red voor een test, mag je weghalen
		//this.setPreferredSize(new Dimension(300,475));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size)/2);
		this.setPreferredSize(new Dimension(width, (int)(screenSize.getHeight()*0.49)));
		this.setBackground(Color.RED);
	}
	public void actionPerformed(ActionEvent arg0) {
		// Removes button when a player has thrown a dice to force one throw per round.
		System.exit(0);
	}
}
