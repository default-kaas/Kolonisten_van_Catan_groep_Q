/*Bugs waar ik van op de hoogte ben (to-do listje):
- De TradeInputLimit werkt niet.
- Insets moet worden veranderd indien mogelijk. 
- Ruilen met een speler kan nog niet, maar ik heb een idee hoe dit niet al te moeilijk kan worden gemaakt. 
- Havens detecteren door de database
- Verder zijn er nog wat kleine bugs die gefixt moeten worden m.b.t. traden met de bank. Testen we later. 
- De actionperforms werken nog niet. */

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

public class TradePanel extends JPanel implements ActionListener {

	private TradeController tc;

	private BufferedImage schaap, hooi, hout, steen, erts;
	private JLabel panel, yourCards, theirCards;

	private JButton propose;
	private JLabel your_wool, your_wheat, your_wood, your_stone, your_ore;
	private JLabel resource_input;
	private JTextField your_woolt, your_wheatt, your_woodt, your_stonet, your_oret;
	private JLabel their_input;
	private JTextField their_woolt, their_wheatt, their_woodt, their_stonet, their_oret;
	
	private JLabel playerdd;
	private JComboBox<String> cb;

	JPanel trade;

	public TradePanel(TradeController tradePanelController) {

		tc = tradePanelController;

	}

	public void showFrame() {
		
		System.out.println("works");
		System.out.println("kappa");
		
		trade = new JPanel();

		trade.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;

		trade.setBackground(Color.white);
		// trade.setVisible(false);
		trade.setPreferredSize(new Dimension(1000, 600));
		trade.setBackground(new Color(245, 245, 220));
		trade.setVisible(true);

		createStuff();
		importImages();

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

		playerdd = new JLabel("Hoe wil je ruilen?");
		cb = new JComboBox<String>();
		cb.addItem("Spelers");
		cb.addItem("De Bank");

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

		TradeNoLetters tnl = new TradeNoLetters();
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

	}

	boolean bank_has_card_available = false;

	public void setAvailability(boolean availability) {
		if (availability == true) {
			this.bank_has_card_available = true;
		}
		if (availability == false) {
			this.bank_has_card_available = false;
		}
	}

	private void createStuff() {

		panel = new JLabel("Handelspaneel");
		yourCards = new JLabel("Aanbod:");
		propose = new JButton("Stel handel voor");
		propose.addActionListener(this);
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
	
	private void addActionListeners() {
		propose.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(propose)) {
			Object item = cb.getSelectedItem();
			if (item.toString().equals("Spelers")) {
				JOptionPane.showMessageDialog(trade, "Wordt aan gewerkt!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			if (item.toString().equals("De Bank")) {
				// het volgende spreekt voor zich.
				boolean er_bestaan_nog_geen_havens_dus_is_het_voor_nu_alleen_nog_maar_4x1 = true;
				if (er_bestaan_nog_geen_havens_dus_is_het_voor_nu_alleen_nog_maar_4x1 == true) {
					// if statement hieronder: Kijken of er links een 4 en rechts een 1 is ingevuld.
					if ((your_woolt.getText().equals("4") || your_wheatt.getText().equals("4") || your_stonet.getText().equals("4") || your_woodt.getText().equals("4") || your_oret.getText().equals("4")) && 
						(their_woolt.getText().equals("1") || their_wheatt.getText().equals("1") || their_stonet.getText().equals("1") || their_woodt.getText().equals("1") || their_oret.getText().equals("1"))) {
						// if statement hieronder: Hier wordt strikt gecontrolleerd of dat er aan BEIDE
						// kanten precies één JTextField is ingevuld.
						if ((!your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty()
								&& your_stonet.getText().isEmpty() && your_woodt.getText().isEmpty()
								&& your_oret.getText().isEmpty())
								|| (your_woolt.getText().isEmpty() && !your_wheatt.getText().isEmpty()
										&& your_stonet.getText().isEmpty() && your_woodt.getText().isEmpty()
										&& your_oret.getText().isEmpty())
								|| (your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty()
										&& !your_stonet.getText().isEmpty() && your_woodt.getText().isEmpty()
										&& your_oret.getText().isEmpty())
								|| (your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty()
										&& your_stonet.getText().isEmpty() && !your_woodt.getText().isEmpty()
										&& your_oret.getText().isEmpty())
								|| (your_woolt.getText().isEmpty() && your_wheatt.getText().isEmpty()
										&& your_stonet.getText().isEmpty() && your_woodt.getText().isEmpty()
										&& !your_oret.getText().isEmpty())
										&& (!their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty()
												&& their_stonet.getText().isEmpty()
												&& their_woodt.getText().isEmpty()
												&& their_oret.getText().isEmpty())
								|| (their_woolt.getText().isEmpty() && !their_wheatt.getText().isEmpty()
										&& their_stonet.getText().isEmpty() && their_woodt.getText().isEmpty()
										&& their_oret.getText().isEmpty())
								|| (their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty()
										&& !their_stonet.getText().isEmpty() && their_woodt.getText().isEmpty()
										&& their_oret.getText().isEmpty())
								|| (their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty()
										&& their_stonet.getText().isEmpty() && !their_woodt.getText().isEmpty()
										&& their_oret.getText().isEmpty())
								|| (their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty()
										&& their_stonet.getText().isEmpty() && their_woodt.getText().isEmpty()
										&& !their_oret.getText().isEmpty())) {
							// onderstaande if statements: hier wordt actie ondernomen en de handel met de
							// bank (4x1) afgerond.
							// b=baksteen, w=wol, h=hout, e=erts, g=graan
							// 1=w, 2=g, 3=h, 4=b, 5=e
							if (your_woolt.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								tc.setPlayerCards("w", -4);
							}
							if (your_wheatt.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								tc.setPlayerCards("g", -4);
							}
							if (your_stonet.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								tc.setPlayerCards("h", -4);
							}
							if (your_woodt.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								tc.setPlayerCards("b", -4);
							}
							if (your_oret.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								tc.setPlayerCards("e", -4);
							}
							if (their_woolt.getText().equals("1")) {
								tc.doesBankHave("w");
								if (bank_has_card_available == true) {
									tc.setPlayerCards("w", 1);
								}
							}
							if (their_wheatt.getText().equals("1")) {
								tc.doesBankHave("g");
								if (bank_has_card_available == true) {
									tc.setPlayerCards("g", 1);
								}
							}
							if (their_stonet.getText().equals("1")) {
								tc.doesBankHave("h");
								if (bank_has_card_available == true) {
									tc.setPlayerCards("h", 1);
								}
							}
							if (their_woodt.getText().equals("1")) {
								tc.doesBankHave("b");
								if (bank_has_card_available == true) {
									tc.setPlayerCards("b", 1);
								}
							}
							if (their_oret.getText().equals("1")) {
								tc.doesBankHave("e");
								if (bank_has_card_available == true) {
									tc.setPlayerCards("e", 1);
								}
							}
							JOptionPane.showMessageDialog(trade, "Je hebt successvol gehandeld met de bank!",
									"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(trade,
									"Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.",
									"Verkeerde input!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(trade,
								"Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.",
								"Verkeerde input!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(trade,
							"Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.",
							"Verkeerde input!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}	
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
