package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.BouwPanelController;

@SuppressWarnings("serial")
public class BouwPanel extends JPanel implements ActionListener {

	private JButton buyRoad;
	private JButton buyHouse;
	private JButton buyCity;
	private JButton buyDevelopmentCard;
	private TitledBorder title;
	private BouwPanelController bouwPanelController;
	GridBagConstraints c;

	public BouwPanel(BouwPanelController bouwPanelController) {
		this.bouwPanelController = bouwPanelController;
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		setTitles();
		setRoad();
		setHouse();
		setCity();
		setDevelopmentCard();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.4);
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(title);
		this.setBackground(new Color(192, 236, 237));
		
		buyRoad.addActionListener(this);
		buyHouse.addActionListener(this);
		buyCity.addActionListener(this);
		buyDevelopmentCard.addActionListener(this);
	}

	public void setTitles() {
		// Sets Panel title
		title = new TitledBorder("Kopen & Bouwen");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		title.setTitleFont(new Font("Arial", Font.BOLD, 20));
		title.setTitleColor(Color.BLACK);

		// Sets images titles
		JLabel type = new JLabel("Soort");
		type.setFont(new Font("Arial", Font.BOLD, 20));
		type.setForeground(Color.BLACK);
		c.insets = new Insets(0, 0, 50, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(type, c);

		JLabel price = new JLabel("Kosten");
		price.setFont(new Font("Arial", Font.BOLD, 20));
		price.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 50, 0);
		c.gridx = 4;
		c.gridy = 1;
		this.add(price, c);

		JLabel buy = new JLabel("Kopen");
		buy.setFont(new Font("Arial", Font.BOLD, 20));
		buy.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 50, 0);
		c.gridx = 7;
		c.gridy = 1;
		this.add(buy, c);
	}

	public void setRoad() {
		ImageIcon road = new ImageIcon("images/Buy/road.png");
		road.setDescription("Road");
		JLabel roadLabel = new JLabel(road);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 30, 50);
		c.gridx = 0;
		c.gridy = 2;
		this.add(roadLabel, c);

		ImageIcon stone = new ImageIcon("images/Resources/stone1.png");
		JLabel roadStone = new JLabel(stone);
		c.insets = new Insets(0, 100, 30, 20);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 2;
		this.add(roadStone, c);

		ImageIcon wood = new ImageIcon("images/Resources/wood1.png");
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
		this.add(buyRoad, c);
	}

	public void setHouse() {
		ImageIcon house = new ImageIcon("images/Buy/home.png");
		house.setDescription("House");
		JLabel houseLabel = new JLabel(house);
		c.insets = new Insets(0, 0, 30, 50);
		c.anchor = GridBagConstraints.WEST;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(houseLabel, c);

		ImageIcon stone1 = new ImageIcon("images/Resources/stone1.png");
		JLabel houseStone = new JLabel(stone1);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 100, 30, 20);
		c.gridx = 3;
		c.gridy = 3;
		this.add(houseStone, c);

		ImageIcon wood1 = new ImageIcon("images/Resources/wood1.png");
		JLabel houseWood = new JLabel(wood1);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);;
		c.gridx = 4;
		c.gridy = 3;
		this.add(houseWood, c);

		ImageIcon wheat = new ImageIcon("images/Resources/wheat1.png");
		JLabel houseWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 5;
		c.gridy = 3;
		this.add(houseWheat, c);

		ImageIcon wool1 = new ImageIcon("images/Resources/sheep1.png");
		JLabel houseWool = new JLabel(wool1);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 50);
		c.gridx = 6;
		c.gridy = 3;
		this.add(houseWool, c);

		buyHouse = new JButton("Koop Dorp");
		buyHouse.setBackground(new Color(59, 89, 182));
		buyHouse.setForeground(Color.WHITE);
		buyHouse.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 50, 30, 0);
		c.gridx = 7;
		c.gridy = 3;
		this.add(buyHouse, c);
	}

	public void setCity() {

		ImageIcon city = new ImageIcon("images/Buy/city.png");
		city.setDescription("City");
		JLabel cityLabel = new JLabel(city);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 0, 30, 100);
		c.gridx = 0;
		c.gridy = 4;
		this.add(cityLabel, c);

		ImageIcon ore = new ImageIcon("images/Resources/ore1.png");
		JLabel cityOre1 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(50, 0, 30, 0);
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
		
		ImageIcon wheat1 = new ImageIcon("images/Resources/wheat1.png");
		JLabel cityWheat1 = new JLabel(wheat1);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 5;
		c.gridy = 4;
		this.add(cityWheat1, c);
		ImageIcon wheat2 = new ImageIcon("images/Resources/wheat1.png");
		JLabel cityWheat2 = new JLabel(wheat2);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 6;
		c.gridy = 4;
		this.add(cityWheat2, c);

		buyCity = new JButton("Koop Stad");
		buyCity.setBackground(new Color(59, 89, 182));
		buyCity.setForeground(Color.WHITE);
		buyCity.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 30, 0);
		c.gridx = 7;
		c.gridy = 4;
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

		ImageIcon ore = new ImageIcon("images/Resources/ore1.png");
		ore.setDescription("Ore");
		JLabel cityOre = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 5;
		this.add(cityOre, c);

		ImageIcon wheat = new ImageIcon("images/Resources/wheat1.png");
		wheat.setDescription("Wheat");
		JLabel cityWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 5;
		this.add(cityWheat, c);

		ImageIcon wool = new ImageIcon("images/Resources/sheep1.png");
		wool.setDescription("Wool");
		JLabel cityWool = new JLabel(wool);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 5;
		this.add(cityWool, c);

		buyDevelopmentCard = new JButton("Koop kaart");
		buyDevelopmentCard.setBackground(new Color(59, 89, 182));
		buyDevelopmentCard.setForeground(Color.WHITE);
		buyDevelopmentCard.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 50, 10, 0);
		c.gridx = 7;
		c.gridy = 5;
		this.add(buyDevelopmentCard, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(buyRoad)) {
			System.out.println(bouwPanelController.checkRecoursesRoad());
			
		}
		
		if (e.getSource().equals(buyHouse)) {
			System.out.println(bouwPanelController.checkResourcesHouse());
		}
		
		if (e.getSource().equals(buyCity)) {
			System.out.println(bouwPanelController.checkResourcesCity());
		}
		
		if (e.getSource().equals(buyDevelopmentCard)) {
			System.out.println(bouwPanelController.checkResourcesDevCard());
		}
		
		
		
	}
}
