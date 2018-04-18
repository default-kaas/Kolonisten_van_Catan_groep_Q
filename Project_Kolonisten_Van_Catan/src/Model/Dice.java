package Model;

public class Dice {
	private int value1;
	private int value2;
	private boolean canThrow;
	
	
	public int getValue1() {
		return value1;
	}
	public int getValue2() {
		return value2;
	}
	public boolean isCanThrow() {
		return canThrow;
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public void setCanThrow(boolean canThrow) {
		this.canThrow = canThrow;
	}
}
