package Controller;

import java.sql.Connection;

import Model.Invite;
import View.LogInPanel;
import View.LoginFrame;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	private Invite login;
	private LoginFrame loginFrame;

	public LoginController(LoginFrame loginFrame, Connection db_conn) {
		this.loginFrame = loginFrame;
		LogInPanel = new LogInPanel(this);
		login = new Invite(db_conn);

	}
	
	public LogInPanel getLoginPanel() {
		return LogInPanel;
	}
		
	public void setLogInInformation(String name, String password) {
		if(login.loginAttempt(name, password)) {
			loginFrame.Login(name);
		}else {
			LogInPanel.showError();
		}
		
		
	}
}
