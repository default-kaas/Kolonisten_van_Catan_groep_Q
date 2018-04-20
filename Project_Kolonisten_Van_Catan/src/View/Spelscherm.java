package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class Spelscherm extends JPanel {
	BordPanel SpelBord;
	ChatPanel SpelChat;
	SpelerInformatiePanel SpelerInfo;
	BouwPanel Bouwen;
	DicePanel Dobbelsteen;
	GameController GameController;
	

	public Spelscherm(int GameID, String userName, Connection db_conn, boolean newGame) {
		GameController = new GameController(GameID, userName);
		SpelChat = new ChatPanel(GameController, db_conn);
		MakePanels();

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight= 2;
		c.gridx = 0;
		c.gridy = 0;
		add(SpelerInfo, c);
		
		c.gridheight= 2;
		
		c.gridy = 2;
		add(Bouwen, c);

		c.gridheight= 1;
//		c.gridwidth = 2;
		c.gridy = 4;
		add(SpelChat, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(Dobbelsteen, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight = 5;
		c.gridwidth = 5;
		JLabel label2 = new JLabel("Spel Bord");
		add(label2, c);
		add(SpelBord, c);

	}

	private void MakePanels() {
		// TODO Auto-generated method stub
		SpelBord = new BordPanel();
		
		SpelerInfo = GameController.getSpelerInfoPanel();
		Bouwen = GameController.getBouwPanel();
		Dobbelsteen = GameController.getDicePanel();
	}
}