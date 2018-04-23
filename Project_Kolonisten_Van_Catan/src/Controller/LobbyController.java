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
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(lobbyFrame, this);
	/*	inviteController = new InviteController(db);
		invitePanel = new InvitePanel(inviteController);*/
		this.username = username;
		System.out.println(username);
		
	}
	
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
	
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList(username);
	}
<<<<<<< HEAD
	
/*	public InvitePanel getInvitePanel() {
		return invitePanel;
	}*/
=======
	public Object[][] showInvites(){
		return lobbyDAO.getInvitedGames(username);
	}
>>>>>>> 0dbc8febe30b40782f5fa0d1b1fee1be44a9d81d
}
