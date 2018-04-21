package Controller;

import View.EndPanel;
// weet niet of dit mag!!!
import View.GUI;

public class EndController {
	private EndPanel EndPanel;
	private GUI GUI;

	public void repeatGame() {
		// Waarschijnlijk meegeven richting lobby en daar zeggen dit zijn de spelernamen
		// nu nog niet gedaan want loby is nog niet af
	}
	
	public void endGame() {
		GUI.showLobbyScreen();
	}
	
}
