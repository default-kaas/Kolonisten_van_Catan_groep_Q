package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import Model.Invite;
import View.InvitePanel;

public class InviteController {

	InvitePanel invitePanel;

	private Invite invite;

	public InviteController(Connection db_conn, String username, int idspel, boolean creator) {

		invite = new Invite(db_conn, idspel, username);
		invitePanel = new InvitePanel(this, creator);
	}

	public Object[][] showUsers() {
		return invite.showUsers();
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}

	public Object[][] showInviteUsers() {
		return invite.showInviteUsers();
	}

	public void invitePlayer(String userName) {
		invite.invitePlayer(userName);
	}

	public int getNumberInvited() {
		// TODO Auto-generated method stub

		return invite.getNumberInvited();
	}

	// public int getSelectedRow() {
	// return invitePanel.getSelectedRow();
	// }

}
