package Controller;

import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

import Model.Game;
import View.BoardPanel;
import View.BuildPanel;
import View.ChatPanel;
import View.DicePanel;
import View.PlayerInformationPanel;
import View.TradeFrame;

public class GameController extends Observable implements Runnable {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BuildPanelController bouwPanelController;
	private ChatPanelController chatPanelController;
	private TradeFrame tradeFrame;
	private BoardController boardController;

	public GameController(int IdGame, String userName, Connection db_conn, boolean newGame) {

		Game = new Game(IdGame, userName, db_conn);

		makePanelControllers(db_conn);

		startChat();

		runfirstRounds();

		runRounds();

	}

	private void runRounds() {
		// Als lobby af is moet ik dit stukje nog wat veranderen.
		bouwPanelController.disableButtons();

		if ((Game.getRound() == Game.getMe().getPlayerID())) {
			showDice();
		}
		bouwPanelController.showButtons();

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
		boardController = new BoardController(Game, db_conn);
		
		bouwPanelController.addObserver(playerInfoController);
		diceController.addObserver(playerInfoController);
		
	}
	
	public void setTP(TradeFrame tf) {
		tradeFrame = tf;
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
	

	// @Override
	// public void update(Observable o, Object arg) {
	// try {
	// Method update = getClass().getMethod(o.getClass(), Object.class);
	// update.invoke(this, o, arg);
	// } catch (Exception e) {
	// // log exception
	// }
	//
	// }
	// public void update(A a, Object arg) {
	// }
	// public void update(B b, Object arg) {
	// }
	// public void update(C c, Object arg) {
	// }
}
