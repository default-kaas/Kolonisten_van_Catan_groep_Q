package Controller;

import java.sql.Connection;

import Database.LobbyDAO;
import View.InvitePanel;
import View.LobbyFrame;
import View.LobbyPanel;

public class LobbyController {

	
	private LobbyDAO lobbyDAO;
	private LobbyPanel lobbyPanel;
	private String username;
	private InvitePanel invitePanel;
	private InviteController inviteController;
	
	public LobbyController(LobbyFrame lobbyFrame, Connection db, String username) {
		this.username = username;
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(lobbyFrame, this);
	/*	inviteController = new InviteController(db);
		invitePanel = new InvitePanel(inviteController);*/		
	}
	
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
	
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList(username);
	}
	
/*	public InvitePanel getInvitePanel() {
		return invitePanel;
	}*/
	public Object[][] showInvites(){
		return lobbyDAO.getInvitedGames(username);
	}
}
