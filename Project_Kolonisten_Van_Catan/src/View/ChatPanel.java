package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ChatPanelController;

public class ChatPanel extends JPanel {
	
	private JTextField chatField;
	ChatPanelController chatPanelController;
	public ChatPanel() {

		// Dit is ff blauw voor een test, mag je weghalen
	 chatPanelController = new ChatPanelController();
	 chatField = new JTextField(80);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int)(screenSize.getHeight()*0.19);
		this.add(chatField);
		this.setPreferredSize(new Dimension(400, Height));
		this.setBackground(Color.BLUE); 
		
		
		chatField = new JTextField();
		
		chatField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String chatInput = "";
				
				chatInput += chatField.getText().toString();
				
				
				
				
				
			}
		});
		
		
	}
}
