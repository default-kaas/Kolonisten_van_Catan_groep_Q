package Controller;

import java.sql.Connection;

import Model.Game;
import View.BoardPanel;
import View.BuildPanel;
import View.ChatPanel;
import View.DicePanel;
import View.PlayerInformationPanel;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BuildPanelController bouwPanelController;
	private ChatPanelController chatPanelController;

	public GameController(int IdGame, String userName, Connection db_conn) {
		Game = new Game(IdGame, userName, db_conn);
		
		bouwPanelController = new BuildPanelController(Game, db_conn);
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
}
