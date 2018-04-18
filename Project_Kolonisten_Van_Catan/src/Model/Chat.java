package Model;

import java.util.ArrayList;

import Controller.ChatPanelController;

public class Chat {
	private String text;
	public ArrayList<String> chatArray;
//	ChatPanelController chatPanelController = new ChatPanelController();

	public Chat() {
		chatArray = new ArrayList<String>();
		addTextToArray("Welkom bij Catan chat!");
		
	}

	public String getText() {
		return text;
	}

//	public void setText(String text) {
//		text = chatPanelController.getUserText();
//
//		this.text = text;
//	}

	public void addTextToArray(String s) {
		
		chatArray.add(s);

	}

	public String showTextarray() {
		
		
		String chat = "";
		for (String x : chatArray) {
			chat += x + "\n\r" ;

		}
		return chat;
	}

}
