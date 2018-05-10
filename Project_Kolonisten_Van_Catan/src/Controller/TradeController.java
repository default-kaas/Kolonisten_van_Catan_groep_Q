package Controller;

import java.sql.Connection;

import Model.Game;
import Model.Player;
import Model.Trade;
import View.TradeFrame;
import View.TradePanel;
import View.TradePopup;

public class TradeController {
	
	private Game game;
	
	private TradePanel tradeView;
	private TradeFrame tradeFrame;
	private Trade trademodel;
	private TradePopup tpup;
	
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
	
	public void setModel(Trade tm) {
		trademodel = tm;
	}
	
	public void getTradeFrame() {
		tradeView.showFrame();
	}
	
	public void setPlayerCards(String Card, int Amount) {
		game.getPlayerDAO().addResources(game.getGameID(), game.getMe().getPlayerID(), Card, Amount);
	}
	
	public void removePlayerCards(String Card, int Amount) {
		game.getPlayerDAO().removeResources(game.getGameID(), game.getMe().getPlayerID(), Card, Amount);
	}
	
	public void doesBankHave(String Card) {
		tradeView.setAvailability(game.getPlayerDAO().checkBank(game.getGameID(), Card));
	}

	public void getHavens(String grondstof) {
		processHavens(game.getPlayerDAO().checkHaven(game.getMe().getPlayerID(), grondstof));
	}
	
	public void processHavens(String string) {
		if (string == null) {
			tradeView.set("driehaven");
		}
		else if (string.equals("B") ||string.equals("G") ||string.equals("W") ||string.equals("H") ||string.equals("E") ) {
			tradeView.set(string);
		}
	}
	
	private int v1;
	private String resource1;
	private int v2;
	private String resource2;
	
	public void trademsg1(int value1, String resource1) {
		v1 = value1;
		this.resource1 = resource1;
	}
	
	public void trademsg2(int value2, String resource2) {
		v2 = value2;
		this.resource2 = resource2;
		trademessage();
	}
	
	public void trademessage() {
		tradeFrame.getgc().setTradeMessage(v1, resource1, v2, resource2, "De Bank");
		System.out.println(v1 + resource1 + v2 + resource2);
	}
	
	public TradeFrame getTradeFrameFromController() {
		return tradeFrame;
	}
	
	public void showScreen(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		for (int i = 0; i < 4; i++) {
			if (tradeFrame.getgc().getGame().GetPlayers().get(i).getName() != tradeFrame.getgc().getGame().getMe().getName()) {
				showForPlayers(tradeFrame.getgc().getGame().GetPlayers().get(i).getName(), string, string2, string3, string4, string5, string6, string7, string8, string9, string10);
			}
		}
	}
	
	public void showForPlayers(String string, String string2, String string22, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		if (string == tradeFrame.getgc().getGame().getMe().getName()) {
			tpup = new TradePopup(this, tradeFrame.getgc().getGame().getMe().getName(), string, string2, string3, string4, string5, string6, string7, string8, string9, string10);
		}
	}
	
	
}

