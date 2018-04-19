package Controller;

import Model.Game;

public class GameController {
	private Game Game;
	private PlayerInfoController PlayerInfoController;

	public GameController(int IdGame, String userName) {
		Game = new Game(IdGame, userName);
		PlayerInfoController = new PlayerInfoController(Game);
		PlayerInfoController.getPlayerInfoPanel();
	}

	public Game getGame() {
		return Game;
	}
}
