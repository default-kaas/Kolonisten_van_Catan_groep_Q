package View;

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

		addMenuBar();
		showGamePane(false);
		// Voor nu ff zo gedaan dat we rechts boven kunnen afsluiten!

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setTitle("Project Kolonisten van Catan, Groep Q");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	private void addMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu();
		exit = new JMenuItem("Exit");
		menuBar.add(menu);
		menu.add(exit);
		this.setJMenuBar(menuBar);

	}

	private void showLobbyScreen() {

	}

	private void showGamePane(boolean loginSucces) {
		LogInPanel = new LogInPanel();
		this.setContentPane(LogInPanel);
		if (!LogInPanel.isSignedIn()) {
			this.getContentPane().remove(LogInPanel);
			Spelscherm = new Spelscherm(770);
			this.setContentPane(Spelscherm);
		}
	}
}
