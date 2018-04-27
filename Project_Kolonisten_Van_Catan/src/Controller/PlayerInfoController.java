package Controller;

import java.sql.Connection;

import Model.Game;
import View.PlayerInformationPanel;

public class PlayerInfoController {
	private Game game;
	private PlayerInformationPanel spelerInformatiePanel;
	private GameController gameController;

	public PlayerInfoController(Game game, Connection db_conn, GameController gameController) {
		spelerInformatiePanel = new PlayerInformationPanel(this);
		this.game = game;
		spelerInformatiePanel.UpdatePlayerTurn();
		
		spelerInformatiePanel.TradeButton();
		spelerInformatiePanel.ShowResources();
		this.gameController = gameController;
		disableTradeButton();
		
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
	
	public void showTradeButton() {
		spelerInformatiePanel.ShowTradeButton();
	}
	public void disableTradeButton() {
		spelerInformatiePanel.DisableTradeButton();
	}
	
	
	public int getWoodAmount() {
		return game.getMe().getWoodAmount();
	}
	
	public int getWoolAmount() {
		return game.getMe().getWoolAmount();
	}

	public int getOreAmount() {
		return game.getMe().getOreAmount();
	}

	
	public int getWheatAmount() {
		return game.getMe().getWheatAmount();
	}
	
	public int getStoneAmount() {
		return game.getMe().getStoneAmount();
	}


	public PlayerInformationPanel getPlayerInfoPanel() {
		return spelerInformatiePanel;
	}
	public void UpdateResourcePanel() {
		spelerInformatiePanel.ShowResources();
	}
	
	public void getTradePanel() {
		gameController.getTradeFrame();
	}
}
