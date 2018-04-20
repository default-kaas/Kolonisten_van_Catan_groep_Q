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
	
	public LoginController(GUI gui, Connection db_conn) {
		
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
			if(login.activeGame(name)) {
				gui.showGamePane(true, 770, name, true);
			}else {
				gui.showGamePane(true, 770, name, false);
			}
		}else {
			LogInPanel.showError();
		}
		
		
	}
}
