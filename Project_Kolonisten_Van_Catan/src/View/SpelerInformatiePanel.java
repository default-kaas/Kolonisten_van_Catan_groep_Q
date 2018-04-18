package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.PlayerInfoController;
import Model.Player;

public class SpelerInformatiePanel extends JPanel implements ActionListener {
	// private Player speler1 = new Player();
	private JButton close;
	private BufferedImage WoolImage;
	private BufferedImage WheatImage;
	private BufferedImage WoodImage;
	private BufferedImage StoneImage;
	private BufferedImage OreImage;
	private PlayerInfoController Controller;
	
	private JLabel Player1;
	private JLabel Player2;
	private JLabel Player3;
	private JLabel Player4;
	
	public SpelerInformatiePanel() {
		SetVariables();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(close);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(Player1);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(Player2);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(Player3);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(Player4);
		close.addActionListener(this);
	
		//Panel size + Background and border
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size) / 2);
		this.setPreferredSize(new Dimension(width, (int) (screenSize.getHeight() * 0.5)));
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void SetVariables() {
		//Add all images to Variables
		try {
			WoolImage = ImageIO.read(new File("images/Wool.png"));
			WheatImage = ImageIO.read(new File("images/Wheat.png"));
			WoodImage = ImageIO.read(new File("images/Wood.png"));
			StoneImage = ImageIO.read(new File("images/Stone.png"));
			OreImage = ImageIO.read(new File("images/Ore.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		Controller = new PlayerInfoController();
		
		//Buttons for closing game
		close = new JButton("Close game!");
		
		//Names of Players in game
		Player1 = new JLabel("TEST");
		Player2 = new JLabel("TEST");
		Player3 = new JLabel("TEST");
		Player4 = new JLabel("TEST");
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(WoolImage, 10, 200, (int) (WoolImage.getWidth() * 0.2), (int) (WoolImage.getHeight() * 0.2), this);
		g.drawImage(WheatImage, 110, 200, (int) (WoolImage.getWidth() * 0.2), (int) (WoolImage.getHeight() * 0.2), this);
		g.drawImage(WoodImage, 210, 200, (int) (WoolImage.getWidth() * 0.2), (int) (WoolImage.getHeight() * 0.2), this);
		g.drawImage(StoneImage, 310, 200, (int) (WoolImage.getWidth() * 0.2), (int) (WoolImage.getHeight() * 0.2), this);
		g.drawImage(OreImage, 410, 200, (int) (WoolImage.getWidth() * 0.2), (int) (WoolImage.getHeight() * 0.2), this);
	}

	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
