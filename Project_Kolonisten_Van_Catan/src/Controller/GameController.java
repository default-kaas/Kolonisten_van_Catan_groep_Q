package Controller;

import Model.Game;

public class GameController {
	private Game Game;
	private PlayerInfoController playerInfoController;
	private DiceController diceController;
	
	public GameController(int IdGame, String userName) {
		Game = new Game(IdGame, userName);
		playerInfoController = new PlayerInfoController(Game);
		playerInfoController.getPlayerInfoPanel();
		diceController = new DiceController();
		diceController.getDicePanel();
	}
	
	public Game getGame() {
		return Game;
	}
}
