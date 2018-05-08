package Controller;

import java.sql.Connection;

import Model.Game;
import Model.Player;
import Model.Trade;
import View.TradeFrame;
import View.TradePanel;

public class TradeController {
	
	private TradeController tc;
	
	private Player player;
	private Game game;
	
	private TradePanel tradeView;
	private TradeFrame tradeFrame;
	private Trade trademodel;
	
	int card = 0;
	
	public TradeController(TradeFrame tf, Connection db_conn, Game game) {
		this.game = game;
	    tradeFrame = tf;
		tradeView = new TradePanel(this);
		trademodel = new Trade(this);
	}
	
	public void setPanel(TradePanel tp) {
		this.tradeView = tp;
	}
	
	public void disposeFrame() {
		tradeFrame.disposethis();
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
	
	public TradePanel getTradePanel() {
		return tradeView;
	}
	
	public void getFrame() {
		tradeView.setFrame(tradeFrame);
	}
	
	public void getTradeFrame() {
		tradeView.showFrame();
	}
	
	public void setPlayerCards(String Card, int Amount) {
		game.getPlayerDAO().addResources(game.getGameID(), game.getMe(), Card, Amount);
	}
	
	public void doesBankHave(String Card) {
		game.getPlayerDAO().checkBank(game.getGameID(), Card);
		getBoolean();
	}
	
	public void getBoolean() {
		if (game.getPlayerDAO().getyes() == true) {
			tradeView.setAvailability(true);
		}
		if (game.getPlayerDAO().getyes() == false) {
			tradeView.setAvailability(false);			
		}
	}
	
	
}

