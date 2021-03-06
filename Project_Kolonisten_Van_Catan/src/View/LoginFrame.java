package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.LoginController;
import Controller.SuperController;

public class LoginFrame extends JFrame implements ActionListener {
	private LoginController loginController;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;
	private SuperController superController;

	public LoginFrame(SuperController superController, Connection db_conn) {
		this.superController = superController;
		loginController = new LoginController(this,db_conn);
		addMenuBar();
		setContent();
	}
	
	public void Login(String userName) {
		this.dispose();
		superController.showLobbyScreen(userName);
		
	}

	private void setContent() {
		this.setContentPane(loginController.getLoginPanel());
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
