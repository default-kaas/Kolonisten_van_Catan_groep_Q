package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.BuildPanelController;

@SuppressWarnings("serial")
public class BuildPanel extends JPanel implements ActionListener {

	private JButton buyRoad;
	private JButton buyHouse;
	private JButton buyCity;
	private JButton buyDevelopmentCard;
	private TitledBorder title;
	private BuildPanelController buildPanelController;
	private GridBagConstraints c;
	private ImageIcon stone = new ImageIcon("images/Resources/stone1.png");
	private ImageIcon wood = new ImageIcon("images/Resources/wood1.png");
	private ImageIcon ore = new ImageIcon("images/Resources/ore1.png");
	private ImageIcon wool = new ImageIcon("images/Resources/sheep1.png");
	private ImageIcon wheat = new ImageIcon("images/Resources/wheat1.png");

	public BuildPanel(BuildPanelController buildPanelController) {
		this.buildPanelController = buildPanelController;
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		setScreenSize();
		setTitles();
		setRoad();
		setHouse();
		setCity();
		setDevelopmentCard();
		buyRoad.addActionListener(this);
		buyHouse.addActionListener(this);
		buyCity.addActionListener(this);
		buyDevelopmentCard.addActionListener(this);

	}

	private void setScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(title);
	}

	public void setTitles() { // This void sets all the initializes Titles.
		Font myFont = new Font("Arial", Font.BOLD, 20);

		title = new TitledBorder("Kopen & Bouwen");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		title.setTitleFont(myFont);
		title.setTitleColor(Color.BLACK);

		JLabel type = new JLabel("Soort");
		type.setFont(myFont);
		type.setForeground(Color.BLACK);
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(type, c);

		JLabel price = new JLabel("Kosten");
		price.setFont(myFont);
		price.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 1;
		this.add(price, c);

		JLabel buy = new JLabel("Kopen");
		buy.setFont(myFont);
		buy.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 7;
		c.gridy = 1;
		this.add(buy, c);
	}

	public void setRoad() { // Sets the Road Image, cost images and buttons.
		ImageIcon road = new ImageIcon("images/Buy/road.png");
		road.setDescription("Road");
		JLabel roadLabel = new JLabel(road);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 30, 50);
		c.gridx = 0;
		c.gridy = 2;
		this.add(roadLabel, c);

		JLabel roadStone = new JLabel(stone);
		c.insets = new Insets(0, 100, 30, 20);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 2;
		this.add(roadStone, c);

		JLabel roadWood = new JLabel(wood);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 50);
		c.gridx = 4;
		c.gridy = 2;
		this.add(roadWood, c);

		buyRoad = new JButton("Koop Straat");
		buyRoad.setBackground(new Color(59, 89, 182));
		buyRoad.setForeground(Color.WHITE);
		buyRoad.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 50, 30, 0);
		c.gridx = 7;
		c.gridy = 2;

		if (buildPanelController.checkRecoursesRoad()) {
			buyRoad.setBackground(new Color(5, 162, 0));
		} else if (!buildPanelController.checkRecoursesRoad()) {
			buyRoad.setBackground(new Color(163, 0, 0));
			buyRoad.setEnabled(false);
		}
		this.add(buyRoad, c);
	}

	public void setHouse() { // sets the House Image, cost images and buttons.
		ImageIcon house = new ImageIcon("images/Buy/home.png");
		house.setDescription("House");
		JLabel houseLabel = new JLabel(house);
		c.insets = new Insets(0, 0, 30, 50);
		c.anchor = GridBagConstraints.WEST;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(houseLabel, c);

		JLabel houseStone = new JLabel(stone);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 100, 30, 20);
		c.gridx = 3;
		c.gridy = 3;
		this.add(houseStone, c);

		JLabel houseWood = new JLabel(wood);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		;
		c.gridx = 4;
		c.gridy = 3;
		this.add(houseWood, c);

		JLabel houseWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 5;
		c.gridy = 3;
		this.add(houseWheat, c);

		JLabel houseWool = new JLabel(wool);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 50);
		c.gridx = 6;
		c.gridy = 3;
		this.add(houseWool, c);

		buyHouse = new JButton("Koop Dorp");
		buyHouse.setPreferredSize(new Dimension(120, 30));
		
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 50, 30, 0);
		c.gridx = 7;
		c.gridy = 3;

		if (buildPanelController.checkResourcesHouse()) {
			buyHouse.setBackground(new Color(5, 162, 0));
			buyHouse.setForeground(Color.WHITE);
		} else if (!buildPanelController.checkResourcesHouse()) {
			buyHouse.setBackground(new Color(163, 0, 0));
			buyHouse.setForeground(Color.BLACK);
			buyHouse.setEnabled(false);
		}
		this.add(buyHouse, c);
	}

	public void setCity() { // sets the City Image, cost images and buttons.

		ImageIcon city = new ImageIcon("images/Buy/city.png");
		city.setDescription("City");
		JLabel cityLabel = new JLabel(city);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 30, 100);
		c.gridx = 0;
		c.gridy = 4;
		this.add(cityLabel, c);

		JLabel cityOre1 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 2;
		c.gridy = 4;
		this.add(cityOre1, c);

		JLabel cityOre2 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 3;
		c.gridy = 4;
		this.add(cityOre2, c);

		JLabel cityOre3 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 4;
		c.gridy = 4;
		this.add(cityOre3, c);

		JLabel cityWheat1 = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 5;
		c.gridy = 4;
		this.add(cityWheat1, c);

		JLabel cityWheat2 = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 6;
		c.gridy = 4;
		this.add(cityWheat2, c);

		buyCity = new JButton("Koop Stad");

		buyCity.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 7;
		c.gridy = 4;

		if (buildPanelController.checkResourcesCity()) {
			buyCity.setBackground(new Color(5, 162, 0));
			buyCity.setForeground(Color.WHITE);
		} else if (!buildPanelController.checkResourcesCity()) {
			buyCity.setBackground(new Color(163, 0, 0));
			buyCity.setForeground(Color.BLACK);
			buyCity.setEnabled(false);
		}
		this.add(buyCity, c);

	}

	public void setDevelopmentCard() {
		ImageIcon development = new ImageIcon("images/Buy/development.png");
		development.setDescription("Development");
		JLabel developmentLabel = new JLabel(development);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 10, 50);
		c.gridx = 0;
		c.gridy = 5;
		this.add(developmentLabel, c);

		ore.setDescription("Ore");
		JLabel cityOre = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 5;
		this.add(cityOre, c);

		wheat.setDescription("Wheat");
		JLabel cityWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 5;
		this.add(cityWheat, c);

		wool.setDescription("Wool");
		JLabel cityWool = new JLabel(wool);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 5;
		this.add(cityWool, c);

		buyDevelopmentCard = new JButton("Koop kaart");
		buyDevelopmentCard.setBackground(new Color(59, 89, 182));
		buyDevelopmentCard.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 50, 10, 0);
		c.gridx = 7;
		c.gridy = 5;

		if (buildPanelController.checkResourcesDevCard()) {
			buyDevelopmentCard.setBackground(new Color(5, 162, 0));
			buyDevelopmentCard.setForeground(Color.WHITE);
		} else if (!buildPanelController.checkResourcesDevCard()) {
			buyDevelopmentCard.setBackground(new Color(163, 0, 0));
			buyDevelopmentCard.setForeground(Color.BLACK);
			buyDevelopmentCard.setEnabled(false);
		}
		this.add(buyDevelopmentCard, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(buyRoad)) {
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Weet je zeker dat je een straat wilt kopen?",
					"Straat Kopen?", JOptionPane.YES_OPTION);
			if (YesOrNo == JOptionPane.YES_OPTION) {
				System.out.println(buildPanelController.checkRecoursesRoad());
			}
		}

		if (e.getSource().equals(buyHouse)) {
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Weet je zeker dat je een dorp wilt kopen?",
					"dorp Kopen?", JOptionPane.YES_OPTION);
			if (YesOrNo == JOptionPane.YES_OPTION) {
				System.out.println(buildPanelController.checkResourcesHouse());
			}

		}

		if (e.getSource().equals(buyCity)) {
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Weet je zeker dat je een stad wilt kopen?",
					"Stad Kopen?", JOptionPane.YES_OPTION);
			if (YesOrNo == JOptionPane.YES_OPTION) {
				System.out.println(buildPanelController.checkResourcesCity());
			}
		}

		if (e.getSource().equals(buyDevelopmentCard)) {
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Weet je zeker dat je een ontwikkelingskaart wilt kopen?",
					"Ontwikkelingskaart Kopen?", JOptionPane.YES_OPTION);
			if (YesOrNo == JOptionPane.YES_OPTION) {
				System.out.println(buildPanelController.checkResourcesDevCard());
			}

		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		// int waardes bovenin aanmaken om dubbele methods te voorkomen.
		super.paintComponent(g);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);

		ImageIcon icon = new ImageIcon("images/Background/buildBg.jpg");
		JLabel thumb = new JLabel(icon);
		thumb.setSize(width, height);
		this.add(thumb);

	}

}
