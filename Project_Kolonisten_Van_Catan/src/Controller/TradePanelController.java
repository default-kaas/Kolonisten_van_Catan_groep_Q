package Controller;

import View.TradeView;
import Model.Trade;

public class TradePanelController {
	
	private TradePanelController tc;

	private TradeView tradeview;
	private Trade trademodel;
	
	public TradePanelController() {
		
		tradeview = new TradeView();
		trademodel = new Trade();
		
	}
	
}

