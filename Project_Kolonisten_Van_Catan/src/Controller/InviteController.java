package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import View.GUI;
import View.InvitePanel;


public class InviteController {
	InviteDAO InviteDAO;
	InvitePanel invitePanel;
		
	public InviteController(GUI gui, Connection db_conn) {
		InviteDAO = new InviteDAO(db_conn);
		invitePanel  = new InvitePanel(this);
	}
	
	public Object[][] showUsers(){
		return InviteDAO.getUserList();
	}

	public InvitePanel getInvitePanel() {
		return invitePanel;
	}

}
