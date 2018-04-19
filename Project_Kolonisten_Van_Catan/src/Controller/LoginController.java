package Controller;

import View.LogInPanel;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	
	public boolean checkSignIn() {
		LogInPanel = new LogInPanel();
		// search database op username
		LogInPanel.getInputName();
		LogInPanel.getInputPassword();

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
}
