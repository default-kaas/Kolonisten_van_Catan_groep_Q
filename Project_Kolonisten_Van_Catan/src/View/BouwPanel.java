package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class BouwPanel extends JPanel {

	private JButton buyRoad;
	private JButton buyHouse;
	private JButton buyCity;
	private JButton buyDevelopmentCard;
	private TitledBorder title;
	GridBagConstraints c;

	public BouwPanel() {

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
		this.setBackground(Color.LIGHT_GRAY);

		buyRoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		buyHouse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		buyCity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		buyDevelopmentCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
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
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(type, c);

		JLabel price = new JLabel("Kosten");
		price.setFont(new Font("Arial", Font.BOLD, 20));
		price.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 1;
		this.add(price, c);

		JLabel buy = new JLabel("Kopen");
		buy.setFont(new Font("Arial", Font.BOLD, 20));
		buy.setForeground(Color.BLACK);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 1;
		this.add(buy, c);
	}

	public void setRoad() {
		ImageIcon road = new ImageIcon("images/Buy/road.png");
		road.setDescription("Road");
		JLabel roadLabel = new JLabel(road);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		this.add(roadLabel, c);

		ImageIcon stone = new ImageIcon("images/Resources/stone1.png");
		JLabel roadStone = new JLabel(stone);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 2;
		this.add(roadStone, c);

		ImageIcon wood = new ImageIcon("images/Resources/wood1.png");
		JLabel roadWood = new JLabel(wood);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 2;
		this.add(roadWood, c);

		buyRoad = new JButton("Koop Straat");
		buyRoad.setBackground(new Color(59, 89, 182));
		buyRoad.setForeground(Color.WHITE);
		buyRoad.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 2;
		this.add(buyRoad, c);
	}

	public void setHouse() {
		ImageIcon house = new ImageIcon("images/Buy/home.png");
		house.setDescription("House");
		JLabel houseLabel = new JLabel(house);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(houseLabel, c);

		ImageIcon stone1 = new ImageIcon("images/Resources/stone1.png");
		JLabel houseStone = new JLabel(stone1);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 3;
		this.add(houseStone, c);

		ImageIcon wood1 = new ImageIcon("images/Resources/wood1.png");
		JLabel houseWood = new JLabel(wood1);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 3;
		this.add(houseWood, c);

		ImageIcon wheat = new ImageIcon("images/Resources/wheat1.png");
		JLabel houseWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 3;
		this.add(houseWheat, c);

		ImageIcon wool1 = new ImageIcon("images/Resources/sheep1.png");
		JLabel houseWool = new JLabel(wool1);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 6;
		c.gridy = 3;
		this.add(houseWool, c);

		buyHouse = new JButton("Koop Dorp");
		buyHouse.setBackground(new Color(59, 89, 182));
		buyHouse.setForeground(Color.WHITE);
		buyHouse.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 3;
		this.add(buyHouse, c);
	}

	public void setCity() {

		ImageIcon city = new ImageIcon("images/Buy/city.png");
		city.setDescription("City");
		JLabel cityLabel = new JLabel(city);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 4;
		this.add(cityLabel, c);

		ImageIcon ore = new ImageIcon("images/Resources/ore1.png");
		city.setDescription("Ore");
		JLabel cityOre1 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 4;
		this.add(cityOre1, c);

		JLabel cityOre2 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 4;
		this.add(cityOre2, c);

		JLabel cityOre3 = new JLabel(ore);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 4;
		this.add(cityOre3, c);
		ImageIcon wheat1 = new ImageIcon("images/Resources/wheat1.png");
		JLabel cityWheat1 = new JLabel(wheat1);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 4;
		this.add(cityWheat1, c);
		ImageIcon wheat2 = new ImageIcon("images/Resources/wheat1.png");
		JLabel cityWheat2 = new JLabel(wheat2);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 6;
		c.gridy = 4;
		this.add(cityWheat2, c);

		buyCity = new JButton("Koop Stad");
		buyCity.setBackground(new Color(59, 89, 182));
		buyCity.setForeground(Color.WHITE);
		buyCity.setPreferredSize(new Dimension(120, 30));
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 4;
		this.add(buyCity, c);

	}

	public void setDevelopmentCard() {
		ImageIcon development = new ImageIcon("images/Buy/development.png");
		development.setDescription("Development");
		JLabel developmentLabel = new JLabel(development);
		c.anchor = GridBagConstraints.WEST;
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
		c.gridx = 7;
		c.gridy = 5;
		this.add(buyDevelopmentCard, c);

	}
}
