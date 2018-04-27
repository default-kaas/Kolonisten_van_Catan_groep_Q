package Model;

import java.sql.Connection;
import java.util.ArrayList;

import Database.ChatDAO;

public class Chat {
	private ChatDAO ChatDAO;
	private String text;
	public ArrayList<String> chatArray;

	public Chat(Connection db_conn) {
		ChatDAO = new ChatDAO(db_conn);
		chatArray = new ArrayList<String>();
		
		
	}

	public String getText() {
		return text;
	}

	public void addTextToArray(String Message, Player Player) {
		if(!ChatDAO.setChatMessage(Message, Player.getPlayerID())) {
			chatArray.add("Error, Couldn't send message!");
		}
	}

	public String showTextarray() {
		String chat = "";
		for (String x : chatArray) {
			chat += x + "\n\r" ;
		}
		return chat;
	}

	public boolean updateChat(Game game) {
		return ChatDAO.updateChat(game, chatArray);
	}

}
