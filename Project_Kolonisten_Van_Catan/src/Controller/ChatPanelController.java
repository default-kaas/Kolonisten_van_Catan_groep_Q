package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import View.ChatPanel;

public class ChatPanelController {


	public Chat chatModel = new Chat();
	public ChatPanel chatPanel = new ChatPanel();

	public ChatPanelController() {

		

	}
	
	public String getTextArray() {
		
		return chatModel.showTextarray();
	}


	public String getUserText() { 	

		String chatInput = "";

		chatInput += chatPanel.inputField.getText();

		return chatInput;

	}

	
}
