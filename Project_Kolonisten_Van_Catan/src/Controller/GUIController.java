package Controller;

import View.GUI;

public class GUIController {
	GUI gui = new GUI();
	public GUIController() {
		accesSteps();
		
	
	}
	
	private void accesSteps() {
		gui.showLoginPane();	
	}
}
