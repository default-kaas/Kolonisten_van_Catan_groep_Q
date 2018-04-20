package Controller;

import java.sql.Connection;

import Model.Dice;
import Model.Game;
import View.DicePanel;

public class DiceController {	
	private Dice dice;
	private Game game;
	private DicePanel dicePanel;
	
	public DiceController(Game game, Connection db_conn) {
		this.game = game;
		dice = new Dice(db_conn);
		dicePanel = new DicePanel(this);
		
	}
	
	public DicePanel getDicePanel() {
		return dicePanel;
	}
	
	public void setDiceImages() {
		dice.throwDice(game.getGameID());
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
}
