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

import Controller.LobbyController;

public class LobbyPanel extends JPanel {
	private JTable playerList;
	private JTable playerFinding;
	public LobbyController lobbyController;

	/**
	 * Create the panel.
	 */
	public LobbyPanel(LobbyController lobbyController) {
		this.lobbyController = lobbyController;
		Object[][] data = lobbyController.showUsers();
		setPreferredSize(new Dimension(350, 300));
		setBackground(new Color(157, 24, 31));
		String[] columns = new String[] { "Name", "speelstatus" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblLobby = new JLabel("Lobby");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 100));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		gbc_lblLobby.insets = new Insets(0, 0, 0, 1000);
		gbc_lblLobby.anchor = GridBagConstraints.WEST;
		gbc_lblLobby.gridx = 0;
		gbc_lblLobby.gridy = 1;
		add(lblLobby, gbc_lblLobby);
		playerList = new JTable(data, columns);
		playerList.setFont(new Font("Calibri", Font.BOLD, 30));
		playerList.setRowHeight(100);
		TableColumnModel columnModel = playerList.getColumnModel();
		playerList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
		playerList.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(0, 0, 0, 1000);	
		gbc_table.gridwidth = 3;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(playerList, gbc_table);
		
		

		JButton refreshBtn = new JButton("Refresh");	
		refreshBtn.setPreferredSize(new Dimension(200, 100));
		refreshBtn.setBackground(new Color(59, 89, 182));
		refreshBtn.setForeground(Color.BLACK);
		refreshBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_inviteBtn = new GridBagConstraints();
		gbc_inviteBtn.insets = new Insets(0,150, 0, 1000);
		
		gbc_inviteBtn.anchor = GridBagConstraints.CENTER;
		gbc_inviteBtn.gridx = 0;
		gbc_inviteBtn.gridy = 3;
		add(refreshBtn, gbc_inviteBtn);
		
		//finding

	JLabel lblFinding = new JLabel("Finding Players");
		lblFinding.setFont(new Font("Arial", Font.BOLD, 100));
		GridBagConstraints gbc_lblFinding = new GridBagConstraints();
		gbc_lblFinding.insets = new Insets(0, 0, 5, 5);
		gbc_lblLobby.anchor = GridBagConstraints.EAST;
		gbc_lblFinding.gridx = 1;
		gbc_lblFinding.gridy = 1;
		add(lblFinding, gbc_lblFinding);

		playerFinding = new JTable(data, columns);
		
		playerFinding = new JTable(data, columns);
		playerFinding.setFont(new Font("Calibri", Font.BOLD, 30));
		playerFinding.setRowHeight(100);
		TableColumnModel columnModel1 = playerFinding.getColumnModel();
		playerFinding.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		for (int i = 0; i < columnModel1.getColumnCount(); i++) {
		playerFinding.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 3;
		gbc_table_1.insets = new Insets(0, 0, 5, 4);
		gbc_lblLobby.anchor = GridBagConstraints.EAST;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 2;
		add(playerFinding, gbc_table_1);
		
		
		JButton inviteBtn = new JButton("Invite Players");	
		inviteBtn.setPreferredSize(new Dimension(200, 100));
		inviteBtn.setBackground(new Color(59, 89, 182));
		inviteBtn.setForeground(Color.BLACK);
		inviteBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_inviteBtn1 = new GridBagConstraints();
		gbc_inviteBtn1.insets = new Insets(0, 0, 0, 0);
		gbc_inviteBtn1.anchor = GridBagConstraints.CENTER;
		gbc_inviteBtn1.gridx = 1;
		gbc_inviteBtn1.gridy = 3;
		add(inviteBtn, gbc_inviteBtn1);
	}
	
	
	public void showLobby() {
		
	}

}
