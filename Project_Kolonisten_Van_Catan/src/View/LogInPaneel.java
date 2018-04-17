package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class LogInPaneel extends JPanel {

	public LogInPaneel() {
		this.setPreferredSize(new Dimension(getMaximumSize()));
		this.setBackground(Color.blue);
		signIn();
	}

	public boolean signIn() {
		System.out.println("you are signed in");
		return true;
	}
}
