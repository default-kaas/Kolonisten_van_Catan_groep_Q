package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spelscherm extends JPanel {
	BordPaneel SpelBord;
	ChatPaneel SpelChat;
	LogPaneel SpelLog;
	SpelerInformatiePaneel SpelerInfo;
	BouwInformatiePaneel BouwInfo;
	BouwPaneel Bouwen;
	DobbelsteenPaneel Dobbelsteen;
	

	public Spelscherm() {
		maakPanelenAan();

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight= 2;
		c.gridx = 0;
		c.gridy = 0;
		JLabel label1 = new JLabel("Speler Informatie");
		add(label1, c);
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
		JLabel label3 = new JLabel("Chat");
		add(label3, c);
		add(SpelChat, c);
	
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		JLabel label6 = new JLabel("Dobbesteen");
		add(label6, c);
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

	private void maakPanelenAan() {
		// TODO Auto-generated method stub
		SpelBord = new BordPaneel();
		SpelChat = new ChatPaneel();
		SpelLog = new LogPaneel();
		SpelerInfo = new SpelerInformatiePaneel();
		BouwInfo = new BouwInformatiePaneel();
		Bouwen = new BouwPaneel();
		Dobbelsteen = new DobbelsteenPaneel();
	}
}