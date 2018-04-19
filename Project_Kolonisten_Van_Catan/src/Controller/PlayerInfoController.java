package Controller;

import java.util.ArrayList;

import Model.Game;
import Model.Player;

public class PlayerInfoController {
	private GameController gameController;
	private Game game;

	public PlayerInfoController(GameController gameController) {
		this.gameController = gameController;
		game = gameController.getGame();
	}

	public ArrayList getPlayerInfo() {
		ArrayList PlayerInfo = new ArrayList();
		for(Player x : game.GetPlayers()) {
			//Naam op plek 0,3,6,9
			PlayerInfo.add(x.getName());
			//PlayerID op plek 1,4,7,10
			PlayerInfo.add(x.getPlayerID());
			//Of het de players beurt is op plek 2,5,8,11
			if (x.getPlayerID() == game.getRound()) {
				PlayerInfo.add(true);
			} else {
				PlayerInfo.add(false);
			}
		}		
		return PlayerInfo;
	}
}
