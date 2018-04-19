package Controller;

import java.util.ArrayList;
import View.SpelerInformatiePanel;
import Model.Game;
import Model.Player;

public class PlayerInfoController {
	private Game game;
	private SpelerInformatiePanel SpelerInformatiePanel;

	public PlayerInfoController(Game game) {
		SpelerInformatiePanel = new SpelerInformatiePanel(this);
		this.game = game;
		SpelerInformatiePanel.ShowPlayers();

	}

	public String getPlayerName(int volgnr) {
		return game.GetPlayers().get(volgnr).getName();
	}

	public String getPlayerColor(int volgnr) {
		return game.GetPlayers().get(volgnr).getColor();
	}

	public boolean myTurn(int volgnr) {
		if (game.getRound() == game.GetPlayers().get(volgnr).getPlayerID()) {
			return true;
		} else {
			return false;
		}
	}

	public SpelerInformatiePanel getPlayerInfoPanel() {
		return SpelerInformatiePanel;
	}
}
