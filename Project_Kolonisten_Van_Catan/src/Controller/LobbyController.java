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
	private LobbyFrame lobbyFrame;

	public LobbyController(LobbyFrame lobbyFrame, Connection db, String username) {
		this.lobbyFrame = lobbyFrame;
		this.username = username;
		lobbyDAO = new LobbyDAO(db);
		lobbyPanel = new LobbyPanel(lobbyFrame, this);

		inviteController = new InviteController(db);
		invitePanel = new InvitePanel(inviteController);
	}

	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}

	public Object[][] showUsers() {
		return lobbyDAO.getUserList(username);
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}

	public Object[][] showInvites() {
		return lobbyDAO.getInvitedGames(username);
	}

	public void respondToInvite(int gameId, boolean Accept) {
		lobbyDAO.respondToInvite(username, gameId, Accept);
	}
	
	public void joinOldGame(int gameID) {
		lobbyFrame.showGameScreen(gameID, username, false);
		
	}
}
