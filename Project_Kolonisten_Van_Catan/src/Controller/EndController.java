package Controller;

import java.awt.Container;
import java.sql.Connection;

import Database.EndDAO;
import View.EndPanel;
// weet niet of dit mag!!!
import View.GUI;

public class EndController {
	private EndPanel EndPanel;
	private GUI GUI;
	private EndDAO endDAO;
	private EndPanel endPanel;
	
	public EndController(View.GUI gui, Connection db_conn) {
		endDAO = new EndDAO(db_conn);
		endPanel = new EndPanel(this);
	}

	public void repeatGame() {
		// Waarschijnlijk meegeven richting lobby en daar zeggen dit zijn de spelernamen
		// nu nog niet gedaan want loby is nog niet af
	}
	
	public void endGame() {
		GUI.showLobbyScreen();
	}

	public Container getEndPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
