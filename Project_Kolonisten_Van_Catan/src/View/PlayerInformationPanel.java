package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.PlayerInfoController;

@SuppressWarnings("serial")
public class PlayerInformationPanel extends JPanel implements ActionListener {

	private JButton close;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private ImageIcon stoneImage = new ImageIcon("images/Resources/stone1.png");
	private ImageIcon woodImage = new ImageIcon("images/Resources/wood1.png");
	private ImageIcon oreImage = new ImageIcon("images/Resources/ore1.png");
	private ImageIcon woolImage = new ImageIcon("images/Resources/sheep1.png");
	private ImageIcon wheatImage = new ImageIcon("images/Resources/wheat1.png");


	// Trade button
	private JButton trade = new JButton("Handelspaneel");

	// end round button
	private JButton end = new JButton("Beurt beëindigen");

	private PlayerInfoController controller;

	public PlayerInformationPanel(PlayerInfoController controller) {
		this.controller = controller;

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

	public void playerInfo() {
		JLabel playerTitle = new JLabel("Speler Info");
		playerTitle.setFont(new Font("Arial", Font.BOLD, 30));
		playerTitle.setForeground(Color.BLACK);

		c.insets = new Insets(0, 0, 0, 100);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		add(playerTitle, c);
	}

	public void playerResources() {

		String woodAmount = ": " + controller.getWoodAmount();
		String woolAmount = ": " + controller.getWoolAmount();
		String oreAmount = ": " + controller.getOreAmount();
		String wheatAmount = ": " + controller.getWheatAmount();
		String stoneAmount = ": " + controller.getStoneAmount();

		c.insets = new Insets(0, 0, 20, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		JLabel stone = new JLabel(stoneAmount);
		stone.setIcon(stoneImage);
		stone.setForeground(Color.BLACK);
		stone.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(stone, c);

		c.insets = new Insets(0, 0, 20, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		JLabel wood = new JLabel(woodAmount);
		wood.setIcon(woodImage);
		wood.setForeground(Color.BLACK);
		wood.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wood, c);

		c.insets = new Insets(0, 0, 20, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		JLabel wool = new JLabel(woolAmount);
		wool.setIcon(woolImage);
		wool.setForeground(Color.BLACK);
		wool.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wool, c);

		c.insets = new Insets(0, 0, 20, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		JLabel ore = new JLabel(oreAmount);
		ore.setIcon(oreImage);
		ore.setForeground(Color.BLACK);
		ore.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(ore, c);

		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 5;
		JLabel wheat = new JLabel(wheatAmount);
		wheat.setIcon(wheatImage);
		wheat.setForeground(Color.BLACK);
		wheat.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wheat, c);

	}

	public void allInfo() {
		JLabel enemyTitle = new JLabel("Tegenstanders Info");
		enemyTitle.setFont(new Font("Arial", Font.BOLD, 30));
		enemyTitle.setForeground(Color.BLACK);

		c.insets = new Insets(0, 0, 100, 0);
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridx = 1;
		c.gridy = 0;
		add(enemyTitle, c);

		for (int i = 0; i < 4; i++) { // this loop changes the gridY for each player so they don't appear next to each other. 
									 // For every loop it also checks who's turn it is...
			if (i == 0) {
				if (controller.myTurn(i)) {
					JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
							+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
					turn.setForeground(Color.BLACK);
					turn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 1;
					this.add(turn, c);
				} else {
					JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)
							+ " - " + "Aantal grondstoffen: " + controller.getPlayerResources(i));
					notTurn.setForeground(Color.BLACK);
					notTurn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 1;
					this.add(notTurn, c);
				}

			} else if (i == 1) {
				if (controller.myTurn(i)) {
					JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
							+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
					turn.setForeground(Color.BLACK);
					turn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 2;
					this.add(turn, c);
				} else {
					JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)
							+ " - " + "Aantal grondstoffen: " + controller.getPlayerResources(i));
					notTurn.setForeground(Color.BLACK);
					notTurn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 2;
					this.add(notTurn, c);
				}
			} else if (i == 2) {
				if (controller.myTurn(i)) {
					JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
							+ "Aantal grondstoffen: " + controller.getPlayerResources(i) + " - bezig met zijn beurt!");
					turn.setForeground(Color.BLACK);
					turn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 3;
					this.add(turn, c);
				} else {
					JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)
							+ " - " + "Aantal grondstoffen: " + controller.getPlayerResources(i));
					notTurn.setForeground(Color.BLACK);
					notTurn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 3;
					this.add(notTurn, c);
				}
			} else if (i == 3) {
				if (controller.myTurn(i)) {
					JLabel turn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i) + " - "
							+ "Aantal grondstoffen: " + controller.getPlayerResources(i)
							+ " - bezig met huidige beurt!");
					turn.setForeground(Color.BLACK);
					turn.setFont(new Font("Arial", Font.BOLD, 15));
					c.insets = new Insets(0, 0, 0, 0);
					c.anchor = GridBagConstraints.NORTHEAST;
					c.gridx = 1;
					c.gridy = 4;
					this.add(turn, c);
				} else {
					JLabel notTurn = new JLabel(controller.getPlayerColor(i) + ": " + controller.getPlayerName(i)
							+ " - " + "Aantal grondstoffen: " + controller.getPlayerResources(i));
					notTurn.setForeground(Color.BLACK);
					notTurn.setFont(new Font("Arial", Font.BOLD, 15));
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
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 7;
		this.add(trade, c);
		trade.addActionListener(this);
	}

	public void endButton() {
		c.insets = new Insets(0, 0, 0, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 7;
		this.add(end, c);
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


	public void getTradePanel() {
		controller.getTradePanel();
	}

	@Override
	protected void paintComponent(Graphics g) { 

		super.paintComponent(g);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);

		ImageIcon icon = new ImageIcon("images/Background/playerBg1.jpg"); //sets Panel Background.
		JLabel thumb = new JLabel(icon);
		thumb.setSize(width, height);
		this.add(thumb);
	}
}
