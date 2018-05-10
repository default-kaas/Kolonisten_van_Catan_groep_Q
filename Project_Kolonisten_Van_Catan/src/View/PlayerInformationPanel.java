package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import Controller.PlayerInfoController;

public class PlayerInformationPanel extends JPanel implements ActionListener {

	private JButton close;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private GridBagConstraints x;
	private GridBagConstraints f;
	private GridBagConstraints j;
	private ImageIcon stoneImage = new ImageIcon("images/Resources/stone1.png");
	private ImageIcon woodImage = new ImageIcon("images/Resources/wood1.png");
	private ImageIcon oreImage = new ImageIcon("images/Resources/ore1.png");
	private ImageIcon woolImage = new ImageIcon("images/Resources/sheep1.png");
	private ImageIcon wheatImage = new ImageIcon("images/Resources/wheat1.png");
	private ImageIcon knightImage = new ImageIcon("images/Other/chess.png");
	private ImageIcon longestRoadImage = new ImageIcon("images/Other/road.png");
	private ImageIcon knightAndRoad = new ImageIcon("images/Other/chessandroad.png");
	private ImageIcon trophy = new ImageIcon("images/Other/trophy.png");
	private ImageIcon cardMonopoly = new ImageIcon("images/DevCards/monopoly.png");
	private ImageIcon cardKnight = new ImageIcon("images/DevCards/knight.png");
	private ImageIcon cardUniversity = new ImageIcon("images/DevCards/university.png");
	private ImageIcon cardTools = new ImageIcon("images/DevCards/tools.png");
	private ImageIcon cardInvention = new ImageIcon("images/DevCards/invention.png");
	private ImageIcon green = new ImageIcon("images/Other/green.png");
	private ImageIcon red = new ImageIcon("images/Other/red.png");
	private JLabel monopoly, knight, victoryPoints, tools, invention;
	private JButton playMonopoly = new JButton("Spelen");
	private JButton playKnight = new JButton("Spelen");
	private JButton playVictory = new JButton("Spelen");
	private JButton playTools = new JButton("Spelen");
	private JButton playInvention = new JButton("spelen");

	// Trade button
	private JButton trade = new JButton("Handelspaneel");

	// end round button
	private JButton end = new JButton("Beurt beëindigen");

	// won game button
	private JButton won = new JButton("Gewonnen!");

	private PlayerInfoController controller;

	private ArrayList<JLabel> playerInformation;

	private JLabel stone, wood, wool, ore, wheat;
	private JLabel turn, turn1, notTurn, notTurn1;

	public PlayerInformationPanel(PlayerInfoController controller) {
		this.controller = controller;

		c = new GridBagConstraints();
		x = new GridBagConstraints();
		f = new GridBagConstraints();
		j = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);

