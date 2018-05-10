package Controller;

import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;
import Database.BuildDAO;
import Model.Game;
import View.BuildPanel;

public class BuildPanelController extends Observable implements Observer {

	private Game game;
	private BuildPanel bouwPanel;
	private GameController gameController;
	private BuildDAO buildDAO;
	private Connection db_conn;


	public BuildPanelController(Game game, Connection db_conn, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
		this.db_conn = db_conn;
		buildDAO = new BuildDAO(db_conn);
		bouwPanel = new BuildPanel(this);
		disableButtons();
	}

	public String remainingWood() {
		String x = "" +  game.getMe().getWoodAmount();
		return x;
	}
	
	public String remainingStone() {
		String x = "" +  game.getMe().getStoneAmount();
		return x;
	}
	
	public String remainingOre() {
		String x = "" +  game.getMe().getOreAmount();
		return x;
	}
	
	public String remainingWool() {
		String x = "" +  game.getMe().getWoolAmount();
		return x;
	}
	
	public String remainingWheat() {
		String x = "" +  game.getMe().getWheatAmount();
		return x;
	}
	public BuildPanel getBouwPanel() {
		return bouwPanel;
	}

	public boolean checkRecoursesRoad() {

		int wood = game.getMe().getWoodAmount();
		int stone = game.getMe().getStoneAmount();

		if (wood >= 1 && stone >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean PlayerHasHouse() {
		if (buildDAO.checkIfPlayerHasHouse(game.getGameID(), game.getMe().getPlayerID()) >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void removeStreetRes() {
		game.removeStreet();
	}

	public void removeHouseRes() {
		game.removeHouse();
	}

	public void removeCityRes() {
		game.removeCity();
	}

	public void removeDevRes() {
		game.removeDev();
	}

	public boolean checkResourcesHouse() {
		int wood = game.getMe().getWoodAmount();
		int stone = game.getMe().getStoneAmount();
		int wheat = game.getMe().getWheatAmount();
		int wool = game.getMe().getWoolAmount();

		if (wood >= 1 && stone >= 1 && wool >= 1 && wheat >= 1 && wool >= 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkResourcesCity() {
		int erts = game.getMe().getOreAmount();
		int graan = game.getMe().getWheatAmount();

		if (erts >= 3 && graan >= 2) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkResourcesDevCard() {
		int erts = game.getMe().getOreAmount();
		int graan = game.getMe().getWheatAmount();
		int wool = game.getMe().getWoolAmount();

		if (erts >= 1 && graan >= 1 && wool >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void getMe() {
		game.getMe();
	}
	
	public void buyPrint(String x, String y) {
		gameController.setBuildMessage(x, y)	;
		this.setChanged();
		this.notifyObservers();
	}

	public void disableButtons() {
		bouwPanel.disableButtons();
	}

	public void showButtons() {
		bouwPanel.allCheck();
	}

	public void givePlayerRandomCard() {
		buildDAO.givePlayerRandomCard(game.getMe().getPlayerID());
	}	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		showButtons();
	}

	

}
