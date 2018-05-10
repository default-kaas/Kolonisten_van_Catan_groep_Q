package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.TradeController;

public class TradePopup extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;
	
	private JPanel panel;
	
	private JLabel introtext;
	private JButton accept;
	private JButton deny;
	
	private JLabel His;
	private JLabel Your;
	
	private JLabel w;
	private JLabel h;
	private JLabel e;
	private JLabel g;
	private JLabel b;
	private JLabel tw;
	private JLabel th;
	private JLabel te;
	private JLabel tg;
	private JLabel tb;
	
	TradeController tc;
	
	
	public TradePopup(TradeController tradeController, String string, String w, String h, String e, String g, String b, String tw, String th, String te, String tg, String tb) {
		
		tc = tradeController;
		panel = new JPanel();
		
		His = new JLabel(string + "s:");
		Your = new JLabel("Yours:");
		
		this.w = new JLabel(w + " Wol");
		this.h = new JLabel(h + " Hout");
		this.e = new JLabel(e + " Erts");
		this.g = new JLabel(g + " Graan");
		this.b = new JLabel(b + " Baksteen");
		this.tw = new JLabel(tw + " Wol");
		this.th = new JLabel(th + " Hout");
		this.te = new JLabel(te + " Erts");
		this.tg = new JLabel(tg + " Graan");
		this.tb = new JLabel(tb + " Baksteen");
		
		introtext = new JLabel(string +" has proposed a trade!");
		
		accept = new JButton("Accept!");
		accept.addActionListener(this);
		deny = new JButton("Deny.");
		deny.addActionListener(this);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel.setPreferredSize(new Dimension(300, 150));
		panel.setBackground(Color.white);
		panel.setBackground(new Color(245, 245, 220));
		panel.setVisible(true);
		
		panel.add(introtext, gbc);
		panel.add(accept);
		panel.add(deny, gbc);
		panel.add(His);
		panel.add(Your, gbc);
		
		panel.add(this.w);
		panel.add(this.tw, gbc);
		panel.add(this.h);
		panel.add(this.th, gbc);
		panel.add(this.e);
		panel.add(this.te, gbc);
		panel.add(this.g);
		panel.add(this.tg, gbc);
		panel.add(this.b);
		panel.add(this.tb, gbc);
		
		this.add(panel);
		addMenuBar();
		this.setUndecorated(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("X");
		exit = new JMenuItem("Sluiten");
		menuBar.add(menu);
		menu.add(exit);
		this.setJMenuBar(menuBar);
		exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) { 
			dispose();
		}
		if (e.getSource().equals(accept)) { 
			dispose();
		}
		if (e.getSource().equals(deny)) { 
			dispose();
		}
	}

}
