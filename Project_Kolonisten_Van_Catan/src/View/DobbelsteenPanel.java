package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DobbelsteenPanel extends JPanel {
	private ImageIcon dice;
	private JLabel label1;
	private int screenHeight;
	private JButton myButton;
	private BufferedImage image;
	private boolean pressed = false;

	public DobbelsteenPanel() {

		myButton = new JButton("Throw Dice");

		// Dit is ff ORANGE voor een test, mag je weghalen
		screenHeight = ScreenHeight();
		
		this.add(myButton);
		this.setPreferredSize(new Dimension(256, screenHeight));
		this.setBackground(Color.WHITE);

		myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(myButton);
				pressed = true;
				repaint();
				
				// dice = new ImageIcon("images/dice.png");
				// label1 = new JLabel(dice);
				// add(label1);
				// validate();
			}
		});

		try {
			image = ImageIO.read(new File("images/dice.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
