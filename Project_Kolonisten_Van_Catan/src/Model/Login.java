package Model;

import Database.LoginDAO;

public class Login {
	boolean loginSucces;
	int loginAttempts;
	private LoginDAO loginDao;
	
	public Login() {
		loginDao = new LoginDAO();
		loginSucces = false;
		loginAttempts = 0;
	}
	
	public boolean loginAttempt(String username, char[] password) {
		if(loginDao.searchPasswordWithUserName(username, password)) {
			return true; 
		}else {
			return false;
		}
	}
	
}
