package Controller;

import java.sql.Connection;

import Model.Game;
import View.BoardPanel;
import View.BuildPanel;
import View.ChatPanel;
import View.DicePanel;
import View.PlayerInformationPanel;

public class GameController implements Runnable{
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BuildPanelController bouwPanelController;
	private ChatPanelController chatPanelController;
	private TradeController tradePanelController;

	public GameController(int IdGame, String userName, Connection db_conn, boolean newGame) {
		Game = new Game(IdGame, userName, db_conn);
		diceController = new DiceController(this, db_conn);
		// Als lobby af is moet ik dit stukje nog wat veranderen.
		if ((Game.getRound() == Game.getMe().getPlayerID())) {
			showDice();
		}

		bouwPanelController = new BuildPanelController(Game, db_conn);
		playerInfoController = new PlayerInfoController(Game, db_conn);
		chatPanelController = new ChatPanelController(Game, db_conn);
		tradePanelController = new TradeController(Game, db_conn);
		
		Thread t1 = new Thread(chatPanelController);
//		Thread t2 = new Thread(this);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t2.start();
	

	}
	
	public void runGame() {
//		while(true) {
//			System.out.println("xD");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	public void showDice() {
		diceController.showDice();
	}

	public BuildPanel getBouwPanel() {
		return bouwPanelController.getBouwPanel();
	}

	public Game getGame() {
		return Game;
	}

	public PlayerInformationPanel getSpelerInfoPanel() {
		// TODO Auto-generated method stub
		return playerInfoController.getPlayerInfoPanel();
	}

	public DicePanel getDicePanel() {
		return diceController.getDicePanel();
	}

	public ChatPanel getChatPanel() {
		// TODO Auto-generated method stub
		return chatPanelController.getChatPanel();
	}

	public BoardPanel getBordPanel() {
		// TODO Auto-generated method stub
		return new BoardPanel();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		runGame();
	}

	public void setDiceMessage(int value1, int value2) {
		// TODO Auto-generated method stub
		chatPanelController.setUserInput("heeft "+value1 + " en " + value2 + " gegooid!");
	}
}
