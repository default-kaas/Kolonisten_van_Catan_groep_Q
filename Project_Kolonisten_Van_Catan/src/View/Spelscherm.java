package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class Spelscherm extends JPanel {
	BordPanel SpelBord;
	ChatPanel SpelChat;
	LogPanel SpelLog;
	SpelerInformatiePanel SpelerInfo;
	BouwInformatiePanel BouwInfo;
	BouwPanel Bouwen;
	DicePanel Dobbelsteen;
	GameController GameController;
	

	public Spelscherm(int GameID, String userName) {
		GameController = new GameController(GameID, userName);
		
		MakePanels();

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight= 2;
		c.gridx = 0;
		c.gridy = 0;
		add(SpelerInfo, c);
		
		c.gridheight= 2;
		c.gridx = 0;
		c.gridy = 2;
		JLabel label4 = new JLabel("Geschiedenis Log");
		add(label4, c);
		add(SpelLog, c);
		
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight= 1;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 0;
		add(SpelChat, c);
	
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(Dobbelsteen, c);
		
	
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.gridx = 1;
		c.gridy = 1;
		JLabel label2 = new JLabel("Spel Bord");
		add(label2, c);
		add(SpelBord, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 2;
		c.gridwidth = 1;
		c.gridx = 5;
		c.gridy = 0;
		JLabel label7 = new JLabel("Bouwen");
		add(label7, c);
		add(Bouwen, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight = 2;
		
		c.gridx = 5;
		c.gridy = 2;
		JLabel label5 = new JLabel("Bouwkaart");
		add(label5, c);
		add(BouwInfo, c);
		
		

	}

	private void MakePanels() {
		// TODO Auto-generated method stub
		SpelBord = new BordPanel();
		SpelChat = new ChatPanel(GameController);
		SpelLog = new LogPanel();
		SpelerInfo = new SpelerInformatiePanel(GameController);
		BouwInfo = new BouwInformatiePanel();
		Bouwen = new BouwPanel();
		Dobbelsteen = new DicePanel();
	}
}