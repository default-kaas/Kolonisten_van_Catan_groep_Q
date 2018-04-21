package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import Model.Game;
import View.ChatPanel;

public class ChatPanelController {

	
	
	
	private ChatPanel chatPanel;
	public Chat chatModel; 
	private Game game;

	public ChatPanelController(Game game, Connection db_conn) {
		this.game = game;
		chatModel = new Chat(db_conn);
		chatPanel = new ChatPanel(this);
		
		
	}

	public String getTextArray() {
		return chatModel.showTextarray();
	}

	public void setUserInput(String x) {
		chatModel.addTextToArray(x, game.getMe());
		
	}

	public ChatPanel getChatPanel() {
		// TODO Auto-generated method stub
		return chatPanel;
	}

}
