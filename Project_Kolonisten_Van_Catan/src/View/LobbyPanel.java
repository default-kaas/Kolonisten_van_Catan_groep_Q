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
		String[] columns = new String[] { "Name" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblLobby = new JLabel("Lobby");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		gbc_lblLobby.insets = new Insets(0, 0, 5, 5);
		gbc_lblLobby.gridx = 0;
		gbc_lblLobby.gridy = 0;
		add(lblLobby, gbc_lblLobby);
		playerList = new JTable(data, columns);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.gridwidth = 3;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(playerList, gbc_table);

		JButton inviteBtn = new JButton("Invite");
		GridBagConstraints gbc_inviteBtn = new GridBagConstraints();
		gbc_inviteBtn.fill = GridBagConstraints.CENTER;
		gbc_inviteBtn.insets = new Insets(0, 0, 5, 0);
		gbc_inviteBtn.anchor = GridBagConstraints.SOUTH;
		gbc_inviteBtn.gridx = 1;
		gbc_inviteBtn.gridy = 2;
		add(inviteBtn, gbc_inviteBtn);

		JLabel lblFinding = new JLabel("Finding Players");
		lblFinding.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblFinding = new GridBagConstraints();
		gbc_lblFinding.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinding.gridx = 0;
		gbc_lblFinding.gridy = 4;
		add(lblFinding, gbc_lblFinding);

		playerFinding = new JTable(data, columns);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 3;
		gbc_table_1.insets = new Insets(0, 0, 5, 4);
		gbc_table_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 5;
		add(playerFinding, gbc_table_1);

	}

}
