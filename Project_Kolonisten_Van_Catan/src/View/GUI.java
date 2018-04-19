package View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame {
	private Spelscherm Spelscherm;
	private LogInPanel LogInPanel;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit, login, lobby;

	public GUI() {
		// Voor nu ff zo gedaan dat we rechts boven kunnen afsluiten!
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setUndecorated(true);
		this.setTitle("Project Kolonisten van Catan, Groep Q");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Exit");
		exit = new JMenuItem("Exit");
		menuBar.add(menu);
		menu.add(exit);
		this.setJMenuBar(menuBar);

	}

	public void showLobbyScreen() {
		
	}
	
	public void showLoginPane() {
		LogInPanel = new LogInPanel();
		this.setContentPane(LogInPanel);
		settings();
	}

	public void showGamePane(boolean loginSucces, int gameID) {
		if(loginSucces) {
			//this.getContentPane().remove(LogInPanel);
			
			//De username moet worden meegegeven tijdens het inloggen of na het zijn in de lobby
			String UserName = "lesley"; 
			Spelscherm = new Spelscherm(gameID, UserName);
			this.setContentPane(Spelscherm);
			settings();
		}
	}
	
	private void settings() {
		this.revalidate();
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
