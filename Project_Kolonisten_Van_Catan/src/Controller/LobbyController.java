package Controller;

import Database.LobbyDAO;

public class LobbyController {
	
	LobbyDAO lobbyDAO;
	
	public LobbyController() {
		lobbyDAO = new LobbyDAO();
	}
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}

}
