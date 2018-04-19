package Controller;

import Model.Game;
import View.DicePanel;
import View.SpelerInformatiePanel;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;

	public GameController(int IdGame, String userName) {
		Game = new Game(IdGame, userName);
		playerInfoController = new PlayerInfoController(Game);

		diceController = new DiceController();

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
