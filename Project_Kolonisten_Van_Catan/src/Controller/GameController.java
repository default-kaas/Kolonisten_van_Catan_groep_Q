package Controller;
import Model.Game;
public class GameController {
	private Game Game;
	
	public GameController(int IdGame) {
		Game = new Game(IdGame);		
	}
}
