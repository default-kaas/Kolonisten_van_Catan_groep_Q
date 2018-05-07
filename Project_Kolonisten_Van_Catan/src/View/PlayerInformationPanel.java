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
	private GridBagConstraints x;
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
	private JLabel monopoly, knight, university, tools, invention;
	

	
	

	// Trade button
	private JButton trade = new JButton("Handelspaneel");

	// end round button
	private JButton end = new JButton("Beurt beëindigen");
	
	//won game button
	private JButton won = new JButton("Gewonnen!");

	private PlayerInfoController controller;
	
	private JLabel stone, wood;

	public PlayerInformationPanel(PlayerInfoController controller) {
		this.controller = controller;
		

		c = new GridBagConstraints();
		x = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);

		// Panel size + Background and border
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(147,147,229));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

	}
	public void UpdateResources() {
		String stoneAmount = ": " + controller.getStoneAmount();
		String woodAmount = ": " + controller.getWoodAmount();
		stone.setText(stoneAmount);
		wood.setText(woodAmount);
		this.repaint();
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

		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		stone = new JLabel(stoneAmount);
		stone.setIcon(stoneImage);
		stone.setForeground(Color.BLACK);
		stone.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(stone, c);

		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		wood = new JLabel(woodAmount);
		wood.setIcon(woodImage);
		wood.setForeground(Color.BLACK);
		wood.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wood, c);

		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		JLabel wool = new JLabel(woolAmount);
		wool.setIcon(woolImage);
		wool.setForeground(Color.BLACK);
		wool.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wool, c);

		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		JLabel ore = new JLabel(oreAmount);
		ore.setIcon(oreImage);
		ore.setForeground(Color.BLACK);
		ore.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(ore, c);

		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 5;
		JLabel wheat = new JLabel(wheatAmount);
		wheat.setIcon(wheatImage);
		wheat.setForeground(Color.BLACK);
		wheat.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(wheat, c);	

	}
	
	public void playerDevelopmentCards() {
		
		//set monopoly card
		monopoly = new JLabel(": 1");
		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		monopoly.setIcon(cardMonopoly);
		monopoly.setForeground(Color.BLACK);
		monopoly.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(monopoly, c);
		
		//set knight card
		knight = new JLabel(": 1");
		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		knight.setIcon(cardKnight);
		knight.setForeground(Color.BLACK);
		knight.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(knight, c);
		
		//set university card
		university = new JLabel(": 1");
		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 3;
		university.setIcon(cardUniversity);
		university.setForeground(Color.BLACK);
		university.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(university, c);
		
		//set tools card
		tools = new JLabel(": 1");
		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		tools.setIcon(cardTools);
		tools.setForeground(Color.BLACK);
		tools.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(tools, c);
		
		//set invention card
		invention = new JLabel(": 1");
		c.insets = new Insets(0, 0, 15, 100);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 5;
		invention.setIcon(cardInvention);
		invention.setForeground(Color.BLACK);
		invention.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(invention, c);
		
		
		
		
	}

	public void allInfo() {
		JLabel enemyTitle = new JLabel("Tegenstanders Info");
		enemyTitle.setFont(new Font("Arial", Font.BOLD, 30));
		enemyTitle.setForeground(Color.BLACK);

		c.insets = new Insets(0, 0, 50, 0);
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 2;
		c.gridy = 0;
		add(enemyTitle, c);

		for (int i = 0; i < 4; i++) { // Prints all user info (Color, Name, Resource Amount and Points
			
			if (controller.myTurn(i)) {
				JLabel turn = new JLabel(controller.getPlayerName(i) + " - "
						+ "Grondstoffen: " + controller.getPlayerResources(i) 	+ " - bezig met beurt!");	
				//Second JLabel is made to add a second image associated with player building points.
				JLabel turn1 = new JLabel("" + controller.getBuildingPoints(i));
				turn1.setIcon(trophy);
			
				if (controller.getPlayerName(i).equals(controller.checkArmy())
						&& controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
					turn.setIcon(knightAndRoad);
				} else if (controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
					turn.setIcon(longestRoadImage);
				} else if (controller.getPlayerName(i).equals(controller.checkArmy())) {
					turn.setIcon(knightImage);
				}
				
				
				turn.setFont(new Font("Arial", Font.BOLD, 15));
				
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTH;
				c.gridx = 2;
				c.gridy = i + 1;
				
				switch(i) {
				case 0 : turn.setForeground(Color.RED);
				break;
				case 1 : turn.setForeground(Color.WHITE);
				break;
				case 2: turn.setForeground(Color.BLUE);
				break;
				case 3: turn.setForeground(Color.ORANGE);
				}
				turn.setFont(new Font("Arial", Font.BOLD, 15));
				
				x.insets = new Insets(0, 0, 0, 0);
				x.anchor = GridBagConstraints.WEST;
				x.gridx = 3;
				x.gridy = i + 1;
				
				
				this.add(turn, c);
				this.add(turn1, x);
			} else {
				JLabel notTurn = new JLabel(controller.getPlayerName(i) + " - "
						+ "Grondstoffen: " + controller.getPlayerResources(i));
				
				JLabel notTurn1 = new JLabel("" + controller.getBuildingPoints(i));
				notTurn1.setIcon(trophy);
				
				if (controller.getPlayerName(i).equals(controller.checkArmy())
						&& controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
					notTurn.setIcon(knightAndRoad);

				} else if (controller.getPlayerName(i).equals(controller.checkLongestRoad())) {
					notTurn.setIcon(longestRoadImage);
				} else if (controller.getPlayerName(i).equals(controller.checkArmy())) {
					notTurn.setIcon(knightImage);
				}
				notTurn.setForeground(Color.BLACK);
				notTurn.setFont(new Font("Arial", Font.BOLD, 15));
				c.insets = new Insets(0, 0, 0, 0);
				c.anchor = GridBagConstraints.NORTH;
				c.gridx = 2;
				c.gridy = i + 1;
				
				
				notTurn1.setFont(new Font("Arial", Font.BOLD, 15));
				
				switch(i) {
				case 0 : notTurn.setForeground(Color.RED);
				break;
				case 1 : notTurn.setForeground(Color.WHITE);
				break;
				case 2: notTurn.setForeground(Color.BLUE);
				break;
				case 3: notTurn.setForeground(Color.ORANGE);
				}
				x.insets = new Insets(0, 0, 0, 0);
				x.anchor = GridBagConstraints.WEST;
				x.gridx = 3;
				x.gridy = i + 1;
				
				this.add(notTurn, c);
				this.add(notTurn1, x);
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
		c.insets = new Insets(0, 0, 0, 0);
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
	
	public void wonButton() {
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 7;
		this.add(won, c);
		won.addActionListener(this);
		
		for (int i = 0; i < 4; i++) {
			if (controller.myTurn(i)) {
				enableWonButton();
			} else {
				disableWonButton();
			}
		}
	}
	
	public void enableWonButton() {
		won.setBackground(new Color(5, 162, 0));
		won.setForeground(Color.WHITE);
		won.setEnabled(true);
	}
	
	public void disableWonButton() {
		won.setBackground(new Color(163, 0, 0));
		won.setForeground(Color.BLACK);
		won.setEnabled(false);
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

//		ImageIcon icon = new ImageIcon("images/Background/playerBg1.jpg"); // sets Panel Background.
//		JLabel thumb = new JLabel(icon);
//		thumb.setSize(width, height);
//		this.add(thumb);
	}

	public void ShowResources() {
		String woodAmount = ": " + controller.getWoodAmount();
		String woolAmount = ": " + controller.getWoolAmount();
		String oreAmount = ": " + controller.getOreAmount();
		String wheatAmount = ": " + controller.getWheatAmount();
		String stoneAmount = ": " + controller.getStoneAmount();
	}
}
