package Controller;

import java.awt.Container;
import java.sql.Connection;

import Database.EndDAO;
import View.EndPanel;

public class EndController {
	private EndPanel EndPanel;
	private EndDAO endDAO;
	private EndPanel endPanel;
	
	public EndController(Connection db_conn) {
		endDAO = new EndDAO(db_conn);
		endPanel = new EndPanel(this);
	}

	public void repeatGame() {
		// Waarschijnlijk meegeven richting lobby en daar zeggen dit zijn de spelernamen
		// nu nog niet gedaan want loby is nog niet af
	}
	
//	public void endGame() {
//		GUI.showLobbyScreen();
//	}

	public Container getEndPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
