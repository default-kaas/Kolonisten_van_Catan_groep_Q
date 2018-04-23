package Model;

import java.sql.Connection;
import java.util.ArrayList;
import Database.ChatDAO;
import Controller.ChatPanelController;

public class Chat {
	private ChatDAO ChatDAO;
	private String text;
	public ArrayList<String> chatArray;
//	ChatPanelController chatPanelController = new ChatPanelController();

	public Chat(Connection db_conn) {
		ChatDAO = new ChatDAO(db_conn);
		chatArray = new ArrayList<String>();
		chatArray.add("Welkom bij Catan chat!");
		
	}

	public String getText() {
		return text;
	}

	public void addTextToArray(String Message, Player Player) {
		chatArray.add(Player.getName() + "("+Player.getColor()+") " + Message);
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

	public void updateChat(int GameID) {
		// TODO Auto-generated method stub
		ChatDAO.updateChat(GameID, chatArray);
	}

}
