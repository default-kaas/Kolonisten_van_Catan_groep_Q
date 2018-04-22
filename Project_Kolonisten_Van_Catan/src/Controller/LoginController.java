package Controller;

import java.sql.Connection;

import Model.Account;
import View.LogInPanel;
import View.LoginFrame;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	private Account login;
	private LoginFrame loginFrame;

	public LoginController(LoginFrame loginFrame, Connection db_conn) {
		this.loginFrame = loginFrame;
		LogInPanel = new LogInPanel(this);
		login = new Account(db_conn);

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
	
	public void setAccountInformation(String name, String password) {
		if(login.createAccountMiniumLength(name, password)) {
			if(login.createAccountCorrectSigns(name, password)){
				if(login.createAccount(name, password)) {
					LogInPanel.createAccountMessage();
				}else {
					LogInPanel.showErrorCreateAccountUsername();
				}
			}else {
				LogInPanel.showErrorCreateAccountIncorrectPasswordOrUsername();
			}
		}else {
			LogInPanel.showErrorCreateAccountToShortPasswordOrUsername();
		}
	}
}
