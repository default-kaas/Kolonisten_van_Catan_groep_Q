package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.PlayerInfoController;

public class PlayerInformationPanel extends JPanel implements ActionListener {
	// private Player speler1 = new Player();
	private JButton close;
	private BufferedImage WoolImage;
	private BufferedImage WheatImage;
	private BufferedImage WoodImage;
	private BufferedImage StoneImage;
	private BufferedImage OreImage;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;

	//
/*	private final JLabel your_resources = new JLabel("Jouw grondstoffen:");;*/

	// Trade button
	private JButton trade = new JButton("Handelspaneel");

	// end round button
	private JButton end = new JButton("Beurt beindigen");

	private PlayerInfoController controller;

	public PlayerInformationPanel(PlayerInfoController controller) {
		this.controller = controller;

		SetVariables();
		c = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);

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

	public void playerInfo() {
		JLabel playerTitle = new JLabel("Speler Info");
		playerTitle.setFont(new Font("Arial", Font.BOLD, 30));

		c.insets = new Insets(0, 0, 100, 100);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		add(playerTitle, c);
	}

	public void allInfo() {
		JLabel enemyTitle = new JLabel("Tegenstanders Info");
		enemyTitle.setFont(new Font("Arial", Font.BOLD, 30));

		c.insets = new Insets(0, 0, 100, 0);
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridx = 1;
		c.gridy = 0;
		add(enemyTitle, c);

		for (int i = 0; i < 4; i++) { //had to make this big ass if/else because for each player the gridY changes....
			if (i == 0) {
			if (controller.myTurn(i)) {
				JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 1;
				this.add(turn, c);
			} else {
				JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i));	
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 1;
				this.add(notTurn, c);
			}
			
		}else if (i == 1) {
			if (controller.myTurn(i)) {
				JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 2;
				this.add(turn, c);
			} else {
				JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i));	
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 2;
				this.add(notTurn, c);
			}
		} else if( i == 2 ) {
			if (controller.myTurn(i)) {
				JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 3;
				this.add(turn, c);
			} else {
				JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i));	
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 3;		
				this.add(notTurn, c);
			}
		}else if (i == 3 ) {
			if (controller.myTurn(i)) {
				JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 4;
				this.add(turn, c);
			} else {
				JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
						+ "Aantal grondstoffen: " + controller.getPlayerResources(i));	
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTHEAST;
				c.gridx = 1;
				c.gridy = 4;
				this.add(notTurn, c);
				
				
			}
		}

		}
	}

	public void TradeButton() {
		c.insets = new Insets(0, 0, 0, 100);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 4;
		this.add(trade, c);
		trade.addActionListener(this);
	}

	public void endButton() {
		c.insets = new Insets(30, 0, 0, 100);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 5;
		this.add(end,c);
		trade.addActionListener(this);

		for (int i = 0; i < 4; i++) {
			if (controller.myTurn(i)) {
				enableEndButton();
			} else {
				disableEndButton();
			}
		}

	}

	public void enableEndButton() {
		end.setBackground(new Color(5, 162, 0));
		end.setForeground(Color.WHITE);
		end.setEnabled(true);
	}

	public void disableEndButton() {
		end.setBackground(new Color(163, 0, 0));
		end.setForeground(Color.BLACK);
		end.setEnabled(false);
	}

	public void ShowTradeButton() {
		trade.setBackground(new Color(5, 162, 0));
		trade.setForeground(Color.WHITE);
		trade.setEnabled(true);

		end.setBackground(new Color(5, 162, 0));
		end.setForeground(Color.WHITE);
		end.setEnabled(true);
	}

	public void DisableTradeButton() {
		trade.setBackground(new Color(163, 0, 0));
		trade.setForeground(Color.BLACK);
		trade.setEnabled(false);

		end.setBackground(new Color(163, 0, 0));
		end.setForeground(Color.BLACK);
		end.setEnabled(false);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == trade) {
			getTradePanel();
		} else if (arg0.getSource() == close) {
			System.exit(0);
		}

	}

	/*public void ShowResources() {
		this.add(your_resources);
	}*/

	public void getTradePanel() {
		controller.getTradePanel();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);

		ImageIcon icon = new ImageIcon("images/Background/playerBg.jpg");
		JLabel thumb = new JLabel(icon);
		thumb.setSize(width, height);
		this.add(thumb);

	/*	String wood = ": " + controller.getWoodAmount();
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
		g.drawString(ore, 415 + Width, 200 + (int) (Height * 0.6));*/
	}

}
