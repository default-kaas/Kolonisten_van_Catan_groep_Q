package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		
		ImageIcon road = new ImageIcon("images/road.png");
		road.setDescription("Road");
		JLabel roadLabel = new JLabel(road);
		
		ImageIcon home = new ImageIcon("images/home.png");
		home.setDescription("Road");
		JLabel homeLabel = new JLabel(home);
		
		ImageIcon city = new ImageIcon("images/city.png");
		city.setDescription("Road");
		JLabel cityLabel = new JLabel(city);
		
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size) / 2);
		this.setLayout(new GridLayout(4, 4));
		this.add(roadLabel);
		this.add(homeLabel);
		this.add(cityLabel);
		this.setBorder(title);
		this.setPreferredSize(new Dimension(width, (int) (screenSize.getHeight() * 0.5)));
		this.setBackground(Color.LIGHT_GRAY);
	}
}
