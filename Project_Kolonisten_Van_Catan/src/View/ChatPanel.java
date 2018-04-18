package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Controller.ChatPanelController;

public class ChatPanel extends JPanel {

	public JTextField inputField;
	ChatPanelController chatPanelController;
	public JTextArea textField;

	public ChatPanel() {

		// Dit is ff blauw voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.2);
		this.setPreferredSize(new Dimension(400, Height));
		this.setBackground(Color.BLUE);
		
		chatPanelController = new ChatPanelController();

		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(540, 25));
		textField = new JTextArea();
		
		textField.setEditable(false);
		textField.setAutoscrolls(true);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		
		JScrollPane x = new JScrollPane(textField);
		
		x.setPreferredSize(new Dimension(540, 150));
		x.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		

	
//		this.add(textField);
		this.add(x);
		this.add(inputField);
		
		textField.setText(chatPanelController.getTextArray());

		inputField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(inputField.getText().equals(""))) {
					chatPanelController.setUserInput(inputField.getText());
					inputField.setText("");
				}
				textField.setText(chatPanelController.getTextArray());

			}
		});

	}
}
