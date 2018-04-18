package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Model.Player;

public class SpelerInformatiePanel extends JPanel implements ActionListener {
	// private Player speler1 = new Player();
	private JButton close;
	private BufferedImage WoolImage;
	private BufferedImage WheatImage;
	private BufferedImage WoodImage;
	private BufferedImage StoneImage;
	private BufferedImage OreImage;

	public SpelerInformatiePanel() {
		close = new JButton("Close game!");
		this.add(close);
		close.addActionListener(this);

		try {
			WoolImage = ImageIO.read(new File("images/Wool.png"));
			WheatImage = ImageIO.read(new File("images/Wheat.png"));
			WoodImage = ImageIO.read(new File("images/Wood.png"));
			StoneImage = ImageIO.read(new File("images/Stone.png"));
			OreImage = ImageIO.read(new File("images/Ore.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Dit is ff red voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int size = (int) (screenSize.getHeight() * 0.8);
		int width = (int) ((screenSize.getWidth() - size) / 2);
		this.setPreferredSize(new Dimension(width, (int) (screenSize.getHeight() * 0.5)));
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(WoolImage, 0, 100, (int) (WoolImage.getWidth() * 0.1), (int) (WoolImage.getHeight() * 0.1), this);
		g.drawImage(WheatImage, 50, 100, (int) (WoolImage.getWidth() * 0.1), (int) (WoolImage.getHeight() * 0.1), this);
		g.drawImage(WoodImage, 100, 100, (int) (WoolImage.getWidth() * 0.1), (int) (WoolImage.getHeight() * 0.1), this);
		g.drawImage(StoneImage, 150, 100, (int) (WoolImage.getWidth() * 0.1), (int) (WoolImage.getHeight() * 0.1), this);
		g.drawImage(OreImage, 200, 100, (int) (WoolImage.getWidth() * 0.1), (int) (WoolImage.getHeight() * 0.1), this);
	}

	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
