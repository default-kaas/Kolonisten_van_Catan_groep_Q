package View;

import javax.swing.JFrame;

public class GUI extends JFrame {
	private Spelscherm Spelscherm;
	private LogInPanel LogInPanel;

	public GUI() {
		
		
		showGamePane(true);
		// Voor nu ff zo gedaan dat we rechts boven kunnen afsluiten!
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		this.setUndecorated(true);
		this.setTitle("Project Kolonisten van Catan, Groep Q");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}
	
	private void showLobbyScreen() {
		
	}
	
	private void showGamePane(boolean loginSucces) {
		if(loginSucces == true) {
			Spelscherm = new Spelscherm();
			LogInPanel = new LogInPanel();
			this.setContentPane(Spelscherm);
		}
	}
}
