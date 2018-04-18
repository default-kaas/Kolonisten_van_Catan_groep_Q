package View;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Dobbelsteen;

public class DobbelsteenPanel extends JPanel implements ActionListener {
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
		
		myButton.addActionListener(this);

		try {
			image = ImageIO.read(new File("images/dice"+dobbelsteen.getValue1()+".png"));
			image1 = ImageIO.read(new File("images/dice"+dobbelsteen.getValue2()+".png"));
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Removes button when a player has thrown a dice to force one throw per round.
		if(ae.getSource()==myButton) {
			remove(myButton);
			pressed = true;
			repaint();
		}
	}

}
