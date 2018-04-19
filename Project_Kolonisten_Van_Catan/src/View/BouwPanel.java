package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BouwPanel extends JPanel {
	private TitledBorder title;

	public BouwPanel() {

		// Dit is ff LightGray voor een test, mag je weghalen
		// this.setPreferredSize(new Dimension(300,475));

		// Creates a title inside the panel.
		title = new TitledBorder("Kopen & Bouwen");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		title.setTitleFont(new Font("Arial", Font.BOLD, 20));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel type = new JLabel("Soort");
		type.setFont(new Font("Arial", Font.BOLD, 20));
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(type, c);
		
		JLabel price = new JLabel("Kosten");
		price.setFont(new Font("Arial", Font.BOLD, 20));
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 1;
		this.add(price, c);
		
		JLabel buy = new JLabel("Kopen");
		buy.setFont(new Font("Arial", Font.BOLD, 20));
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 1;
		this.add(buy, c);
		
		//street images
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

		JButton buyRoad = new JButton("Buy Road");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 2;
		this.add(buyRoad, c);
		
		//house images
		ImageIcon house = new ImageIcon("images/Buy/home.png");
		house.setDescription("House");
		JLabel houseLabel = new JLabel(house);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(houseLabel, c);
		
		JLabel houseStone = new JLabel(stone);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		this.add(houseStone, c);
		
		
		JLabel houseWood = new JLabel(wood);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 3;
		c.gridy = 3;
		this.add(houseWood, c);
		
		ImageIcon wheat = new ImageIcon("images/Resources/wheat1.png");
		JLabel houseWheat = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 3;
		this.add(houseWheat, c);
		
		ImageIcon wool1 = new ImageIcon("images/Resources/sheep1.png");
		JLabel houseWool = new JLabel(wool1);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 3;
		this.add(houseWool, c);



		JButton buyHouse = new JButton("Buy House");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 3;
		this.add(buyHouse, c);
		
		//city images

		ImageIcon city = new ImageIcon("images/Buy/city.png");
		city.setDescription("Road");
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
		
		JLabel cityWheat1 = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5;
		c.gridy = 4;
		this.add(cityWheat1, c);
		
		JLabel cityWheat2 = new JLabel(wheat);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 6;
		c.gridy = 4;
		this.add(cityWheat2, c);
		
		

		JButton buyCity = new JButton("Buy City");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 7;
		c.gridy = 4;
		this.add(buyCity, c);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size) / 2);

		this.setBorder(title);
		this.setPreferredSize(new Dimension(width, (int) (screenSize.getHeight() * 0.5)));
		this.setBackground(Color.LIGHT_GRAY);
	}
}
