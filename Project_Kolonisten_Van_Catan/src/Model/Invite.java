package Model;

import java.sql.Connection;

import Database.LoginDAO;

public class Invite {
	boolean loginSucces;
	int loginAttempts;
	private LoginDAO loginDao;
	
	public Invite(Connection db_conn) {
		loginDao = new LoginDAO(db_conn);
		loginSucces = false;
		loginAttempts = 0;
	}
	
	public boolean loginAttempt(String username, String password) {
		loginAttempts++;
		if(loginDao.searchPasswordWithUserName(username, password)) {
			return true; 
		}
		return false;
	}

//	public boolean activeGame(String name) {
//		// TODO Auto-generated method stub
//		if(loginDao.activeGame(name)) {
//			return true;
//		}
//		return false;
//	}
	
}
