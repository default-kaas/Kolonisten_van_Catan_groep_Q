package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import View.InvitePanel;


public class InviteController {
	InviteDAO InviteDAO;
	InvitePanel invitePanel;
		
	public InviteController(Connection db_conn) {
		InviteDAO = new InviteDAO(db_conn);
		invitePanel  = new InvitePanel(this);
	}
	
	public Object[][] showUsers(){
		return InviteDAO.getUserList("test");
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}
	
	

}
