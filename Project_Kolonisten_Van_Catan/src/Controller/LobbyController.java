package Controller;

import java.sql.Connection;

import Database.LobbyDAO;
import View.GUI;
import View.LobbyPanel;

public class LobbyController {

	
	LobbyDAO lobbyDAO;
	LobbyPanel lobbyPanel;
	
	public LobbyController(GUI gui,Connection db) {
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(this);
	}
	
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
	
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}
}
