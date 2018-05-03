package Controller;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;

import Database.PlayerDAO;
import Model.Game;
import View.PlayerInformationPanel;

public class PlayerInfoController {
	private Game game;
	private PlayerInformationPanel spelerInformatiePanel;
	private GameController gameController;
	private PlayerDAO playerDAO;

	public PlayerInfoController(Game game, Connection db_conn, GameController gameController) {
		spelerInformatiePanel = new PlayerInformationPanel(this);
		this.game = game;
		playerDAO = new PlayerDAO(db_conn);
		spelerInformatiePanel.playerInfo();
		spelerInformatiePanel.allInfo();
		spelerInformatiePanel.playerResources();
		spelerInformatiePanel.TradeButton();
		spelerInformatiePanel.testRidder();
		spelerInformatiePanel.testRoad();
		/*spelerInformatiePanel.ShowResources();*/
		spelerInformatiePanel.endButton();
		this.gameController = gameController;
		disableTradeButton();

	}

	public String getPlayerName(int volgnr) {
		return game.GetPlayers().get(volgnr).getName();
	}

	public String getPlayerColor(int volgnr) {
		return game.GetPlayers().get(volgnr).getColor();
	}

	public int getPlayerResources(int volgnr) {
		return game.getPlayerResources();
	}
	
	public String getLargestArmy(int gameId) {
		return playerDAO.getLargestArmyID(gameId);
	}
	
	
	public String getLongestRoad(int gameId) {
		return playerDAO.getLongestRoadID(gameId);
	}
	
	public String checkArmy() {
		String x = "";
		for (int i = 0; i < game.GetPlayers().size(); i++) {
			if (game.GetPlayers().get(i).getName().equals(getLargestArmy(game.getGameID()))) {
				x += game.GetPlayers().get(i).getName();
				return x;
			}
			
		}
		return null;
		
	}
	
	public String checkLongestRoad() {
		String x = "";
		for (int i = 0; i < game.GetPlayers().size(); i++) {
			if (game.GetPlayers().get(i).getName().equals(getLongestRoad(game.getGameID()))) {
				x += game.GetPlayers().get(i).getName();
				return x;
			}
			
		}
		return null;
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
