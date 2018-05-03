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
import javax.swing.JOptionPane;
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
 
	private JLabel panel;
	private JLabel yourCards;
	private JButton propose;
	private JLabel theirCards;

	private JLabel your_wool;
	private JLabel your_wheat;
	private JLabel your_wood;
	private JLabel your_stone;
	private JLabel your_ore;

	private JLabel resource_input;
	private JTextField your_woolt;
	private JTextField your_wheatt;
	private JTextField your_woodt;
	private JTextField your_stonet;
	private JTextField your_oret;

	private JLabel their_input;
	private JTextField their_woolt;
	private JTextField their_wheatt;
	private JTextField their_woodt;
	private JTextField their_stonet;
	private JTextField their_oret;
	
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

		createStuff();
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
		
		JLabel playerdd = new JLabel("Hoe wil je ruilen?");
        JComboBox<String> cb = new JComboBox<String>();
        cb.addItem("Spelers");
        cb.addItem("De Bank");

		c.insets = new Insets(250, 0, 0, 0);
		trade.add(playerdd, c);
		c.insets = new Insets(280, 0, 0, 0);
		trade.add(cb, c);
		
		TradeNoLetters tnl = new TradeNoLetters();
		
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
	    doc.setDocumentFilter(tnl);
		PlainDocument doc2 = (PlainDocument) your_wheatt.getDocument();
	    doc2.setDocumentFilter(tnl);
		PlainDocument doc3 = (PlainDocument) your_woodt.getDocument();
	    doc3.setDocumentFilter(tnl);
		PlainDocument doc4 = (PlainDocument) your_stonet.getDocument();
	    doc4.setDocumentFilter(tnl);
		PlainDocument doc5 = (PlainDocument) your_oret.getDocument();
	    doc5.setDocumentFilter(tnl);
		PlainDocument doc6 = (PlainDocument) their_woolt.getDocument();
	    doc6.setDocumentFilter(tnl);
		PlainDocument doc7 = (PlainDocument) their_wheatt.getDocument();
	    doc7.setDocumentFilter(tnl);
		PlainDocument doc8 = (PlainDocument) their_woodt.getDocument();
	    doc8.setDocumentFilter(tnl);
		PlainDocument doc9 = (PlainDocument) their_stonet.getDocument();
	    doc9.setDocumentFilter(tnl);
		PlainDocument doc10 = (PlainDocument) their_oret.getDocument();
	    doc10.setDocumentFilter(tnl);

		this.add(trade);

		propose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = cb.getSelectedItem();
				if(item.toString().equals("Spelers")) {
					JOptionPane.showMessageDialog(trade, "Wordt aan gewerkt!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				if(item.toString().equals("De Bank")) {
					//het volgende spreekt voor zich.
					boolean er_bestaan_nog_geen_havens_dus_is_het_voor_nu_alleen_nog_maar_4x1 = true;
					if (er_bestaan_nog_geen_havens_dus_is_het_voor_nu_alleen_nog_maar_4x1 == true) {
						//if statement hieronder: Kijken of er aan beide kanten iets is ingevuld.
						if ((your_woolt.getText().equals("4") || your_wheatt.getText().equals("4") || your_stonet.getText().equals("4") || your_woodt.getText().equals("4") || your_oret.getText().equals("4")) 
							&& (their_woolt.getText().equals("1") || their_wheatt.getText().equals("1") || their_stonet.getText().equals("1") || their_woodt.getText().equals("1") || their_oret.getText().equals("1") )) {
							//if statement hieronder: Dit is een lange. Ik weet het. Maar hier wordt strikt gecontrolleerd of dat er aan BEIDE kanten precies ��n JTextField is ingevuld.
							if ( (!your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty() && your_stonet.getText().isEmpty() && 
								your_woodt.getText().isEmpty() && your_oret.getText().isEmpty() ) ||
								( your_woolt.getText().isEmpty() && !your_wheatt.getText().isEmpty() && your_stonet.getText().isEmpty() && 
								your_woodt.getText().isEmpty() && your_oret.getText().isEmpty() ) ||
								( your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty() && !your_stonet.getText().isEmpty() && 
								your_woodt.getText().isEmpty() && your_oret.getText().isEmpty() ) ||
								( your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty() && your_stonet.getText().isEmpty() && 
								!your_woodt.getText().isEmpty() && your_oret.getText().isEmpty() ) ||
								( your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty() && your_stonet.getText().isEmpty() && 
								your_woodt.getText().isEmpty() && !your_oret.getText().isEmpty() ) 
								&&
								( !their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty() && their_stonet.getText().isEmpty() && 
								their_woodt.getText().isEmpty() && their_oret.getText().isEmpty() ) ||
								( their_woolt.getText().isEmpty() && !their_wheatt.getText().isEmpty() && their_stonet.getText().isEmpty() && 
								their_woodt.getText().isEmpty() && their_oret.getText().isEmpty() ) ||
								( their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty() && !their_stonet.getText().isEmpty() && 
								their_woodt.getText().isEmpty() && their_oret.getText().isEmpty() ) ||
								( their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty() && their_stonet.getText().isEmpty() && 
								!their_woodt.getText().isEmpty() && their_oret.getText().isEmpty() ) ||
								( their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty() && their_stonet.getText().isEmpty() && 
								their_woodt.getText().isEmpty() && !their_oret.getText().isEmpty() ) ) {
									//onderstaande if statements: hier wordt actie ondernomen en de handel met de bank (4x1) afgerond.
									if (your_woolt.getText().equals("4") && tc.getPlayerCards(1) > 4) {
										tc.setPlayerCards(1, -4);
									}
									if (your_wheatt.getText().equals("4") && tc.getPlayerCards(1) >= 4) {
										tc.setPlayerCards(2, -4);
									}
									if (your_stonet.getText().equals("4") && tc.getPlayerCards(1) >= 4) {
										tc.setPlayerCards(4, -4);
									}
									if (your_woodt.getText().equals("4") && tc.getPlayerCards(1) >= 4) {
										tc.setPlayerCards(3, -4);
									}
									if (your_oret.getText().equals("4") && tc.getPlayerCards(1) >= 4) {
										tc.setPlayerCards(5, -4);
									}
									if (their_woolt.getText().equals("1")) {
										tc.setPlayerCards(1, 1);
									}
									if (their_wheatt.getText().equals("1")) {
										tc.setPlayerCards(2, 1);
									}
									if (their_stonet.getText().equals("1")) {
										tc.setPlayerCards(4, 1);
									}
									if (their_woodt.getText().equals("1")) {
										tc.setPlayerCards(3, 1);
									}
									if (their_oret.getText().equals("1")) {
										tc.setPlayerCards(5, 1);
									}
									JOptionPane.showMessageDialog(trade, "Je hebt successvol gehandeld met de bank!", "Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(trade, "Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.", "Verkeerde input!", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(trade, "Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.", "Verkeerde input!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		trade.setVisible(true);
		
		setupFrame();
		
	}

	private void setupFrame() {

		//this.setUndecorated(true); raar dat het errors geeft, later even checken
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	private void createStuff() {
		
		panel = new JLabel("Handelspaneel");
		yourCards = new JLabel("Aanbod:");
		propose = new JButton("Stel handel voor");
		your_wool = new JLabel("" + tc.getPlayerCards(1));
		your_wheat = new JLabel("" + tc.getPlayerCards(2));
		your_wood = new JLabel("" + tc.getPlayerCards(3));
		your_stone = new JLabel("" + tc.getPlayerCards(4));
		your_ore = new JLabel("" + tc.getPlayerCards(5));
		theirCards = new JLabel("Vraag:");
		resource_input = new JLabel("Input:");
		your_woolt = new JTextField(2);
		your_wheatt = new JTextField(2);
		your_woodt = new JTextField(2);
		your_stonet = new JTextField(2);
		your_oret = new JTextField(2);
		their_input = new JLabel("Input:");
		their_woolt = new JTextField(2);
		their_wheatt = new JTextField(2);
		their_woodt = new JTextField(2);
		their_stonet = new JTextField(2);
		their_oret = new JTextField(2);
		
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
