package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import View.PlayerInformationPanel;
import Model.Game;
import Model.Player;

public class PlayerInfoController {
	private Game game;
	private PlayerInformationPanel spelerInformatiePanel;
	private GameController gameController;

	public PlayerInfoController(Game game, Connection db_conn, GameController gameController) {
		spelerInformatiePanel = new PlayerInformationPanel(this);
		this.game = game;
		spelerInformatiePanel.UpdatePlayerTurn();
		spelerInformatiePanel.ShowTradeButton();
		spelerInformatiePanel.ShowResources();
		this.gameController = gameController;
		
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

	public PlayerInformationPanel getPlayerInfoPanel() {
		return spelerInformatiePanel;
	}
	public void UpdateResourcePanel() {
		spelerInformatiePanel.ShowResources();
	}
	
	public void getTradePanel() {
		System.out.println("gg hij is in de player controller gekomen nou gaan we terug naar de gamecontroller");
		gameController.getTradeFrame();
	}
}
