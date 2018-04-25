package Model;

import java.sql.Connection;

import Database.AccountDAO;

public class Account {
	boolean loginSucces;
	private AccountDAO loginDao;
	
	public Account(Connection db_conn) {
		loginDao = new AccountDAO(db_conn);
		loginSucces = false;
	}
	
	public boolean loginAttempt(String username, String password) {
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
	
	public boolean createAccount(String username, String password) {
		if(loginDao.createAccountDOA(username, password)) {
			return true; 
		}
		return false;
	}
	
	public boolean createAccountMiniumLength(String username, String password) {
		if(username.length()<3||password.length()<3) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean createAccountMaximumLength(String username, String password) {
		if(username.length()>25||password.length()>25) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean createAccountCorrectSigns(String username, String password) {
		String usernameLowerCase = username.toLowerCase();
		String passwordLowerCase = password.toLowerCase();
        for (int i = 0; i < usernameLowerCase.length(); i++) {
            if (((usernameLowerCase.charAt(i) >= '0' && usernameLowerCase.charAt(i) <= 'z')) || usernameLowerCase.charAt(i) == ' ') {
                continue;
            } else {
                return false;
            }
        }
        for (int i = 0; i < passwordLowerCase.length(); i++) {
            if (((passwordLowerCase.charAt(i) >= '0' && passwordLowerCase.charAt(i) <= 'z')) || passwordLowerCase.charAt(i) == ' ') {
                continue;
            } else {
                return false;
            }
        }
        return true;
	}
}
