package Controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dobbelsteen {

Random random = new Random();

private int min = 1;
private int max = 6;
private int value1 = random.nextInt(max - min + 1) + min;
private int value2 = random.nextInt(max - min + 1) + min;

public Dobbelsteen() {
	dobbelen();
}


public int dobbelen() {
	
	int sum = 0;
	
	sum += value1 + value2;
	
	
	return sum;
	
	
	
}
}
