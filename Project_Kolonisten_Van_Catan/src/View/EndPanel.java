package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.EndController;

public class EndPanel extends JPanel {
	private JButton repeat = new JButton();
	private JButton end = new JButton();
	private EndController endController;
	private BufferedImage backgroundImage;

	public EndPanel(EndController endController) {
		this.endController = endController;
		add(repeat);
		add(end);

		repeat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repeat();
			}
		});

		end.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				end();
			}
		});
		
		
		
	}

	public void SetVariables() {
		// Add all images to Variables
		try {
			backgroundImage = ImageIO.read(new File("images/Backgroung/catan.jpg"));
		} catch (IOException e) {
			setBackground(new Color(59, 89, 182));
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawImage(naam, 10, 200, (int) (naam.getWidth() * 0.2), (int)
		// (naam.getHeight() * 0.2), this);
	}
	
	public void repeat() {
		// restart game met zelfde players
	}

//	public void end() {
//		endController.endGame();
//	}
}