package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPanel extends JPanel implements ActionListener{
	JLabel username, password;
	JTextField textField;
	JButton button;
	JPasswordField passwordField;
	
	public LogInPanel() {
		username = new JLabel("Username");
		password = new JLabel("Password");
		textField = new JTextField();
		passwordField = new JPasswordField();
		button = new JButton("Login");
		button.addActionListener(this);
		
		username.setBounds(80, 70, 200, 30);
		password.setBounds(80, 110, 200, 30);
		textField.setBounds(300, 70, 200, 30);
		passwordField.setBounds(300, 110, 200, 30);
		button.setBounds(150, 160, 100, 30);
		
		this.setPreferredSize(new Dimension(600, 600));
		this.add(username);
		this.add(password);
		this.add(textField);
		this.add(passwordField);
		this.add(button);
		
		signIn();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String uname = textField.getText();
		String pass = passwordField.getText();
		
		if (uname.equals("mw") && pass.equals("abc")) {
			JLabel label = new JLabel("Welcome:" + uname);
		} else {
			JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean signIn() {
		System.out.println("you are signed in");
		return true;
	}
}
