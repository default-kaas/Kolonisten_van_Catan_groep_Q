package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.ChatPanelController;

public class ChatPanel extends JPanel {

	public JTextField inputField;
	ChatPanelController chatPanelController;
	public JTextArea textField;

	public ChatPanel() {

		// Dit is ff blauw voor een test, mag je weghalen

		inputField = new JTextField(80);
		textField = new JTextArea();
		textField.setPreferredSize(new Dimension(200, 200));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.19);
		this.add(inputField);
		this.add(textField);
		this.setPreferredSize(new Dimension(400, Height));
		this.setBackground(Color.BLUE);

		inputField = new JTextField();

		inputField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String chatInput = "";

				chatInput += inputField.getText();

			}
		});
		
		/*textField.setText(chatPanelController.getTextArray());*/
		


	}
}
