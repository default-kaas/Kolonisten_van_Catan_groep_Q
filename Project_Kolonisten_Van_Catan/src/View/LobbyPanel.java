package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Controller.LobbyController;

public class LobbyPanel extends JPanel implements ActionListener {

	private JTable invitedList;
	private JTable Uitnodiging;
	private JButton acceptBtn;
	private JButton rejectBtn;
	private JButton normalMode;
	public JButton advancedMode;
	private JButton rejoin;
	private JButton refreshBtn;
	public LobbyController lobbyController;
	private LobbyFrame lobbyFrame;

	GridBagConstraints c;

	public LobbyPanel(LobbyFrame lobbyFrame, LobbyController lobbyController) {
		this.lobbyFrame = lobbyFrame;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.getHeight() * 0.8);
		int width = (int) (screenSize.getWidth() * 0.8);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(57, 121, 186));

		/*
		 * ImageIcon icon = new ImageIcon("/images/lobbyPanelBg"); JLabel thumb = new
		 * JLabel(); thumb.setIcon(icon); thumb.setPreferredSize(new Dimension(width,
		 * height)); this.add(thumb);
		 */
		this.setLayout(new GridBagLayout());

		this.lobbyController = lobbyController;
		// Row 1
		lobbyTable();

		rejectAndAcceptButton();

		// Row 2
		activeGames();

		rejoinButton();
		
		refreshButton();

		// row 3
		newGameTitle();

		normalButton();

		advancedButton();

	}

	public void lobbyTable() {

		Object[][] data = lobbyController.showInvites();
		// setBackground(new Color(157, 24, 31));
		String[] columns = new String[] { "Name", "speelstatus" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblLobby = new JLabel("Uitnodiging");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		gbc_lblLobby.insets = new Insets(0, 0, 0, 200);
		gbc_lblLobby.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLobby.gridx = 0;
		gbc_lblLobby.gridy = 0;
		add(lblLobby, gbc_lblLobby);

		Uitnodiging = new JTable(data, columns);
		Uitnodiging.setFont(new Font("Calibri", Font.BOLD, 30));
		Uitnodiging.setRowHeight(50);
		TableColumnModel columnModel = Uitnodiging.getColumnModel();
		Uitnodiging.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// loop to set the width of the table.
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			Uitnodiging.getColumnModel().getColumn(i).setPreferredWidth(100);
		}

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(50, 0, 0, 200);
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(Uitnodiging, gbc_table);
		Uitnodiging.setDefaultEditor(Object.class, null);

	}

	public void rejectAndAcceptButton() {

		rejectBtn = new JButton("Weiger");
		rejectBtn.setPreferredSize(new Dimension(160, 50));
		rejectBtn.setBackground(new Color(186, 56, 56));
		rejectBtn.setForeground(Color.BLACK);
		rejectBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		rejectBtn.addActionListener(this);
		GridBagConstraints gbc_rejectBtn = new GridBagConstraints();

		gbc_rejectBtn.anchor = GridBagConstraints.WEST;
		gbc_rejectBtn.gridx = 0;
		gbc_rejectBtn.gridy = 3;
		add(rejectBtn, gbc_rejectBtn);

		acceptBtn = new JButton("Accepteer");
		acceptBtn.setPreferredSize(new Dimension(160, 50));
		acceptBtn.setBackground(new Color(117, 186, 56));
		acceptBtn.setForeground(Color.BLACK);
		acceptBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		acceptBtn.addActionListener(this);
		GridBagConstraints gbc_acceptBtn = new GridBagConstraints();
		gbc_acceptBtn.insets = new Insets(0, 0, 0, 100);
		gbc_acceptBtn.anchor = GridBagConstraints.WEST;
		gbc_acceptBtn.gridx = 0;
		gbc_acceptBtn.gridy = 2;
		add(acceptBtn, gbc_acceptBtn);

	}

	public void activeGames() {

		Object[][] data = lobbyController.showUsers();

		String[] columns = new String[] { "Name", "speelstatus" };

		JLabel lblLobby = new JLabel("Actieve spellen");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		// title insets
		gbc_lblLobby.insets = new Insets(0, 0, 0, 0);
		gbc_lblLobby.anchor = GridBagConstraints.NORTH;
		gbc_lblLobby.gridx = 1;
		gbc_lblLobby.gridy = 0;
		add(lblLobby, gbc_lblLobby);
		invitedList = new JTable(data, columns);

		invitedList.setFont(new Font("Calibri", Font.BOLD, 30));
		invitedList.setRowHeight(50);
		TableColumnModel columnModel = invitedList.getColumnModel();
		invitedList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// loop to set the width of the table.
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			invitedList.getColumnModel().getColumn(i).setPreferredWidth(100);
		}

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.CENTER;
		// table insets
		gbc_table.insets = new Insets(50, 0, 0, 0);
		gbc_table.gridwidth = 1;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(invitedList, gbc_table);
		invitedList.setDefaultEditor(Object.class, null);
	}

	public void rejoinButton() {
		rejoin = new JButton("Naar Spel");
		rejoin.setPreferredSize(new Dimension(160, 50));
		rejoin.setBackground(new Color(117, 186, 56));
		rejoin.setForeground(Color.BLACK);
		rejoin.setFont(new Font("Calibri", Font.BOLD, 30));
		rejoin.addActionListener(this);
		GridBagConstraints gbc_rejectBtn = new GridBagConstraints();

		gbc_rejectBtn.anchor = GridBagConstraints.CENTER;
		gbc_rejectBtn.gridx = 1;
		gbc_rejectBtn.gridy = 2;
		add(rejoin, gbc_rejectBtn);
	}

	public void newGameTitle() {

		JLabel lblLobby = new JLabel("Spel crieëren");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lobbyTitle = new GridBagConstraints();
		gbc_lobbyTitle.gridx = 3;
		gbc_lobbyTitle.gridy = 0;
		gbc_lobbyTitle.anchor = GridBagConstraints.EAST;
		add(lblLobby, gbc_lobbyTitle);

	}

	public void normalButton() {

		normalMode = new JButton("Normaal");
		normalMode.setPreferredSize(new Dimension(200, 50));
		normalMode.setBackground(new Color(198, 155, 13));
		normalMode.setForeground(Color.BLACK);
		normalMode.setFont(new Font("Calibri", Font.BOLD, 30));
		normalMode.addActionListener(this);
		GridBagConstraints gbc_normalBtn = new GridBagConstraints();
		gbc_normalBtn.insets = new Insets(200, 200, 0, 0);
		gbc_normalBtn.anchor = GridBagConstraints.EAST;
		gbc_normalBtn.gridx = 3;
		gbc_normalBtn.gridy = 1;
		add(normalMode, gbc_normalBtn);

	}

	public void advancedButton() {

		advancedMode = new JButton("Geavanceerd");
		advancedMode.setPreferredSize(new Dimension(200, 50));
		advancedMode.setBackground(new Color(198, 155, 13));
		advancedMode.setForeground(Color.BLACK);
		advancedMode.setFont(new Font("Calibri", Font.BOLD, 30));
		advancedMode.addActionListener(this);
		GridBagConstraints gbc_advancedBtn = new GridBagConstraints();
		gbc_advancedBtn.insets = new Insets(0, 200, 0, 0);
		gbc_advancedBtn.anchor = GridBagConstraints.EAST;
		gbc_advancedBtn.gridx = 3;
		gbc_advancedBtn.gridy = 2;
		add(advancedMode, gbc_advancedBtn);
	}
	
	public void refreshButton() {
		refreshBtn = new JButton("REFRESH");
		refreshBtn .setPreferredSize(new Dimension(200, 50));
		refreshBtn .setBackground(new Color(198, 155, 13));
		refreshBtn .setForeground(Color.BLACK);
		refreshBtn .setFont(new Font("Calibri", Font.BOLD, 30));
		refreshBtn .addActionListener(this);
		GridBagConstraints gbc_refreshBtn  = new GridBagConstraints();
		gbc_refreshBtn.anchor = GridBagConstraints.CENTER;
		gbc_refreshBtn.insets = new Insets(100, 0, 0, 0);
		gbc_refreshBtn.gridx = 1;
		gbc_refreshBtn.gridy = 3;
		add(refreshBtn, gbc_refreshBtn);
	}

	public void advancedModeaddActionListener(ActionListener l) {
		advancedMode.addActionListener(l);
	}

	public JButton getButton() {
		return advancedMode;
	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == normalMode) {
			lobbyFrame.setContentPane(lobbyController.getInvitePanel());
		}

		if (a.getSource() == advancedMode) {
			lobbyFrame.setContentPane(lobbyController.getInvitePanel());
		}

		if (a.getSource() == rejectBtn) {
			int x = Uitnodiging.getSelectedRow();
			if (x == -1) { // If a user doesn't select a cell OR user selects a sell from a different table
				JOptionPane.showMessageDialog(this, "Selecteer een cel ", "Geen cel geselecteerd",
						JOptionPane.ERROR_MESSAGE);

			} else if (Uitnodiging.getValueAt(x, 0).equals(" Geen")) { // shows an error message if a user selects an
																		// empty cell (I.E cell with "GEEN GAME")
				JOptionPane.showMessageDialog(this, "Je kan de geselecteerde cel niet weigeren!", "ERROR!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				lobbyController.respondToInvite((int) Uitnodiging.getValueAt(x, 0), false);
				Uitnodiging.setValueAt(" Geen", x, 0);
				Uitnodiging.setValueAt(" game", x, 1);
			}

		}

		if (a.getSource() == acceptBtn) {
			int x = Uitnodiging.getSelectedRow();
			if (x == -1) { // If a user doesn't select a cell OR user selects a sell from a different table
				JOptionPane.showMessageDialog(this, "Selecteer een cel ", "Geen cel geselecteerd",
						JOptionPane.ERROR_MESSAGE);

			} else if (Uitnodiging.getValueAt(x, 0).equals(" Geen")) {
				JOptionPane.showMessageDialog(this, "Je kan de geselecteerde cel niet accepteren :<", "ERROR!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				lobbyController.respondToInvite((int) Uitnodiging.getValueAt(x, 0), true);
				Uitnodiging.setValueAt(" Geen", x, 0);
				Uitnodiging.setValueAt(" game", x, 1);
			}

		}

		if (a.getSource() == rejoin) {
			int x = invitedList.getSelectedRow();
			if (x == -1) {
				JOptionPane.showMessageDialog(this, "Selecteer een cel ", "Geen cel geselecteerd",
						JOptionPane.ERROR_MESSAGE);

			} else if (invitedList.getValueAt(x, 0).equals(" Geen")) {
				JOptionPane.showMessageDialog(this, "Je kan de geselecteerde cel niet joinen :<", "ERROR!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				lobbyFrame.dispose();
				lobbyController.joinOldGame((int) invitedList.getValueAt(x, 0));
			}

		}

	}

}
