package View;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DobbelsteenPanel extends JPanel {
	private ImageIcon dice;
	private JLabel label1;
	private int screenHeight;
	private JButton myButton;
	private BufferedImage image;
	private boolean pressed = false;

	public DobbelsteenPanel() {

		myButton = new JButton("Throw Dice");

		screenHeight = ScreenHeight();

		this.add(myButton);
		this.setPreferredSize(new Dimension(256, screenHeight));
		this.setBackground(Color.WHITE);

		myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Removes button when a player has thrown a dice to force one throw per round.
				remove(myButton);
				pressed = true;
				repaint();

			}
		});

		try {
			image = ImageIO.read(new File("images/dice.png"));
		} catch (IOException e) {
			e.printStackTrace();
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
			g.drawImage(image, 129, (screenHeight / 2) - 60, 120, 120, this);
		}
	}

}
