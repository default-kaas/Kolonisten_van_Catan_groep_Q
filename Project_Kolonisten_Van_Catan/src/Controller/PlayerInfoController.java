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

	public ArrayList getPlayerInfo1() {
		ArrayList PlayerInfo = new ArrayList();
		PlayerInfo.add(game.GetPlayers().get(0).getName());
		PlayerInfo.add(game.GetPlayers().get(0).getPlayerID());
		if (game.GetPlayers().get(0).getPlayerID() == game.getRound()) {
			PlayerInfo.add(true);
		} else {
			PlayerInfo.add(false);
		}
		return PlayerInfo;
	}

	public ArrayList getPlayerInfo2() {
		ArrayList PlayerInfo = new ArrayList();
		PlayerInfo.add(game.GetPlayers().get(1).getName());
		PlayerInfo.add(game.GetPlayers().get(1).getPlayerID());
		if (game.GetPlayers().get(1).getPlayerID() == game.getRound()) {
			PlayerInfo.add(true);
		} else {
			PlayerInfo.add(false);
		}
		return PlayerInfo;
	}

	public ArrayList getPlayerInfo3() {
		ArrayList PlayerInfo = new ArrayList();
		PlayerInfo.add(game.GetPlayers().get(2).getName());
		PlayerInfo.add(game.GetPlayers().get(2).getPlayerID());
		if (game.GetPlayers().get(2).getPlayerID() == game.getRound()) {
			PlayerInfo.add(true);
		} else {
			PlayerInfo.add(false);
		}
		return PlayerInfo;
	}

	public ArrayList getPlayerInfo4() {
		ArrayList PlayerInfo = new ArrayList();
		PlayerInfo.add(game.GetPlayers().get(3).getName());
		PlayerInfo.add(game.GetPlayers().get(3).getPlayerID());
		if (game.GetPlayers().get(3).getPlayerID() == game.getRound()) {
			PlayerInfo.add(true);
		} else {
			PlayerInfo.add(false);
		}
		return PlayerInfo;
	}

}
