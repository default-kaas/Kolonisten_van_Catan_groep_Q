package Controller;

import java.sql.Connection;

import Model.Game;
import View.BoardPanel;
import View.BuildPanel;
import View.ChatPanel;
import View.DicePanel;
import View.PlayerInformationPanel;
import View.TradeFrame;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BuildPanelController bouwPanelController;
	private ChatPanelController chatPanelController;
	private TradeFrame tradeFrame;
	private BoardController boardController;

	private Thread t1;

	public GameController(int IdGame, String userName, Connection db_conn, boolean newGame) {

		Game = new Game(IdGame, userName, db_conn);

		makePanelControllers(db_conn);

		startChat();

		runRounds();

	}

	public void runRounds() {
		if ((Game.getRound() == Game.getMe().getPlayerID())) {
			t1.interrupt();
			playerInfoController.UpdateResourcePanel();
			showDice();
		} else {
			myTurn();
		}
	}

	public void myTurn() {
		if (!t1.isAlive()) {
			t1.start();
		} else {
//			t1.interrupt();
//			t1.start();
		}
	}
	
	public void updateAllPanels() {
		Game.updateRound();
		runRounds();
	}
	

	private void startChat() {
		Thread t2 = new Thread(chatPanelController);
		t2.start();
	}

	private void makePanelControllers(Connection db_conn) {
		diceController = new DiceController(this, db_conn);
		bouwPanelController = new BuildPanelController(Game, db_conn, this);
		playerInfoController = new PlayerInfoController(Game, db_conn, this);
		chatPanelController = new ChatPanelController(Game, db_conn);
		boardController = new BoardController(Game, db_conn);

		bouwPanelController.addObserver(playerInfoController);
		diceController.addObserver(bouwPanelController);
		diceController.addObserver(playerInfoController);

		t1 = new Thread(playerInfoController);
	}

	public void setTP(TradeFrame tf) {
		tradeFrame = tf;
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
		tradeFrame.getTradeFrame();
	}

	public DicePanel getDicePanel() {
		return diceController.getDicePanel();
	}

	public ChatPanel getChatPanel() {
		return chatPanelController.getChatPanel();
	}

	public BoardPanel getBoardPanel() {
		return boardController.getBoardPanel();
	}

	public void setBuildMessage(String x, String y) {
		chatPanelController.setUserInput("heeft een " + x + " voor " + y + " gekocht!");
	}

	public void setDiceMessage(int value1, int value2) {
		chatPanelController.setUserInput("heeft " + value1 + " en " + value2 + " gegooid!");
	}
}
