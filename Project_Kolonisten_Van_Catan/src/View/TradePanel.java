/*Bugs waar ik van op de hoogte ben (to-do listje):
- Insets moet worden veranderd indien mogelijk. 
- Ruilen met een speler kan nog niet, maar ik heb een idee hoe dit niet al te moeilijk kan worden gemaakt. 
- 2x1 werkt niet, nog naar kijken.
- Als je geen kaarten meer heeft, kun je nog wel handelen. = gratis kaarten. */

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
import javax.swing.JLabel;
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

	public TradePanel(TradeController tradePanelController) {

		tc = tradePanelController;
		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(1000, 600));
		this.setBackground(new Color(245, 245, 220));
		this.setVisible(true);
		showFrame();

	}

	public void showFrame() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;

		createStuff();
		importImages();

		c.insets = new Insets(20, 0, 0, 0);
		panel.setFont(new Font("Arial Black", 1, 25));
		this.add(panel, c);

		c.insets = new Insets(100, 0, 0, 730);
		yourCards.setFont(new Font("Monotype Corsiva", 1, 20));
		this.add(yourCards, c);

		c.insets = new Insets(100, 770, 0, 0);
		theirCards.setFont(new Font("Monotype Corsiva", 1, 20));
		this.add(theirCards, c);

		c.insets = new Insets(550, 0, 0, 0);
		this.add(propose, c);

		c.insets = new Insets(160, 0, 0, 620);
		this.add(your_stone, c);
		c.insets = new Insets(230, 0, 0, 620);
		this.add(your_wood, c);
		c.insets = new Insets(300, 0, 0, 620);
		this.add(your_wool, c);
		c.insets = new Insets(370, 0, 0, 620);
		this.add(your_ore, c);
		c.insets = new Insets(440, 0, 0, 620);
		this.add(your_wheat, c);

		c.insets = new Insets(140, 0, 0, 470);
		this.add(resource_input, c);
		c.insets = new Insets(160, 0, 0, 470);
		this.add(your_stonet, c);
		c.insets = new Insets(230, 0, 0, 470);
		this.add(your_woodt, c);
		c.insets = new Insets(300, 0, 0, 470);
		this.add(your_woolt, c);
		c.insets = new Insets(370, 0, 0, 470);
		this.add(your_oret, c);
		c.insets = new Insets(440, 0, 0, 470);
		this.add(your_wheatt, c);

		c.insets = new Insets(140, 630, 0, 0);
		this.add(their_input, c);
		c.insets = new Insets(160, 630, 0, 0);
		this.add(their_stonet, c);
		c.insets = new Insets(230, 630, 0, 0);
		this.add(their_woodt, c);
		c.insets = new Insets(300, 630, 0, 0);
		this.add(their_woolt, c);
		c.insets = new Insets(370, 630, 0, 0);
		this.add(their_oret, c);
		c.insets = new Insets(440, 630, 0, 0);
		this.add(their_wheatt, c);

		playerdd = new JLabel("Hoe wil je ruilen?");
		cb = new JComboBox<String>();
		cb.addItem("Spelers");
		cb.addItem("De Bank");

		c.insets = new Insets(250, 0, 0, 0);
		this.add(playerdd, c);
		c.insets = new Insets(280, 0, 0, 0);
		this.add(cb, c);

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

	}

	private boolean bank_has_card_available = false;

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
	
	// b=baksteen, w=wol, h=hout, e=erts, g=graan
	// 1=w, 2=g, 3=h, 4=b, 5=e
	private boolean W = false;
	private boolean G = false;
	private boolean H = false;
	private boolean B = false;
	private boolean E = false;
	private boolean three = false;
	
	public void set(String charr) {
		if (charr.equals("driehaven")) {
			three = true;
		}
		if (charr.equals("W")) {
			W = true;
		}
		if (charr.equals("G")) {
			G = true;
		}
		if (charr.equals("H")) {
			H = true;
		}
		if (charr.equals("B")) {
			B = true;
		}
		if (charr.equals("E")) {
			E = true;
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(propose)) {
			Object item = cb.getSelectedItem();
			if (item.toString().equals("Spelers")) {
				tc.showScreen(your_wool.getText(), your_woodt.getText(), your_ore.getText(), your_wheatt.getText(), your_stonet.getText(), their_woolt.getText(), their_woodt.getText(), their_oret.getText(), their_wheatt.getText(), their_stonet.getText());
				JOptionPane.showMessageDialog(this, "Wordt aan gewerkt!", "ERROR", JOptionPane.ERROR_MESSAGE);
				tc.disposeFrame();
			}
			if (item.toString().equals("De Bank")) {
					// het volgende spreekt voor zich.
					// if statement hieronder: Kijken of er links een 4 (of evt. een 3 of een 2) en rechts een 1 is ingevuld.
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
										&& 
									(!their_woolt.getText().isEmpty() && their_wheatt.getText().isEmpty()
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
							boolean availablee = false;
							if (your_woolt.getText().equals("4") && tc.getPlayerCards(1) > 4) {
								availablee = true;
								tc.getHavens("w");
								if (three == true) {
									if (W == true) {
										tc.removePlayerCards("w", 2);
										tc.trademsg1(2, "wol");
									} else {
										tc.removePlayerCards("w", 3);
										tc.trademsg1(3, "wol");
									}
								} else {
									tc.removePlayerCards("w", 4);
									tc.trademsg1(4, "wol");
								}
							}
							if (your_wheatt.getText().equals("4") && tc.getPlayerCards(2) > 4) {
								availablee = true;
								tc.getHavens("g");
								if (three == true) {
									if (G == true) {
										tc.removePlayerCards("g", 2);
										tc.trademsg1(2, "graan");
									} else {
										tc.removePlayerCards("g", 3);
										tc.trademsg1(3, "graan");
									}
								} else {
									tc.removePlayerCards("g", 4);
									tc.trademsg1(4, "graan");
								}
							}
							if (your_stonet.getText().equals("4") && tc.getPlayerCards(4) > 4) {
								availablee = true;
								tc.getHavens("b");
								if (three == true) {
									if (B == true) {
										tc.removePlayerCards("b", 2);
										tc.trademsg1(2, "baksteen");
									} else {
										tc.removePlayerCards("b", 3);
										tc.trademsg1(3, "baksteen");
									}
								} else {
									tc.removePlayerCards("b", 4);
									tc.trademsg1(4, "baksteen");
								}
							}
							if (your_woodt.getText().equals("4") && tc.getPlayerCards(3) > 4) {
								availablee = true;
								tc.getHavens("h");
								if (three == true) {
									if (H == true) {
										tc.removePlayerCards("h", 2);
										tc.trademsg1(2, "hout");
									} else {
										tc.removePlayerCards("h", 3);
										tc.trademsg1(3, "hout");
									}
								} else {
									tc.removePlayerCards("h", 4);
									tc.trademsg1(4, "hout");
								}
							}
							if (your_oret.getText().equals("4") && tc.getPlayerCards(5) > 4) {
								availablee = true;
								tc.getHavens("e");
								if (three == true) {
									if (E == true) {
										tc.removePlayerCards("e", 2);
										tc.trademsg1(2, "erts");
									} else {
										tc.removePlayerCards("e", 3);
										tc.trademsg1(3, "erts");
									}
								} else {
									tc.removePlayerCards("e", 4);
									tc.trademsg1(4, "erts");
								}
							}
							if (their_woolt.getText().equals("1")) {
								tc.doesBankHave("w");
								if (availablee = true) {
									if (bank_has_card_available == true) {
										tc.setPlayerCards("w", 1);
										tc.trademsg2(1, "wol");
										JOptionPane.showMessageDialog(this, "Je hebt successvol gehandeld met de bank!",
												"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
										tc.disposeFrame();
									} else {
										JOptionPane.showMessageDialog(this,
												"De bank heeft geen kaarten beschikbaar meer!",
												"Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this,
									"Je hebt niet de benodigde kaarten!",
									"Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							if (their_wheatt.getText().equals("1")) {
								tc.doesBankHave("g");
								if (availablee = true) {
									if (bank_has_card_available == true) {
										tc.setPlayerCards("g", 1);
										tc.trademsg2(1, "graan");
										JOptionPane.showMessageDialog(this, "Je hebt successvol gehandeld met de bank!",
												"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
										tc.disposeFrame();
									} else {
										JOptionPane.showMessageDialog(this,
												"De bank heeft geen kaarten beschikbaar meer!",
												"Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this,
									"Je hebt niet de benodigde kaarten!",
									"Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							if (their_stonet.getText().equals("1")) {
								tc.doesBankHave("b");
								if (availablee = true) {
									if (bank_has_card_available == true) {
										tc.setPlayerCards("b", 1);
										tc.trademsg2(1, "baksteen");
										JOptionPane.showMessageDialog(this, "Je hebt successvol gehandeld met de bank!",
												"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
										tc.disposeFrame();
									} else {
										JOptionPane.showMessageDialog(this,
												"De bank heeft geen kaarten beschikbaar meer!",
												"Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this,
									"Je hebt niet de benodigde kaarten!",
									"Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							if (their_woodt.getText().equals("1")) {
								tc.doesBankHave("h");
								if (availablee = true) {
									if (bank_has_card_available == true) {
										tc.setPlayerCards("h", 1);
										tc.trademsg2(1, "hout");
										JOptionPane.showMessageDialog(this, "Je hebt successvol gehandeld met de bank!",
												"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
										tc.disposeFrame();
									} else {
										JOptionPane.showMessageDialog(this,
												"De bank heeft geen kaarten beschikbaar meer!",
												"Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this,
									"Je hebt niet de benodigde kaarten!",
									"Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							if (their_oret.getText().equals("1")) {
								tc.doesBankHave("e");
								if (availablee = true) {
									if (bank_has_card_available == true) {
										tc.setPlayerCards("e", 1);
										tc.trademsg2(1, "erts");
										JOptionPane.showMessageDialog(this, "Je hebt successvol gehandeld met de bank!",
												"Handelsbericht.", JOptionPane.INFORMATION_MESSAGE);
										tc.disposeFrame();
									} else {
										JOptionPane.showMessageDialog(this,
												"De bank heeft geen kaarten beschikbaar meer!",
												"Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this,
									"Je hebt niet de benodigde kaarten!",
									"Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						} else {
							JOptionPane.showMessageDialog(this,
									"Je hebt het schema verkeerd ingevuld. Alstublieft opnieuw proberen.",
									"Verkeerde input!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this,
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
		g.drawImage(schaap, 25, 292, 70, 70, yourCards);
		g.drawImage(hooi, 25, 434, 70, 70, yourCards);
		g.drawImage(hout, 25, 221, 70, 70, yourCards);
		g.drawImage(steen, 25, 150, 70, 70, yourCards);
		g.drawImage(erts, 25, 363, 70, 70, yourCards);
		g.drawImage(schaap, 905, 292, 70, 70, yourCards);
		g.drawImage(hooi, 905, 434, 70, 70, yourCards);
		g.drawImage(hout, 905, 221, 70, 70, yourCards);
		g.drawImage(steen, 905, 150, 70, 70, yourCards);
		g.drawImage(erts, 905, 363, 70, 70, yourCards);
	}

}
