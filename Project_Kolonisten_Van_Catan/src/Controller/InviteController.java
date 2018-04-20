package Controller;

import java.sql.Connection;

import Database.InviteDAO;
import View.GUI;
import View.InvitePanel;


public class InviteController {
	InviteDAO lobbyDAO;
	InvitePanel lobbyPanel;
		
	public InviteController(GUI gui, Connection db_conn) {
		lobbyDAO = new InviteDAO(db_conn);
		lobbyPanel  = new InvitePanel(this);
	}
	
	public Object[][] showUsers(){
		return lobbyDAO.getUserList();
	}

	public InvitePanel getlobbyPanel() {
		return lobbyPanel;
	}

}
