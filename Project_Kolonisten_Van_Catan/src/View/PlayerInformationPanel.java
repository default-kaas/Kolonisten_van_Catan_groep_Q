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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.PlayerInfoController;
import Controller.TradeController;
import Model.Player;

public class PlayerInformationPanel extends JPanel implements ActionListener {
	// private Player speler1 = new Player();
	private JButton close;
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

	//Trade button
	private JButton trade = new JButton("Handelspaneel");
	
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
			WoolImage = ImageIO.read(new File("images/Resources/sheep1.png"));
			WheatImage = ImageIO.read(new File("images/Resources/wheat1.png"));
			WoodImage = ImageIO.read(new File("images/Resources/wood1.png"));
			StoneImage = ImageIO.read(new File("images/Resources/stone1.png"));
			OreImage = ImageIO.read(new File("images/Resources/ore1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		String wood = ": " + controller.getWoodAmount();
		String wool = ": " + controller.getWoolAmount();
		String ore = ": " + controller.getOreAmount();
		String wheat = ": " + controller.getWheatAmount();
		String stone = ": " + controller.getStoneAmount();

		int Width = (int) (WoolImage.getWidth() * 0.8);
		int Height = (int) (WoolImage.getHeight() * 0.8);
		g.drawImage(WoolImage, 10, 200, Width, Height, this);
		g.drawString(wool, 15 + Width, 200 + (int) (Height * 0.6));

		g.drawImage(WheatImage, 110, 200, Width, Height, this);
		g.drawString(wheat, 115 + Width, 200 + (int) (Height * 0.6));

		g.drawImage(WoodImage, 210, 200, Width, Height, this);
		g.drawString(stone, 215 + Width, 200 + (int) (Height * 0.6));

		g.drawImage(StoneImage, 310, 200, Width, Height, this);
		g.drawString(stone, 315 + Width, 200 + (int) (Height * 0.6));

		g.drawImage(OreImage, 410, 200, Width, Height, this);
		g.drawString(ore, 415 + Width, 200 + (int) (Height * 0.6));
	}

	public void TradeButton() {
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(trade);
		trade.addActionListener(this);
	}
	public void ShowTradeButton() {
		trade.setBackground(new Color(5, 162, 0));
		trade.setForeground(Color.WHITE);
	}

	public void DisableTradeButton() {
		trade.setBackground(new Color(163, 0, 0));
		trade.setForeground(Color.BLACK);
		trade.setEnabled(false);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == trade) {
			getTradePanel();
		} else if (arg0.getSource() == close) {
			System.exit(0);
		}

	}

	public void ShowResources() {
		this.add(Box.createRigidArea(new Dimension(5, 20)));
		this.add(your_resources);
	}

	public void getTradePanel() {
		controller.getTradePanel();
	}

	public void UpdatePlayerTurn() {
		// Names of Players in game

		for (int i = 0; i < 4; i++) {
			if (controller.myTurn(i)) {
				this.add(new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)
						+ " - bezig met zijn beurt!"));
			} else {
				this.add(new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)));
			}
			this.add(Box.createRigidArea(new Dimension(5, 10)));
		}

	}
}
