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
	
	JFrame frame;

	public TradeFrame(Game game, Connection db_conn, GameController gameController) {

		this.game = game;
		tc = new TradeController(this,db_conn,game);
		gc = gameController;
		frame = new JFrame();
		setupFrame();
		addMenuBar();
	
	}
	
	public void returnFrame() {
		gc.setTP(this);
	}

	public void getTradeFrame() {
		tc.getTradeFrame();
	}
	
	private void setupFrame() {

		frame.setUndecorated(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(tc.getTradePanel());
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);

	}
	
	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("X");
		exit = new JMenuItem("Sluiten");
		menuBar.add(menu);
		menu.add(exit);
		frame.setJMenuBar(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) { 
			dispose();
		}
	}
	
	

}
