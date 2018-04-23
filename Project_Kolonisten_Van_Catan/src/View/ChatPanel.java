package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import Controller.ChatPanelController;

public class ChatPanel extends JPanel {

	public JTextField inputField;
	private ChatPanelController chatPanelController;
	public JTextArea textField;


	public ChatPanel(ChatPanelController chatPanelController) {
		this.chatPanelController = chatPanelController;
		
		//Panel
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() - screenSize.getHeight());
		int height = (int) (screenSize.getHeight() * 0.2);
		this.setPreferredSize(new Dimension(width, height-23));
		this.setBackground(Color.GREEN);
		

		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(width-20, (int)(height*0.1)));
		textField = new JTextArea();
		
		textField.setEditable(false);
		textField.setAutoscrolls(true);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		DefaultCaret caret = (DefaultCaret)textField.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		JScrollPane x = new JScrollPane(textField);
		
		x.setPreferredSize(new Dimension(width-20, (int)(height*0.8)-23));
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
	public void updateText() {
		textField.setText(chatPanelController.getTextArray());
	}
}
