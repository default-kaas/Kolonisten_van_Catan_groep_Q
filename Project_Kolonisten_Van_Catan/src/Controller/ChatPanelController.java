package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Chat;
import View.ChatPanel;

public class ChatPanelController {


	public Chat chatModel = new Chat();
	

	public ChatPanelController() {

		

	}
	
	public String getTextArray() {
		
		return chatModel.showTextarray();
	}


public void setUserInput(String x) {
	chatModel.addTextToArray(x);
}

	
}
