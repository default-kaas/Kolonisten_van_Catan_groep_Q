package View;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Spelscherm extends JPanel {
	BordPaneel SpelBord;
	ChatPaneel SpelChat;
	LogPaneel SpelLog;
	SpelerInformatiePaneel SpelerInfo;

	public Spelscherm() {
		maakPanelenAan();
		
		this.setLayout(new MigLayout()());
		
		add(SpelerInfo);
		add(SpelBord);
		
		add(SpelChat);
		add(SpelLog);

	}

	private void maakPanelenAan() {
		// TODO Auto-generated method stub
		SpelBord = new BordPaneel();
		SpelChat = new ChatPaneel();
		SpelLog = new LogPaneel();
		SpelerInfo = new SpelerInformatiePaneel();

	}
}