package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import View.InvitePanel;


public class InviteController {
	InviteDAO InviteDAO;
	InvitePanel invitePanel;
	private String username;
	private int idspel;	
	
	public InviteController(Connection db_conn, String username, int idspel) {
		this.idspel = idspel;
		this.username = username;
		InviteDAO = new InviteDAO(db_conn);
		invitePanel  = new InvitePanel(this);
	}
	
	public Object[][] showUsers(){
		return InviteDAO.getUserList(username, idspel);
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}
	
	public Object[] showInviteUsers(){
		return InviteDAO.getInviteUserList(username);
	}
	
	public void invitePlayer(String userName) {
		InviteDAO.invitePlayers(userName, idspel);
	}
	
//	public int getSelectedRow() {
//		return invitePanel.getSelectedRow();
//	}
	
	

}
