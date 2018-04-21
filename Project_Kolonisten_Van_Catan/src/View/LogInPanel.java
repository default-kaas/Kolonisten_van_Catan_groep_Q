package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginController;

public class LogInPanel extends JPanel implements ActionListener {
	private JLabel username, password, title;
	private JTextField nameField;
	private JButton loginButton,creatNewAccountButton;
	private JPasswordField passwordField;
	private LoginController loginController;

	public LogInPanel(LoginController loginController) {
		this.loginController = loginController;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeHeightPanel = (int)(screenSize.getHeight()*0.5);
        int sizeWidthPanel = (int)(screenSize.getWidth()*0.5);
        this.setPreferredSize(new Dimension(sizeWidthPanel, sizeHeightPanel));
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.DARK_GRAY);
		
		title = new JLabel("Login scherm");
		username = new JLabel("Gebruikersnaam: ");
		password = new JLabel("Wachtwoord: ");
		nameField = new JTextField(8);
		passwordField = new JPasswordField(8);
		loginButton = new JButton("Login");
		creatNewAccountButton = new JButton("Creer");

		passwordField.addActionListener(this);
		loginButton.addActionListener(this);

		GridBagConstraints c = new GridBagConstraints();
		
		int sizeHeight = (int)(screenSize.getHeight());
		int sizeWidth = (int)(screenSize.getWidth());
		
		title.setFont(new Font("Arial Black",1,50));
		title.setForeground(Color.WHITE);
		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		
		
		//This is the title of the login panel
		c.insets = new Insets(0,0,50,0);  
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add(title, c);
		
		  
		//This is the left colom with the jlabels
		c.insets = new Insets(0,0,10,-100); 
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(username, c);
		c.gridy++;
		this.add(password, c);
		
		//This is the right colom with the textfields (paswordfield)
		c.insets = new Insets(0,-100,10,0); 
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(nameField, c);
		c.gridy++;
		this.add(passwordField, c);
		
		//This is the login button and create account button
		c.insets = new Insets(30,0,0,0);  
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		this.add(loginButton, c);
		c.insets = new Insets(10,0,0,0); 
		c.gridy ++;
		this.add(creatNewAccountButton, c);
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(loginButton) || ae.getSource().equals(passwordField)) {
			loginController.setLogInInformation(getInputPassword(), getInputName());
		}
	}

	public void notCorrectLoginInformation() {

	}

	public String getInputName() {
		return nameField.getText();
	}

	public char[] getInputPassword() {
		return passwordField.getPassword();
	}

	public void showError() {

		JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);

	}
}
