package Controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dobbelsteen {

Random random = new Random();

private int min = 1;
private int max = 6;
private int value1;
private int value2;

public Dobbelsteen() {
	dobbelen();
}


public int dobbelen() {
	
	int sum = 0;
	
	//Each dice gives a random number between 1 and 6. Both are added up to make up for the sum which is then returned.
	value1 = random.nextInt(max - min + 1) + min;
	value2 = random.nextInt(max - min + 1) + min;
	
	sum = value1 + value2;
	
	return sum;
	
	
	
}
}
