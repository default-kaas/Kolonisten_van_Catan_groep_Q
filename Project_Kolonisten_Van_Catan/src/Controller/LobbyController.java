package Controller;

import java.sql.Connection;

import Database.LobbyDAO;
import View.LobbyFrame;
import View.LobbyPanel;

public class LobbyController {

	
	private LobbyDAO lobbyDAO;
	private LobbyPanel lobbyPanel;
	private String username;
	
	public LobbyController(LobbyFrame lobbyFrame, Connection db, String username) {
		
		this.username = username;
		System.out.println(username);
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(lobbyFrame, this);
	}
	
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
	
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList(username);
	}
}
