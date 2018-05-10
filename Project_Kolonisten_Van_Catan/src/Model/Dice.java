package Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import Database.DiceDAO;

public class Dice {
	private int min = 1;
	private int max = 6;
	private int value1;
	private int value2;
	private DiceDAO diceDAO;

	Random random = new Random();

	public Dice(Connection db_conn) {
		diceDAO = new DiceDAO(db_conn);
	}

	public void throwDice(int GameID) {
		setValue1();
		setValue2();
		diceDAO.setDiceValues(getValue1(), getValue2(), GameID);
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

	public boolean hasTrownDice(int GameID) {
		return diceDAO.hasTrownDice(GameID);
	}

	public void getOldValue1(int GameID) {
		value1 = diceDAO.getOldValue1(GameID);
	}

	public void getOldValue2(int GameID) {
		value2 = diceDAO.getOldValue2(GameID);
	}
	
	public boolean giveResourceToPlayers(int gameID,int playerID,char resourceType,int amount) {
		return diceDAO.giveResourceToPlayers(gameID, playerID, resourceType, amount);
	}
	
	public ArrayList<Integer> getPlayerCities(int gameID){
		return diceDAO.getPlayerCities(gameID);
	}
	
	public ArrayList<Integer> getPlayerTowns(int gameID){
		return diceDAO.getPlayerTowns(gameID);
	}

}
