package Controller;

import java.sql.Connection;

import Database.LobbyDAO;
import View.GUI;
import View.LobbyPanel;


public class LobbyController {
	LobbyDAO lobbyDAO;
	LobbyPanel lobbyPanel;
		
	public LobbyController(GUI gui, Connection db_conn) {
		lobbyDAO = new LobbyDAO(db_conn);
		lobbyPanel  = new LobbyPanel(this);
	}
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}

	public LobbyPanel getlobbyPanel() {
		return lobbyPanel;
	}

}
