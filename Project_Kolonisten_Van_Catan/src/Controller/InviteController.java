package Controller;

import java.sql.Connection;
import java.util.Observable;

import Model.Invite;
import View.InvitePanel;

public class InviteController extends Observable implements Runnable {

	private InvitePanel invitePanel;
	private Invite invite;
	private LobbyController lobbyController;

	public InviteController(Connection db_conn, String username, int idspel, boolean creator, LobbyController lobbyController) {
		this.lobbyController = lobbyController;
		invite = new Invite(db_conn, idspel, username);
		invitePanel = new InvitePanel(this, creator);
	}

	public Object[][] getAvailableUsers() {
		return invite.showUsers();
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}

	public Object[][] getInviteUsers() {
		return invite.showInviteUsers();
	}

	public void invitePlayer(String userName) {
		invite.invitePlayer(userName);
	}

	public int getNumberInvited() {
		return invite.getNumberInvited();
	}
	public void cancelInvite() {
		invite.cancelGame();
		lobbyController.cancelInvite();
	}
	
	@Override
	public void run() {
		boolean run = true;
		while (run) {
//			invitePanel.refreshPanel(false);
			if (invite.getAcceptedPlayerAmount() == 3) {
				run = false;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Update game
		lobbyController.joinGame(invite.getSpelID(), true);

	}

}
