package Controller;

import Model.Dice;
import View.DicePanel;

public class DiceController {	
	private Dice dice;
	private DicePanel dicePanel;
	
	public DiceController() {
		dice = new Dice();
		dicePanel = new DicePanel();
	}
	
	private void setDiceImages() {
		dice.throwDice();
		dicePanel.setImages(getValue1(), getValue2());
	}
	public void throwDice() {
		dice.throwDice();
	}
	public int getValue1() {
		return dice.getValue1();
	}
	public int getValue2() {
		return dice.getValue2();
	}
}
