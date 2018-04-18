package Controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceController {

	Random random = new Random();

	private int min = 1;
	private int max = 6;
	private int value1;
	private int value2;

	public DiceController() {
		dobbelen();
	}

	public int dobbelen() {

		int sum = 0;

		// Each dice gives a random number between 1 and 6. Both are added up to make up
		// for the sum which is then returned.
		

		sum = getValue1() + getValue2();

		return sum;

	}
	
	public int getValue1() {
		value1 = random.nextInt(max - min + 1) + min;
		
		return value1;
	}
	
	public int getValue2() {
		value2 = random.nextInt(max - min + 1) + min;
		
		return value2;
	}

	public boolean thrown() {
		//This method checks if a player has thrown already thrown the dice once.
		
		return false;
	}
}
