package View;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Dobbelsteen;

public class DobbelsteenPanel extends JPanel {
	private int screenHeight;
	private JButton myButton;
	private BufferedImage image;
	private BufferedImage image1;
	private boolean pressed = false;
	Dobbelsteen dobbelsteen = new Dobbelsteen();

	public DobbelsteenPanel() {

		myButton = new JButton("Throw Dice");

		screenHeight = ScreenHeight();

		this.add(myButton);
		this.setPreferredSize(new Dimension(256, screenHeight));
		this.setBackground(Color.WHITE);

		myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Removes button when a player has thrown a dice to force one throw per round.
				remove(myButton);
				pressed = true;
				repaint();

			}
		});

		try {
			switch (dobbelsteen.getValue1()) {
			case 1:
				image = ImageIO.read(new File("images/dice1.png"));
				break;
			case 2:
				image = ImageIO.read(new File("images/dice2.png"));
				break;
			case 3:
				image = ImageIO.read(new File("images/dice3.png"));
				break;
			case 4:
				image = ImageIO.read(new File("images/dice4.png"));
			case 5:
				image = ImageIO.read(new File("images/dice5.png"));
				break;
			case 6:
				image = ImageIO.read(new File("images/dice6.png"));
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			switch (dobbelsteen.getValue2()) {
			case 1:
				image1 = ImageIO.read(new File("images/dice1.png"));
				break;
			case 2:
				image1 = ImageIO.read(new File("images/dice2.png"));
				break;
			case 3:
				image1 = ImageIO.read(new File("images/dice3.png"));
				break;
			case 4:
				image1 = ImageIO.read(new File("images/dice4.png"));
			case 5:
				image1 = ImageIO.read(new File("images/dice5.png"));
				break;
			case 6:
				image1 = ImageIO.read(new File("images/dice6.png"));
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private int ScreenHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.19);
		return Height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (pressed) {
			g.drawImage(image, 6, (screenHeight / 2) - 60, 120, 120, this);
			g.drawImage(image1, 129, (screenHeight / 2) - 60, 120, 120, this);
		}
	}

}
