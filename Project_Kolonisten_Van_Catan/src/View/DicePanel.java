package View;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import Controller.DiceController;

public class DicePanel extends JPanel implements MouseListener {
	private int screenHeight;
	private BufferedImage image;
	private BufferedImage image1;
	private boolean pressed = false;
	DiceController dobbelsteen = new DiceController();
	private JLabel text = new JLabel("Dobbelsteen gooien");

	public DicePanel() {
		this.setLayout(new GridBagLayout());
		screenHeight = ScreenHeight();
		this.setPreferredSize(new Dimension(256, screenHeight));
		this.setBackground(Color.WHITE);
		this.add(text);
		this.addMouseListener(this);
		
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
	public void mouseClicked(MouseEvent arg0) {
		remove(text);
		pressed = true;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
