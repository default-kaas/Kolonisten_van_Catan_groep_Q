package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import Controller.ChatPanelController;

public class ChatPanel extends JPanel implements ActionListener {

	private JTextField inputField;
	private ChatPanelController chatPanelController;
	private JTextArea textField;

	private int height, width;

	public ChatPanel(ChatPanelController chatPanelController) {
		this.chatPanelController = chatPanelController;
		setScreenSize();
		setChatField();

	}

	private void setScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) (screenSize.getWidth() - screenSize.getHeight());
		height = (int) (screenSize.getHeight() * 0.2);
		this.setPreferredSize(new Dimension(width, height - 23));
		this.setBackground(new Color(147, 147, 229));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void setChatField() {

		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(width - 20, (int) (height * 0.1)));
		inputField.setBackground(new Color(211, 226, 237));
		textField = new JTextArea();

		textField.setEditable(false);
		textField.setAutoscrolls(true);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		textField.setBackground(new Color(211, 226, 237));

		DefaultCaret caret = (DefaultCaret) textField.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scrollPane = new JScrollPane(textField);

		scrollPane.setPreferredSize(new Dimension(width - 20, (int) (height * 0.8) - 23));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		this.add(scrollPane);
		this.add(inputField);

		textField.setText(chatPanelController.getTextArray());

		inputField.addActionListener(this);
	}

	public void updateText() {
		textField.setText(chatPanelController.getTextArray());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(inputField)) {
			if (!(inputField.getText().equals(""))) {
				chatPanelController.setUserInput(inputField.getText());
				inputField.setText("");
			}
			textField.setText(chatPanelController.getTextArray());
		}
	}

	// @Override
	// public void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// int width = (int) (screenSize.getWidth() - screenSize.getHeight());
	// int height = (int) (screenSize.getHeight() * 0.4);
	//
	// ImageIcon icon = new ImageIcon("images/Background/playerBg1.jpg");
	// JLabel thumb = new JLabel(icon);
	// thumb.setSize(width, height);
	// this.add(thumb);
	// }

}
