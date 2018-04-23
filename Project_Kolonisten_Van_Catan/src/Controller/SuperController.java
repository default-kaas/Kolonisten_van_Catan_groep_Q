package Controller;

import java.sql.Connection;

import DatabaseConnect.DatabaseConnect;
import View.GameFrame;
import View.LobbyFrame;
import View.LoginFrame;

public class SuperController {
	private LoginFrame loginFrame;
	private Connection db_conn;
	private LobbyFrame lobbyFrame;
	private GameFrame gameFrame;
	
	public SuperController() {
		DatabaseConnect Connection = new DatabaseConnect();
		try {
			db_conn = Connection.getConnection();
		} catch (Exception e) {
			System.out.println("Kan geen connectie maken!");
		}
		loginFrame = new LoginFrame(this, db_conn);
	}

	public void CreateGUIController() {
//		GUIController guiController = new GUIController();
	}
	public void showLobbyScreen(String userName) {
		lobbyFrame = new LobbyFrame(this,db_conn, userName);
	}

	public void showGameScreen(int gameID, String userName, boolean newGame) {
		// TODO Auto-generated method stub
		gameFrame = new GameFrame(gameID, userName, db_conn, false);
	}

}
