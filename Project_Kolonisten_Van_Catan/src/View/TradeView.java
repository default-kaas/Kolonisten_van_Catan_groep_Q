package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import Controller.TradeController;
import Model.TradeInputLimit;
import Model.TradeNoLetters;

public class TradeView extends JFrame {

	private TradeController tc;

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
	private JLabel your_wool;
	private JLabel your_wheat;
	private JLabel your_wood;
	private JLabel your_stone;
	private JLabel your_ore;

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

	private JLabel playerdd = new JLabel("Hoe wil je ruilen?");
	private String[] players = { "Spelers", "De Bank" };
	private final JComboBox<String> cb = new JComboBox<String>(players);
	
	JPanel trade;

	public TradeView(TradeController tradePanelController) {
		
		tc = tradePanelController;

	}
	
	public void showFrame() {
		trade = new JPanel();

		this.setAlwaysOnTop (true);
		trade.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;

		trade.setBackground(Color.white);
		trade.setVisible(false);
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
		
		your_wool = new JLabel("" + tc.getPlayerCards(1));
		your_wheat = new JLabel("" + tc.getPlayerCards(2));
		your_wood = new JLabel("" + tc.getPlayerCards(3));
		your_stone = new JLabel("" + tc.getPlayerCards(4));
		your_ore = new JLabel("" + tc.getPlayerCards(5));

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
		
		your_woolt.setDocument(new TradeInputLimit(2));
		your_wheatt.setDocument(new TradeInputLimit(2));
		your_woodt.setDocument(new TradeInputLimit(2));
		your_stonet.setDocument(new TradeInputLimit(2));
		your_oret.setDocument(new TradeInputLimit(2));
		their_woolt.setDocument(new TradeInputLimit(2));
		their_wheatt.setDocument(new TradeInputLimit(2));
		their_woodt.setDocument(new TradeInputLimit(2));
		their_stonet.setDocument(new TradeInputLimit(2));
		their_oret.setDocument(new TradeInputLimit(2));
		PlainDocument doc = (PlainDocument) your_woolt.getDocument();
	    doc.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc2 = (PlainDocument) your_wheatt.getDocument();
	    doc2.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc3 = (PlainDocument) your_woodt.getDocument();
	    doc3.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc4 = (PlainDocument) your_stonet.getDocument();
	    doc4.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc5 = (PlainDocument) your_oret.getDocument();
	    doc5.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc6 = (PlainDocument) their_woolt.getDocument();
	    doc6.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc7 = (PlainDocument) their_wheatt.getDocument();
	    doc7.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc8 = (PlainDocument) their_woodt.getDocument();
	    doc8.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc9 = (PlainDocument) their_stonet.getDocument();
	    doc9.setDocumentFilter(new TradeNoLetters());
		PlainDocument doc10 = (PlainDocument) their_oret.getDocument();
	    doc10.setDocumentFilter(new TradeNoLetters());

		this.add(trade);

		setupFrame();

		propose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		trade.setVisible(true);
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
