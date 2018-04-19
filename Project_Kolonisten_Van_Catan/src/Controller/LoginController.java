package Controller;

import Model.Login;
import View.GUI;
import View.LogInPanel;

public class LoginController {
	private boolean correctLogIn;
	private LogInPanel LogInPanel;
	private Login login;
	private GUI gui;
	
	public LoginController(GUI gui) {
		this.gui = gui;
		LogInPanel = new LogInPanel(this);
		login = new Login();
//		String x = "hallo";
//		System.out.println(login.loginAttempt("vincent", x.toCharArray()));
	}
	
	public LogInPanel getLoginPanel() {
		return LogInPanel;
	}
		
	public void setLogInInformation(char[] password, String name) {
		if(login.loginAttempt(name, password)) {
			gui.showGamePane(true, 770, name);
		}else {
			LogInPanel.showError();
		}
		
		
	}
}
