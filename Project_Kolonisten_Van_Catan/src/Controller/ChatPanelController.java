package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import View.ChatPanel;
import Controller.GameController;

public class ChatPanelController {

	public Chat chatModel; 
	
	
	
	private GameController gameController;

	public ChatPanelController(GameController gameController, Connection db_conn) {
		this.gameController = gameController;
		chatModel = new Chat(db_conn);
	}

	public String getTextArray() {
		return chatModel.showTextarray();
	}

	public void setUserInput(String x) {
		chatModel.addTextToArray(x, gameController.getGame().getMe());
		
	}

}
