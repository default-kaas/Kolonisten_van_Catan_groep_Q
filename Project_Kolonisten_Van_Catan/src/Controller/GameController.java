package Controller;

import Model.Game;
import View.BouwPanel;
import View.DicePanel;
import View.SpelerInformatiePanel;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	private BouwPanelController bouwPanelController;

	public GameController(int IdGame, String userName) {
		Game = new Game(IdGame, userName);
		
		bouwPanelController = new BouwPanelController(Game);
		playerInfoController = new PlayerInfoController(Game);
		diceController = new DiceController(Game);
		
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
}
