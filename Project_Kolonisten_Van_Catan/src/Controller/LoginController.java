package Controller;

import java.sql.Connection;

import Model.Login;
import View.GUI;
import View.LogInPanel;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	private Login login;
	private GUI gui;
	private Connection db_conn;
	
	public LoginController(GUI gui, Connection db_conn) {
		this.db_conn = db_conn;
		this.gui = gui;
		LogInPanel = new LogInPanel(this);
		login = new Login(db_conn);
//		String x = "hallo";
//		System.out.println(login.loginAttempt("vincent", x.toCharArray()));
	}
	
	public LogInPanel getLoginPanel() {
		return LogInPanel;
	}
		
	public void setLogInInformation(char[] password, String name) {
		if(login.loginAttempt(name, password)) {
			gui.showGamePane(true, 770, name, true);
		}else {
			LogInPanel.showError();
		}
		
		
	}
}
