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

		System.out.println(username);
		
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
		System.out.println(username);
		return lobbyDAO.getInvitedGames(username);
	}
}
