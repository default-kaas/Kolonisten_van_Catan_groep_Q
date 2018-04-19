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
		
		
		 
		ImageIcon road = new ImageIcon("images/Buy/road.png");
		road.setDescription("Road");
		JLabel roadLabel = new JLabel(road);
		c.insets = new Insets(0, 0, 5, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(roadLabel, c);
		
		JButton buyRoad = new JButton("Buy Road");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 1;
		this.add(buyRoad, c);
		
	
		ImageIcon house = new ImageIcon("images/Buy/home.png");
		house.setDescription("Road");
		JLabel houseLabel = new JLabel(house);
		//c.insets = new Insets(0, 0, 5, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		this.add(houseLabel, c);
		
		
		JButton buyHouse = new JButton("Buy House");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 2;
		c.gridy = 2;
		this.add(buyHouse, c);
		
		
		ImageIcon city = new ImageIcon("images/Buy/city.png");
		city.setDescription("Road");
		JLabel cityLabel = new JLabel(city);
		c.insets = new Insets(0, 0, 5, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(cityLabel, c);
		
		
		JButton buyCity = new JButton("Buy City");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 2;
		c.gridy = 3;
		this.add(buyCity, c);
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size) / 2);
		
		
		this.setBorder(title);
		this.setPreferredSize(new Dimension(width, (int) (screenSize.getHeight() * 0.5)));
		this.setBackground(Color.LIGHT_GRAY);
	}
}
