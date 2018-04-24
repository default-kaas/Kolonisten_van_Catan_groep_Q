package Controller;

import java.sql.Connection;

import Model.Dice;
import Model.Game;
import View.DicePanel;

public class DiceController {	
	private Dice dice;
	private Game game;
	private DicePanel dicePanel;
	private GameController gameController;
	
	public DiceController(GameController gameController, Connection db_conn) {
		this.gameController = gameController;
		this.game = gameController.getGame();
		dice = new Dice(db_conn);
		dicePanel = new DicePanel(this);
		
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

	private void getOldValues() {
		dice.getOldValue1(game.getGameID());
		dice.getOldValue2(game.getGameID());
	}

	
}
