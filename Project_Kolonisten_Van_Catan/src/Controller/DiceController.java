package Controller;

import Model.Dice;
import View.DicePanel;

public class DiceController {	
	private Dice dice;

//	@Dogen, DiceController word aangemaakt in DicePanel en DicePanel in DiceController!
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
	private int getValue1() {
		return dice.getValue1();
	}
	private int getValue2() {
		return dice.getValue2();
	}
}
