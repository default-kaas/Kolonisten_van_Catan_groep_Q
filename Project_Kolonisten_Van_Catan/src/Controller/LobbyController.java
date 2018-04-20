package Controller;

import Database.LobbyDAO;
import View.LobbyPanel;


public class LobbyController {
	LobbyDAO lobbyDAO;
	LobbyPanel lobbyPanel;
		
	public LobbyController() {
		lobbyDAO = new LobbyDAO();
		lobbyPanel  = new LobbyPanel(this);
	}
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}

	public LobbyPanel getlobbyPanel() {
		return lobbyPanel;
	}

}
