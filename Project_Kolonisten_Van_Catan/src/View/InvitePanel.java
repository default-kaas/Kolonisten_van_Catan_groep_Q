package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Controller.InviteController;

public class InvitePanel extends JPanel {
	private JTable playerList;
	private JTable playerFinding;
	public InviteController inviteController;
	Object[][] data;
	String[] column;

	public InvitePanel(InviteController inviteController) {
		this.inviteController = inviteController;
		data = inviteController.showUsers();
		setPreferredSize(new Dimension(350, 300));
		setBackground(new Color(157, 24, 31));
		column = new String[] { "Name", "speelstatus" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		setLayout(gridBagLayout);

		lobbyTitle();
		
		lobbyTable();
		
		lobbyButtons();
		
		findingTitle();
		
		findingTable();
		
		findingButton();

	

		
		
		
		
		
	
	}
	
	public void lobbyTitle() {
		
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		
		JLabel lblLobby = new JLabel("Lobby");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 50));
		
		gbc_lblLobby.insets = new Insets(0, 0, 80, 150);
		gbc_lblLobby.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLobby.gridx = 0;
		gbc_lblLobby.gridy = 0;
		add(lblLobby, gbc_lblLobby);
		
	}
	
	
	public void lobbyTable() {
		
		playerList = new JTable(data, column);
		playerList.setFont(new Font("Calibri", Font.BOLD, 30));
		playerList.setRowHeight(100);
		
	
		TableColumnModel columnModel = playerList.getColumnModel();
		playerList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
		playerList.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(0, 0, 80, 150);	
		
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(playerList, gbc_table);
		
	}
	
	public void lobbyButtons() {
		
		JButton refreshBtn = new JButton("Refresh");	
		refreshBtn.setPreferredSize(new Dimension(200, 100));
		refreshBtn.setBackground(new Color(59, 89, 182));
		refreshBtn.setForeground(Color.BLACK);
		refreshBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_inviteBtn = new GridBagConstraints();
		gbc_inviteBtn.insets = new Insets(0 ,0, 80, 150);
		
		gbc_inviteBtn.anchor = GridBagConstraints.WEST;
		gbc_inviteBtn.gridx = 0;
		gbc_inviteBtn.gridy = 2;
		add(refreshBtn, gbc_inviteBtn);
		
	}
	
	public void findingTitle() {
		JLabel lblFinding = new JLabel("Finding Players");
		lblFinding.setFont(new Font("Arial", Font.BOLD, 50));
		GridBagConstraints gbc_lblFinding = new GridBagConstraints();
		gbc_lblFinding.insets = new Insets(0, 150, 80, 0);
		gbc_lblFinding.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFinding.gridx = 1;
		gbc_lblFinding.gridy = 0;
		add(lblFinding, gbc_lblFinding);
	}
	
	public void findingTable() {
		
		playerFinding = new JTable(data, column);
		playerFinding.setFont(new Font("Calibri", Font.BOLD, 30));
		playerFinding.setRowHeight(100);
		TableColumnModel columnModel1 = playerFinding.getColumnModel();
		playerFinding.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		for (int i = 0; i < columnModel1.getColumnCount(); i++) {
		playerFinding.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 3;
		gbc_table_1.insets = new Insets(0, 150, 80, 0);
		gbc_table_1.anchor = GridBagConstraints.EAST;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 1;
		add(playerFinding, gbc_table_1);
		
	}
	
	public void findingButton() {
		
		JButton inviteBtn = new JButton("Invite Players");	
		inviteBtn.setPreferredSize(new Dimension(200, 100));
		inviteBtn.setBackground(new Color(59, 89, 182));
		inviteBtn.setForeground(Color.BLACK);
		inviteBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_inviteBtn1 = new GridBagConstraints();
		gbc_inviteBtn1.insets = new Insets(0, 150, 80, 0);
		gbc_inviteBtn1.anchor = GridBagConstraints.EAST;
		gbc_inviteBtn1.gridx = 1;
		gbc_inviteBtn1.gridy = 2;
		add(inviteBtn, gbc_inviteBtn1);
		
	}
	
	
	

}
