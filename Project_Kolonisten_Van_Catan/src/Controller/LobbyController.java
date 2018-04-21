package Controller;

import java.sql.Connection;

import Database.LobbyDAO;
import View.LobbyFrame;
import View.LobbyPanel;

public class LobbyController {

	
	LobbyDAO lobbyDAO;
	LobbyPanel lobbyPanel;
	
	public LobbyController(LobbyFrame lobbyFrame, Connection db) {
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(lobbyFrame, this);
	}
	
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
	
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}
}
