package Controller;

import java.sql.Connection;

import Model.Game;
import Model.Player;
import View.BuildPanel;

public class BuildPanelController {

	private Game game;
	private BuildPanel bouwPanel;
	private GameController gameController;

	public BuildPanelController(Game game, Connection db_conn, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
		bouwPanel = new BuildPanel(this);
	}

	public BuildPanel getBouwPanel() {
		return bouwPanel;
	}

	public boolean checkRecoursesRoad() {

		int wood = game.getMe().getWoodAmount();
		int stone = game.getMe().getStoneAmount();

		if (wood >= 1 && stone >= 1) {

			System.out.println(stone);
			return true;
		} else {
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
	}

}
