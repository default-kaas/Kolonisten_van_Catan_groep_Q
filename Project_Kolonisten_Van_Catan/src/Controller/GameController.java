package Controller;

import Model.Game;

public class GameController {
	private Game Game;

	public GameController(int IdGame, String userName) {
		Game = new Game(IdGame, userName);
	}

	public Game getGame() {
		return Game;
	}
}
