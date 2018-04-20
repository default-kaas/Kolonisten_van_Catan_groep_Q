package View;

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
	JLabel username, password, title;
	JTextField nameField;
	JButton button;
	JPasswordField passwordField;
	private LoginController loginController;

	public LogInPanel(LoginController loginController) {
		this.loginController = loginController;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeHeightPanel = (int)(screenSize.getHeight()*0.5);
        int sizeWidthPanel = (int)(screenSize.getWidth()*0.5);
        this.setPreferredSize(new Dimension(sizeWidthPanel, sizeHeightPanel));
		this.setLayout(new GridBagLayout());
		
		
		title = new JLabel("Login");
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		nameField = new JTextField(8);
		passwordField = new JPasswordField(8);
		button = new JButton("Login");

		passwordField.addActionListener(this);
		button.addActionListener(this);

		GridBagConstraints c = new GridBagConstraints();
		
		int sizeHeight = (int)(screenSize.getHeight());
		int sizeWidth = (int)(screenSize.getWidth());
		this.setFont(new Font("Arial Black",1,25));
		
		c.insets = new Insets(10,10,10,10);  //top padding
		
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
	
		this.add(title, c);
		
		c.insets = new Insets(2,10,2,10);  //top padding
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(username, c);
		c.gridy++;
		this.add(password, c);

		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(nameField, c);
		c.gridy++;
		this.add(passwordField, c);
		
		c.insets = new Insets(10,0,0,0);  //top padding
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		this.add(button, c);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(button) || ae.getSource().equals(passwordField)) {
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
