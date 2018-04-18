package View;

import javax.swing.JFrame;

public class GUI extends JFrame {
	Spelscherm Spelscherm;

	public GUI() {
		Spelscherm = new Spelscherm();
		setResizable(false);
		this.setContentPane(Spelscherm);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Voor nu ff zo gedaan dat we rechts boven kunnen afsluiten!
//		 this.setUndecorated(true);
		this.setTitle("Project Kolonisten van Catan, Groep Q");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}

}
