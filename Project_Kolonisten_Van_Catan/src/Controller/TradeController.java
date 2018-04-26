package Controller;

import View.TradeView;

import java.sql.Connection;

import Model.Game;
import Model.Player;
import Model.Trade;

public class TradeController {
	
	private TradeController tc;
	
	private Player player;
	private Game game;

	private TradeView tradeview;
	private Trade trademodel;
	
	int card = 0;
	
	public TradeController(Game game, Connection db_conn) {
		
		tradeview = new TradeView(this);
		trademodel = new Trade(this);
		this.game = game;
		
	}
	
	public int getPlayerCards(int Card) {
		
		if (Card == 1) {
			card = game.getMe().getWoolAmount();
			return card;
		}
		if (Card == 2) {
			card = game.getMe().getWheatAmount();
			return card;
		}
		if (Card == 3) {
			card = game.getMe().getWoodAmount();
			return card;
		}
		if (Card == 4) {
			card = game.getMe().getStoneAmount();
			return card;
		}
		if (Card == 5) {
			card = game.getMe().getOreAmount();
			return card;
		}
		else return Card;
	}
	
	public void getTradeFrame() {
		tradeview.showFrame();
	}
	
	
}

