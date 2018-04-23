package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import Controller.TradePanelController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TradeView extends JFrame {

	private TradePanelController tc;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;

	private BufferedImage schaap;
	private BufferedImage hooi;
	private BufferedImage hout;
	private BufferedImage steen;
	private BufferedImage erts;

	private JLabel panel = new JLabel("Handelspaneel");
	private JLabel yourCards = new JLabel("Aanbod:");
	private JButton propose = new JButton("Stel handel voor");
	private JLabel theirCards = new JLabel("Vraag:");

	// het onderstaande moet veranderd worden naar data uit de database
	private JLabel your_wool = new JLabel("0");
	private JLabel your_wheat = new JLabel("2");
	private JLabel your_wood = new JLabel("1");
	private JLabel your_stone = new JLabel("0");
	private JLabel your_ore = new JLabel("3");

	private JLabel resource_input = new JLabel("Input:");
	private JTextField your_woolt = new JTextField(2);
	private JTextField your_wheatt = new JTextField(2);
	private JTextField your_woodt = new JTextField(2);
	private JTextField your_stonet = new JTextField(2);
	private JTextField your_oret = new JTextField(2);

	private JLabel their_input = new JLabel("Input:");
	private JTextField their_woolt = new JTextField(2);
	private JTextField their_wheatt = new JTextField(2);
	private JTextField their_woodt = new JTextField(2);
	private JTextField their_stonet = new JTextField(2);
	private JTextField their_oret = new JTextField(2);

	// het onderstaande moet veranderd worden
	private JLabel playerdd = new JLabel("Hoe wil je ruilen?");
	private String[] players = { "Spelers", "De Bank" };
	private final JComboBox<String> cb = new JComboBox<String>(players);

	public TradeView() {

		JPanel trade = new JPanel();

		trade.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;

		trade.setBackground(Color.white);
		trade.setVisible(true);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int size = (int) (screenSize.getHeight());
//		trade.setPreferredSize(new Dimension(size, size/2));
		trade.setPreferredSize(new Dimension(1000, 600));
		trade.setBackground(new Color(245, 245, 220));

		importImages();
		addMenuBar();

		c.insets = new Insets(20, 0, 0, 0);
		panel.setFont(new Font("Arial Black", 1, 25));
		trade.add(panel, c);

		c.insets = new Insets(100, 0, 0, 730);
		yourCards.setFont(new Font("Monotype Corsiva", 1, 20));
		trade.add(yourCards, c);

		c.insets = new Insets(100, 770, 0, 0);
		theirCards.setFont(new Font("Monotype Corsiva", 1, 20));
		trade.add(theirCards, c);

		c.insets = new Insets(550, 0, 0, 0);
		trade.add(propose, c);

		c.insets = new Insets(160, 0, 0, 620);
		trade.add(your_wool, c);

		c.insets = new Insets(230, 0, 0, 620);

		trade.add(your_wheat, c);
		c.insets = new Insets(300, 0, 0, 620);
		trade.add(your_wood, c);
		c.insets = new Insets(370, 0, 0, 620);
		trade.add(your_stone, c);
		c.insets = new Insets(440, 0, 0, 620);
		trade.add(your_ore, c);

		c.insets = new Insets(140, 0, 0, 470);
		trade.add(resource_input, c);
		c.insets = new Insets(160, 0, 0, 470);
		trade.add(your_woolt, c);
		c.insets = new Insets(230, 0, 0, 470);
		trade.add(your_wheatt, c);
		c.insets = new Insets(300, 0, 0, 470);
		trade.add(your_woodt, c);
		c.insets = new Insets(370, 0, 0, 470);
		trade.add(your_stonet, c);
		c.insets = new Insets(440, 0, 0, 470);
		trade.add(your_oret, c);

		c.insets = new Insets(140, 630, 0, 0);
		trade.add(their_input, c);
		c.insets = new Insets(160, 630, 0, 0);
		trade.add(their_woolt, c);
		c.insets = new Insets(230, 630, 0, 0);
		trade.add(their_wheatt, c);
		c.insets = new Insets(300, 630, 0, 0);
		trade.add(their_woodt, c);
		c.insets = new Insets(370, 630, 0, 0);
		trade.add(their_stonet, c);
		c.insets = new Insets(440, 630, 0, 0);
		trade.add(their_oret, c);

		c.insets = new Insets(250, 0, 0, 0);
		trade.add(playerdd, c);
		c.insets = new Insets(280, 0, 0, 0);
		trade.add(cb, c);

		this.add(trade);

		setupFrame();

		propose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void setupFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("X");
		exit = new JMenuItem("Sluiten");
		menuBar.add(menu);
		menu.add(exit);
		this.setJMenuBar(menuBar);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void importImages() {
		try {
			schaap = ImageIO.read(new File("images/Resources/Wool.png"));
			hooi = ImageIO.read(new File("images/Resources/Wheat.png"));
			hout = ImageIO.read(new File("images/Resources/Wood.png"));
			steen = ImageIO.read(new File("images/Resources/Stone.png"));
			erts = ImageIO.read(new File("images/Resources/Ore.png"));
		} catch (IOException e) {
			System.out.println("ERROR: Reading images didn't work.");
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(schaap, 25, 150, 70, 70, yourCards);
		g.drawImage(hooi, 25, 221, 70, 70, yourCards);
		g.drawImage(hout, 25, 292, 70, 70, yourCards);
		g.drawImage(steen, 25, 363, 70, 70, yourCards);
		g.drawImage(erts, 25, 434, 70, 70, yourCards);
		g.drawImage(schaap, 905, 150, 70, 70, yourCards);
		g.drawImage(hooi, 905, 221, 70, 70, yourCards);
		g.drawImage(hout, 905, 292, 70, 70, yourCards);
		g.drawImage(steen, 905, 363, 70, 70, yourCards);
		g.drawImage(erts, 905, 434, 70, 70, yourCards);
	}

}
