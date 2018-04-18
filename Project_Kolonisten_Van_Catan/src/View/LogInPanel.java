package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPanel extends JPanel implements ActionListener{
	JLabel username, password, title;
	JTextField nameField;
	JButton button;
	JPasswordField passwordField;
	
	public LogInPanel() {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(600, 600));
		
		title = new JLabel("Login");
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		nameField = new JTextField(8);
		passwordField = new JPasswordField(8);
		button = new JButton("Login");
		
		button.addActionListener(this);
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add(title,c);
		
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(username,c);
		c.gridy ++;
		this.add(password,c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(nameField,c);
		c.gridy ++;
		this.add(passwordField,c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		this.add(button,c);
		
		signIn();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String uname = nameField.getText();
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
