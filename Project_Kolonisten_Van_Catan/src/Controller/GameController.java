package Controller;

import java.sql.Connection;

import Model.Game;
import View.BordPanel;
import View.BouwPanel;
import View.ChatPanel;
import View.DicePanel;
import View.SpelerInformatiePanel;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BouwPanelController bouwPanelController;
	private ChatPanelController chatPanelController;

	public GameController(int IdGame, String userName, Connection db_conn) {
		Game = new Game(IdGame, userName, db_conn);
		
		bouwPanelController = new BouwPanelController(Game, db_conn);
		playerInfoController = new PlayerInfoController(Game, db_conn);
		diceController = new DiceController(Game, db_conn);
		chatPanelController = new ChatPanelController(Game, db_conn);
		
		
		//Als lobby af is moet ik dit stukje nog wat veranderen.
		if((Game.getRound() == Game.getMe().getPlayerID())&& !(Game.getMe().gethasTrown())) {
			showDice();
		}
		
		
	}
	public void showDice() {
		diceController.showDice();
	}
	
	public BouwPanel getBouwPanel() { 
		return bouwPanelController.getBouwPanel();
	}

	public Game getGame() {
		return Game;
	}

	public SpelerInformatiePanel getSpelerInfoPanel() {
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
	public BordPanel getBordPanel() {
		// TODO Auto-generated method stub
		return new BordPanel();
	}
}
