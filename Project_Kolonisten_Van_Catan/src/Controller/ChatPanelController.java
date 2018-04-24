package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import Model.Game;
import View.ChatPanel;

public class ChatPanelController implements Runnable {

	private ChatPanel chatPanel;
	public Chat chatModel;
	private Game game;

	public ChatPanelController(Game game, Connection db_conn) {
		this.game = game;
		chatModel = new Chat(db_conn);
		chatPanel = new ChatPanel(this);

	}

	public void updateChat() {
		if (chatModel.updateChat(game)) {
			chatPanel.updateText();
		}
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

	@Override
	public void run() {
		setUserInput("joined the game!");
		while (true) {
			// System.out.println("test");
			updateChat();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
