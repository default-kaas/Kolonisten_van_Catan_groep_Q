package Controller;

import Model.Login;
import View.LogInPanel;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	private Login login;
	
	public LoginController() {
		LogInPanel = new LogInPanel(this);
		login = new Login();
		String x = "hallo";
		System.out.println(login.loginAttempt("ger", x.toCharArray()));
	}
	
	public LogInPanel getLoginPanel() {
		return LogInPanel;
	}
	
	public boolean checkSignIn() {
		
		
		// search database op username
		/*if (!Inputname == databasename) {
			return false;
		}
		// gebruikersnaam bestaat
		
		// retrieve data bijbehorend wachtwoord van account
		// check input wachtwoord met database wachtwoord
		if(!inputpassword == databasePassword) {
			return false;
		}*/
		
		// komt het overheen dan goedkeuring
		return true;
	}
	
	public void setLogInInformation(char[] password, String name) {
		
	}
}
