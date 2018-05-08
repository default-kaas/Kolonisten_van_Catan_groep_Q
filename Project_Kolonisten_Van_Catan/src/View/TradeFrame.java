package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.GameController;
import Controller.TradeController;
import Model.Game;

public class TradeFrame extends JFrame implements ActionListener {
	
	private TradeController tc;
	private Game game;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;
	private GameController gc;

	public TradeFrame(Game game, Connection db_conn, GameController gameController) {

		this.game = game;
		tc = new TradeController(this,db_conn,game);
		gc = gameController;
		setupFrame();
		addMenuBar();
	
	}
	
	public void disposethis() {
		this.dispose();
	}
	
	public void returnFrame() {
		gc.setTP(this);
	}

	public void getTradeFrame() {
		tc.getTradeFrame();
	}
	
	private void setupFrame() {

		this.setUndecorated(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(tc.getTradePanel());
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
	}
	
	

}
