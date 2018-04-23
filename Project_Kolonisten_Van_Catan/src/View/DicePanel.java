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
	
	private JLabel text = new JLabel("Dobbelsteen gooien");

	private DiceController diceController;
	
	
	public DicePanel(DiceController diceController) {
		this.diceController = diceController;
		this.setLayout(new GridBagLayout());
		screenHeight = ScreenHeight();
		this.setPreferredSize(new Dimension(215, 110));
		this.setBackground(new Color(1, 207, 203));
	}
	public void showDice() {
		if(diceController.hasTrown()) {
			diceController.showOldDice();
			remove(text);
			this.setBackground(Color.BLUE);
			pressed = true;
			repaint();
		}else {
	
		
		this.setBackground(Color.WHITE);
		this.add(text);
		this.addMouseListener(this);
		repaint();
		}
	}

	private int ScreenHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.2);
		return Height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (pressed) {
			g.drawImage(image, 5, 5, 100, 100, this);
			g.drawImage(image1, 110, 5, 100, 100, this);
		}
	}
	
	public void setImages(int value1, int value2) {
		try {
			image = ImageIO.read(new File("images/Dice/dice"+value1+".png"));
			image1 = ImageIO.read(new File("images/Dice/dice"+value2+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * This give the dice panel the options to add the dice pictures when then panel is pressed
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(!pressed) {
			diceController.setDiceImages();
			remove(text);
			this.setBackground(Color.BLUE);
			pressed = true;
			repaint();
		}else {
			
		}
		
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
