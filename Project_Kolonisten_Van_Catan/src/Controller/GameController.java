package Controller;

import java.sql.Connection;

import Model.Game;
import View.BoardPanel;
import View.BuildPanel;
import View.ChatPanel;
import View.DicePanel;
import View.PlayerInformationPanel;

public class GameController implements Runnable {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BuildPanelController bouwPanelController;
	private ChatPanelController chatPanelController;
	private TradeController tradePanelController;

	public GameController(int IdGame, String userName, Connection db_conn, boolean newGame) {

		Game = new Game(IdGame, userName, db_conn);

		BoardController x = new BoardController(Game, db_conn);
		
//		makePanelControllers(db_conn);
//
//		startChat();
//
//		runfirstRounds();
//
//		runRounds();

	}

	private void runRounds() {
		// Als lobby af is moet ik dit stukje nog wat veranderen.
		bouwPanelController.disableButtons();
		
		if ((Game.getRound() == Game.getMe().getPlayerID())) {
			showDice();
		}
		if (Game.getMe().gethasTrown()) {
			playerInfoController.showTradeButton();
			bouwPanelController.showButtons();
		}
		
		if (false) {
			playerInfoController.disableTradeButton();
		}

	}

	private void runfirstRounds() {
		// TODO Auto-generated method stub

	}

	private void startChat() {
		Thread t1 = new Thread(chatPanelController);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	private void makePanelControllers(Connection db_conn) {
		diceController = new DiceController(this, db_conn);
		bouwPanelController = new BuildPanelController(Game, db_conn, this);
		playerInfoController = new PlayerInfoController(Game, db_conn, this);
		chatPanelController = new ChatPanelController(Game, db_conn);
		tradePanelController = new TradeController(Game, db_conn);
	}

	public void runGame() {
		// while(true) {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
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
		return playerInfoController.getPlayerInfoPanel();
	}

	public void getTradeFrame() {
		tradePanelController.getTradeFrame();
	}

	public DicePanel getDicePanel() {
		return diceController.getDicePanel();
	}

	public ChatPanel getChatPanel() {
		return chatPanelController.getChatPanel();
	}

	public BoardPanel getBordPanel() {
		return new BoardPanel();
	}

	@Override
	public void run() {
		runGame();
	}

	public void setBuildMessage(String x, String y) {
		chatPanelController.setUserInput("heeft een " + x + " voor " + y + " gekocht!");
	}

	public void setDiceMessage(int value1, int value2) {
		chatPanelController.setUserInput("heeft " + value1 + " en " + value2 + " gegooid!");
	}
}
