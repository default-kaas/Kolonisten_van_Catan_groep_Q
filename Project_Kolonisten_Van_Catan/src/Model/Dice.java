package Model;

import java.util.Random;

import Database.DiceDAO;

public class Dice {
	private int min = 1;
	private int max = 6;
	private int value1;
	private int value2;
	private DiceDAO diceDAO;
	
	Random random = new Random();
	
	public Dice() {
		diceDAO = new DiceDAO();
	}
	
	public void throwDice() {
		setValue1();
		setValue2();
		diceDAO.setDiceValues(getValue1(), getValue2());
	}
	
	public int getValue1() {
		return value1;
	}
	public int getValue2() {
		return value2;
	}
	
	public void setValue1() {
		value1 = random.nextInt(max - min + 1) + min;
	}
	public void setValue2() {
		value2 = random.nextInt(max - min + 1) + min;
	}
	
	
}
