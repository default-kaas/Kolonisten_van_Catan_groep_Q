package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import View.ChatPanel;
import Controller.GameController;

public class ChatPanelController {

	public Chat chatModel = new Chat();
	
	
	
	private GameController gameController;

	public ChatPanelController(GameController gameController) {
		this.gameController = gameController;
	}

	public String getTextArray() {
		return chatModel.showTextarray();
	}

	public void setUserInput(String x) {
		chatModel.addTextToArray(x, gameController.getGame().getMe());
		
	}

}
