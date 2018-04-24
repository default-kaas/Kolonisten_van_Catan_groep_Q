package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import View.InvitePanel;


public class InviteController {
	InviteDAO InviteDAO;
	InvitePanel invitePanel;
	private String username;
		
	public InviteController(Connection db_conn, String username) {
		this.username = username;
		InviteDAO = new InviteDAO(db_conn);
		invitePanel  = new InvitePanel(this);
	}
	
	public Object[][] showUsers(){
		return InviteDAO.getUserList(username);
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}
	
	public Object[] showInviteUsers(){
		return InviteDAO.getInviteUserList(username);
	}
	
//	public int getSelectedRow() {
//		return invitePanel.getSelectedRow();
//	}
	
	

}
