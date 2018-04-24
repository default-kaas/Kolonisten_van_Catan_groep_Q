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
import Controller.TradePanelController;
import Model.Player;

public class PlayerInformationPanel extends JPanel implements ActionListener {
	// private Player speler1 = new Player();
	private JButton close;
	private JButton trade;
	private BufferedImage WoolImage;
	private BufferedImage WheatImage;
	private BufferedImage WoodImage;
	private BufferedImage StoneImage;
	private BufferedImage OreImage;

	// private PlayerInfoController Controller;

	// Player names
	private JLabel Player1;
	private JLabel Player2;
	private JLabel Player3;
	private JLabel Player4;

	//
	private final JLabel your_resources = new JLabel("Jouw grondstoffen:");;

	private PlayerInfoController controller;

	public PlayerInformationPanel(PlayerInfoController controller) {
		this.controller = controller;

		SetVariables();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// this.add(Box.createRigidArea(new Dimension(5, 10)));
		// this.add(close);
		this.add(Box.createRigidArea(new Dimension(5, 10)));


		// Panel size + Background and border
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	private void SetVariables() {
		// Add all images to Variables
		try {
			WoolImage = ImageIO.read(new File("images/Resources/Wool.png"));
			WheatImage = ImageIO.read(new File("images/Resources/Wheat.png"));
			WoodImage = ImageIO.read(new File("images/Resources/Wood.png"));
			StoneImage = ImageIO.read(new File("images/Resources/Stone.png"));
			OreImage = ImageIO.read(new File("images/Resources/Ore.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int Width =  (int) (WoolImage.getWidth() * 0.1);
		int Height = (int) (WoolImage.getHeight() * 0.1);
		g.drawImage(WoolImage, 10, 200, Width, Height, this);
		g.drawString(" : 1", 15+Width, 200+(int)(Height*0.5));
		
		g.drawImage(WheatImage, 110, 200, Width, Height, this);
		g.drawString(" : 1", 115+Width,200+(int)(Height*0.5));
		
		g.drawImage(WoodImage, 210,200, Width, Height, this);
		g.drawString(" : 1", 215+Width,200+(int)(Height*0.5));
		
		g.drawImage(StoneImage, 310, 200, Width, Height, this);
		g.drawString(" : 1", 315+Width,200+(int)(Height*0.5));
		
		g.drawImage(OreImage, 410, 200, Width, Height, this);
		g.drawString(" : 1", 415+Width ,200+(int)(Height*0.5));
	}

	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

	public void ShowResources() {
		this.add(Box.createRigidArea(new Dimension(5, 20)));
		this.add(your_resources);
	}

	public void ShowTradeButton() {
		trade = new JButton("Handelspaneel");
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(trade);

		trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradePanelController tpc = new TradePanelController();
			}
		});
	}

	public void UpdatePlayerTurn() {
		// Names of Players in game

		for (int i = 0; i < 4; i++) {
			if (controller.myTurn(i)) {
				this.add(new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - bezig met zijn beurt!"));
			} else {
				this.add(new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)));
			}
			this.add(Box.createRigidArea(new Dimension(5, 10)));
		}
		
	}
}
