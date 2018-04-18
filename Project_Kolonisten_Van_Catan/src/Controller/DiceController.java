package Controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceController {
	
	
	Random random = new Random();

	private int min = 1;
	private int max = 6;
	private int value1;
	private int value2;
	private boolean thrown;

	public DiceController() {
		throwDice();
	}

	public void throwDice() {
		setValue1();
		setValue2();
	}
	
	public void setValue1() {
		value1 = random.nextInt(max - min + 1) + min;
	}
	
	public void setValue2() {
		value2 = random.nextInt(max - min + 1) + min;
	}
	
	public int getValue1() {
		return value1;
	}
	
	public int getValue2() {
		return value2;
	}

	public boolean thrown() {
		//This method checks if a player has thrown already thrown the dice once.
		
		return false;
	}
}
