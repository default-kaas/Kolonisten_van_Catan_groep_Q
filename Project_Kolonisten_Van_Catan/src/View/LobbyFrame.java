package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.LobbyController;
import Controller.LoginController;
import Controller.SuperController;

public class LobbyFrame extends JFrame implements ActionListener {
	private LobbyController lobbyController;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;
	private SuperController superController;

	public LobbyFrame(SuperController superController, Connection db_conn, String userName) {
		this.superController = superController;
		lobbyController = new LobbyController(this, db_conn, userName);

		setContent();
		addMenuBar();
	}

	public void showGameScreen(int gameID, String userName, boolean newGame) {
		superController.showGameScreen(gameID, userName, newGame);
	}

	private void setContent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(lobbyController.getLobbyPanel());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setUndecorated(true);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		exit = new JMenuItem("Exit");
		menuBar.add(menu);
		menu.add(exit);
		exit.addActionListener(this);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == exit) {
			System.exit(0);
		}
	}

}