		// Panel size + Background and border
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(147, 147, 229));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	public void UpdateResources() {
		stone.setText(": " + controller.getStoneAmount());
		wood.setText(": " + controller.getWoodAmount());
		wool.setText(": " + controller.getWoolAmount());
		ore.setText(": " + controller.getOreAmount());
		wheat.setText(": " + controller.getWheatAmount());

		monopoly.setText(": " + controller.getPlayerMonopolyCard());
		knight.setText(": " + controller.getPlayerKnightCard());
		victoryPoints.setText(": " + controller.getPlayerVictoryPointCard());
		tools.setText(": " + controller.getPlayerToolsCard());
		invention.setText(": " + controller.getPlayerInventionCard());

		this.repaint();
	}

	public void UpdatePlayerInfo() {
		int i = 0;
		for (int x = 0; x < 8; x += 2) {
			if (controller.myTurn(i)) {
				playerInformation.get(x).setText(
						controller.getPlayerName(i) + " - " + "Grondstoffen: " + controller.getPlayerResources(i));
				playerInformation.get(x).setIcon(green);
				enablePlayButton();
			} else {
				playerInformation.get(x).setText(
						controller.getPlayerName(i) + " - " + "Grondstoffen: " + controller.getPlayerResources(i));
				playerInformation.get(x).setIcon(red);
			}
			playerInformation.get(x + 1).setText("" + controller.getVictoryPoints(i));

			if (controller.getPlayerName(i).equals(controller.checkArmy())
					&& controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
				playerInformation.get(x).setIcon(knightAndRoad);
			} else if (controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
				playerInformation.get(x).setIcon(longestRoadImage);
			} else if (controller.getPlayerName(i).equals(controller.checkArmy())) {
				playerInformation.get(x).setIcon(knightImage);
			}
			i++;
		}
	}

	public void playerInfo() {
		JLabel playerTitle = new JLabel("Speler Info");
		playerTitle.setFont(new Font("Arial", Font.BOLD, 30));
		playerTitle.setForeground(Color.BLACK);

		c.insets = new Insets(0, 0, 0, 100);
		c.anchor = GridBagConstraints.NORTH;
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

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		stone = new JLabel(stoneAmount);
		stone.setIcon(stoneImage);
		stone.setForeground(Color.BLACK);
		stone.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(stone, c);

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		wood = new JLabel(woodAmount);
		wood.setIcon(woodImage);
		wood.setForeground(Color.BLACK);
		wood.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wood, c);

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		wool = new JLabel(woolAmount);
		wool.setIcon(woolImage);
		wool.setForeground(Color.BLACK);
		wool.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wool, c);

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 4;
		ore = new JLabel(oreAmount);
		ore.setIcon(oreImage);
		ore.setForeground(Color.BLACK);
		ore.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(ore, c);

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 5;
		wheat = new JLabel(wheatAmount);
		wheat.setIcon(wheatImage);
		wheat.setForeground(Color.BLACK);
		wheat.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wheat, c);

	}

	public void playerDevelopmentCards() {

		// set monopoly card
		monopoly = new JLabel(": " + controller.getPlayerMonopolyCard());
		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 1;
		monopoly.setIcon(cardMonopoly);
		monopoly.setForeground(Color.BLACK);
		monopoly.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(monopoly, c);

		// set knight card

		knight = new JLabel(": " + controller.getPlayerKnightCard());

		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 2;
		knight.setIcon(cardKnight);
		knight.setForeground(Color.BLACK);
		knight.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(knight, c);

		// set Victory Point card
		victoryPoints = new JLabel(": " + controller.getPlayerVictoryPointCard());
		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 3;
		victoryPoints.setIcon(cardUniversity);
		victoryPoints.setForeground(Color.BLACK);
		victoryPoints.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(victoryPoints, c);

		// set tools card
		tools = new JLabel(": " + controller.getPlayerToolsCard());
		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 4;
		tools.setIcon(cardTools);
		tools.setForeground(Color.BLACK);
		tools.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(tools, c);

		// set invention card
		invention = new JLabel(": " + controller.getPlayerInventionCard());
		c.insets = new Insets(0, 0, 15, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 5;
		invention.setIcon(cardInvention);
		invention.setForeground(Color.BLACK);
		invention.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(invention, c);

		// set play monopoly button
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 1;
		this.add(playMonopoly, c);
		playMonopoly.addActionListener(this);

		// set knight play button
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 2;
		this.add(playKnight, c);
		playKnight.addActionListener(this);

		// set university play button
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 3;
		this.add(playVictory, c);
		playVictory.addActionListener(this);

		// set tools play button
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 4;
		this.add(playTools, c);
		playTools.addActionListener(this);

		// set invention play buttons

		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 5;
		this.add(playInvention, c);
		playInvention.addActionListener(this);

	}

	public void allInfo() {
		JLabel enemyTitle = new JLabel("Tegenstanders Info");
		enemyTitle.setFont(new Font("Arial", Font.BOLD, 30));
		enemyTitle.setForeground(Color.BLACK);

		c.insets = new Insets(0, 0, 50, 0);
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 3;
		c.gridy = 0;
		add(enemyTitle, c);

		playerInformation = new ArrayList<JLabel>();

		for (int i = 0; i < 4; i++) { // Prints all user info (Color, Name, Resource Amount and Points
			JLabel info = new JLabel(
					controller.getPlayerName(i) + " - " + "Grondstoffen: " + controller.getPlayerResources(i));

			if (controller.myTurn(i)) {
				info.setText(info.getText());
				info.setIcon(green);
			} else {
				info.setIcon(red);
			}
			// Second JLabel is made to add a second image associated with player building
			// points.
			JLabel victoryPoints = new JLabel("" + controller.getVictoryPoints(i));
			victoryPoints.setIcon(trophy);
			
			JLabel longestAndKnight = new JLabel("");

			if (controller.getPlayerName(i).equals(controller.checkArmy())
					&& controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
				longestAndKnight.setIcon(knightAndRoad);
			} else if (controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
				longestAndKnight.setIcon(longestRoadImage);
			} else if (controller.getPlayerName(i).equals(controller.checkArmy())) {
				longestAndKnight.setIcon(knightImage);
			}
			
			JLabel knightUsed = new JLabel("" + controller.getPlayerKnightUsed(i));
			
			knightUsed.setIcon(cardKnight);

			info.setFont(new Font("Arial", Font.BOLD, 15));

			c.insets = new Insets(20, 0, 0, 0);
			c.anchor = GridBagConstraints.NORTH;
			c.gridx = 3;
			c.gridy = i + 1;

			switch (i) {
			case 0:
				info.setForeground(Color.RED);
				break;
			case 1:
				info.setForeground(Color.WHITE);
				break;
			case 2:
				info.setForeground(Color.BLUE);
				break;
			case 3:
				info.setForeground(Color.ORANGE);
			}
			info.setFont(new Font("Arial", Font.BOLD, 15));
			
			j.insets = new Insets(0, 0, 0, 0);
			j.anchor = GridBagConstraints.WEST;
			j.gridx = 4;
			j.gridy = i + 1;
			
			f.insets = new Insets(0, 0, 0, 0);
			f.anchor = GridBagConstraints.WEST;
			f.gridx = 5;
			f.gridy = i + 1;

			x.insets = new Insets(0, 0, 0, 0);
			x.anchor = GridBagConstraints.WEST;
			x.gridx = 6;
			x.gridy = i + 1;
			
		
			
			this.add(info, c);
			playerInformation.add(info);
			this.add(longestAndKnight, j);
			playerInformation.add(longestAndKnight);
			this.add(knightUsed, f);
			playerInformation.add(knightUsed);
			this.add(victoryPoints, x);
			playerInformation.add(victoryPoints);
			
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
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 7;
		this.add(end, c);
		end.addActionListener(this);
		disableEndButton();
	}

	public void wonButton() {
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 7;
		this.add(won, c);
		won.addActionListener(this);

		for (int i = 0; i < 4; i++) {
			if (controller.myTurn(i)) {
				enableWonButton();
			}
		}
	}

	public void enablePlayButton() { //this method enables the various Dev. Cards if and only if the player has atleast one of such cards.
		if (controller.getPlayerMonopolyCard() >= 1) {
			playMonopoly.setBackground(new Color(5, 162, 0));
			playMonopoly.setForeground(Color.WHITE);
			playMonopoly.setEnabled(true);
		} else {
			playMonopoly.setBackground(new Color(163, 0, 0));
			playMonopoly.setForeground(Color.BLACK);
			playMonopoly.setEnabled(false);
		}

		if (controller.getPlayerKnightCard() >= 1) {
			playKnight.setBackground(new Color(5, 162, 0));
			playKnight.setForeground(Color.WHITE);
			playKnight.setEnabled(true);
		} else {
			playKnight.setBackground(new Color(163, 0, 0));
			playKnight.setForeground(Color.BLACK);
			playKnight.setEnabled(false);
		}

		if (controller.getPlayerToolsCard() >= 1) {
			playTools.setBackground(new Color(5, 162, 0));
			playTools.setForeground(Color.WHITE);
			playTools.setEnabled(true);
		} else {
			playTools.setBackground(new Color(163, 0, 0));
			playTools.setForeground(Color.BLACK);
			playTools.setEnabled(false);
		}

		if (controller.getPlayerVictoryPointCard() >= 1) {
			playVictory.setBackground(new Color(5, 162, 0));
			playVictory.setForeground(Color.WHITE);
			playVictory.setEnabled(true);
		} else {
			playVictory.setBackground(new Color(163, 0, 0));
			playVictory.setForeground(Color.BLACK);
			playVictory.setEnabled(false);
		}

		if (controller.getPlayerInventionCard() >= 1) {
			playInvention.setBackground(new Color(5, 162, 0));
			playInvention.setForeground(Color.WHITE);
			playInvention.setEnabled(true);
		} else {
			playInvention.setBackground(new Color(163, 0, 0));
			playInvention.setForeground(Color.BLACK);
			playInvention.setEnabled(false);
		}
	}
	
	public void disablePlayButton() { //This method is created to completely disable the play cards buttons if it's not the players' turn.
		playMonopoly.setBackground(new Color(163, 0, 0));
		playMonopoly.setForeground(Color.BLACK);
		playMonopoly.setEnabled(false);
		
		playKnight.setBackground(new Color(163, 0, 0));
		playKnight.setForeground(Color.BLACK);
		playKnight.setEnabled(false);
		
		playTools.setBackground(new Color(163, 0, 0));
		playTools.setForeground(Color.BLACK);
		playTools.setEnabled(false);
		
		playVictory.setBackground(new Color(163, 0, 0));
		playVictory.setForeground(Color.BLACK);
		playVictory.setEnabled(false);
		
		playInvention.setBackground(new Color(5, 162, 0));
		playInvention.setForeground(Color.WHITE);
		playInvention.setEnabled(true);
		
		playInvention.setBackground(new Color(163, 0, 0));
		playInvention.setForeground(Color.BLACK);
		playInvention.setEnabled(false);
		
	}

	public void enableWonButton() {
		if (controller.playerHasWon()) {
			won.setBackground(new Color(5, 162, 0));
			won.setForeground(Color.WHITE);
			won.setEnabled(true);
		} else {
			won.setBackground(new Color(163, 0, 0));
			won.setForeground(Color.BLACK);
			won.setEnabled(false);
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
	}

	public void DisableTradeButton() {
		trade.setBackground(new Color(163, 0, 0));
		trade.setForeground(Color.BLACK);
		trade.setEnabled(false);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(trade)) {
			getTradePanel();
		} else if (arg0.getSource().equals(close)) {
			System.exit(0);
		} else if (arg0.getSource().equals(end)) {
			controller.endTurn();
		}

	}

	public void getTradePanel() {
		controller.getTradePanel();
	}
}
