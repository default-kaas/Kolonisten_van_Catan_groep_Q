package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Controller.LobbyController;

public class LobbyPanel extends JPanel {

	
	private JTable invitedList;
	private JButton normalMode;
	private JButton advancedMode;
	public LobbyController lobbyController;
	GridBagConstraints c;
	
	public LobbyPanel(LobbyController lobbyController){
		
		this.setLayout(new GridBagLayout());
		
		JLabel startGame = new JLabel("Spel Crieëren");
		startGame.setFont(new Font("Arial", Font.BOLD, 20));
		startGame.setForeground(Color.BLACK);
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(startGame, c);
		
		normalMode = new JButton("Start Normal Mode");
		
		
		advancedMode = new JButton("Start Advanced Mode");
		
		
		
	/*	Object[][] data = inviteController.showUsers();
		
		invitedList = new JTable(data, columns);*/
		invitedList.setFont(new Font("Calibri", Font.BOLD, 30));
		invitedList.setRowHeight(100);
		TableColumnModel columnModel = invitedList.getColumnModel();
		invitedList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
		invitedList.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(0, 0, 0, 500);	
		gbc_table.gridwidth = 3;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(invitedList, gbc_table);
		this.setLayout(new GridBagLayout());
		this.add(normalMode);
		this.add(advancedMode);
		this.lobbyController = lobbyController;
		
		
		
		
		
		
	}
	
	
}
