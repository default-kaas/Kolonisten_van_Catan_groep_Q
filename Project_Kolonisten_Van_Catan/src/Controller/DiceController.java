package Controller;

import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

import com.mysql.fabric.xmlrpc.base.Array;

import Model.Corner;
import Model.Dice;
import Model.Game;
import Model.Tile;
import View.DicePanel;

public class DiceController extends Observable {
	private Dice dice;
	private Game game;
	private DicePanel dicePanel;
	private GameController gameController;
	private BoardController boardController;

	public DiceController(GameController gameController, Connection db_conn, BoardController boardController) {
		this.gameController = gameController;
		this.game = gameController.getGame();
		dice = new Dice(db_conn);
		dicePanel = new DicePanel(this);
		this.boardController = boardController;
		giveResourcesToPlayers(770, 5);
	}

	public DicePanel getDicePanel() {
		return dicePanel;
	}

	public void setDiceImages() {
		dice.throwDice(game.getGameID());
		gameController.setDiceMessage(getValue1(), getValue2());
		game.getMe().setThrown();
		dicePanel.setImages(getValue1(), getValue2());
	}

	public void throwDice() {
		dice.throwDice(game.getGameID());
	}

	private int getValue1() {
		return dice.getValue1();
	}

	private int getValue2() {
		return dice.getValue2();
	}

	public int getTotal() {
		return getValue1() + getValue2();
	}

	public void showDice() {
		// TODO Auto-generated method stub
		dicePanel.showDice();
	}

	public boolean hasTrown() {
		// TODO Auto-generated method stub
		return dice.hasTrownDice(game.getGameID());
	}

	public void showOldDice() {
		getOldValues();
		dicePanel.setImages(getValue1(), getValue2());
	}

	public void updateOtherPanels() {
		this.setChanged();
		this.notifyObservers();
	}

	private void getOldValues() {
		dice.getOldValue1(game.getGameID());
		dice.getOldValue2(game.getGameID());
	}

	public void giveResourcesToPlayers(int gameID, int diceRoll) {

		ArrayList<Point> getCity = boardController.getBoughtCity(gameID);
		ArrayList<Point> getTown = boardController.getBoughtTown(gameID);
		ArrayList<Integer> getBoughtPlayerID = boardController.getBoughtPlayerID(gameID);
		ArrayList<Tile> tiles = boardController.getTiles();
		ArrayList<Point> matchCityCorner = new ArrayList<Point>();
		ArrayList<Tile> matchTiles = new ArrayList<Tile>();
		char resourcetype = 'G';
		for (Tile t : tiles) {
			if (t.getIdNumberChip() == diceRoll && t.isRobber() == false) {
				ArrayList<Point> cornerPoint = t.getCornerPoints();
				for (Point p : cornerPoint) {
					for (Point to : getTown) {
						if (to.x == p.x && to.y == p.y) {
						}
					}
					for (Point c : getCity) {
						if (c.x == p.x && c.y == p.y) {
							matchCityCorner.add(p);
							matchTiles.add(t);
							System.out.println(p.x + " " + p.y + " " + t.getIdResourceType());
						}

					}
				}

			}
		}

		/*
		 * for (int i = 0; i < arrayListIdNumberChip.size(); i++) { if
		 * (arrayListIdNumberChip.get(i) == diceRoll) {
		 * System.out.println(arrayListIdResoucreType.get(i) + " "); }
		 * 
		 * }
		 */

	}

}
