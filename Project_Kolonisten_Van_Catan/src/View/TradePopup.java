package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TradePopup extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;
	
	private JPanel panel;
	
	public TradePopup() {
		
		panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setBackground(Color.white);
		panel.setBackground(new Color(245, 245, 220));
		panel.setVisible(true);
		
		this.add(panel);
		this.setUndecorated(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		addMenuBar();
		
	}
	
	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("X");
		exit = new JMenuItem("Sluiten");
		menuBar.add(menu);
		menu.add(exit);
		this.setJMenuBar(menuBar);
//		exit.addActionListener(this);
	}
	
/*	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) { 
			dispose();
		}
	}*/

}
