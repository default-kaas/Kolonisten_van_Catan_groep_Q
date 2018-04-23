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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Controller.LobbyController;

public class LobbyPanel extends JPanel implements ActionListener {

	private JTable invitedList;
	private JButton acceptBtn;
	private JButton rejectBtn;
	private JButton normalMode;
	private JButton advancedMode;
	private JButton SPELOPENNU;
	public LobbyController lobbyController;
	GridBagConstraints c;

	public LobbyPanel(LobbyFrame lobbyFrame, LobbyController lobbyController) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.getHeight() * 0.8);
		int width = (int) (screenSize.getWidth() * 0.8);
		this.setPreferredSize(new Dimension(width, height));

		this.setLayout(new GridBagLayout());

		this.lobbyController = lobbyController;

		lobbyTable();

		rejectAndAcceptButton();

		activeGames();

		newGameTitle();

		normalButton();

		advancedButton();

	}

	public void lobbyTable() {

		Object[][] data = lobbyController.showInvites();
		String[] columns = new String[] { "Spel id", "Uitdager" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblLobby = new JLabel("Uitnodiging");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		gbc_lblLobby.insets = new Insets(0, 0, 0, 0);
		gbc_lblLobby.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLobby.gridx = 0;
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
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(0, 0, 0, 0);
		// gbc_table.gridwidth = 1;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(invitedList, gbc_table);

	}

	public void activeGames() {

		Object[][] data = lobbyController.showUsers();
		String[] columns = new String[] { "Name", "speelstatus" };

		// setBackground(new Color(157, 24, 31));
		// String[] columns = new String[] { "Name", "speelstatus" };
		// GridBagLayout gridBagLayout = new GridBagLayout();
		// setLayout(gridBagLayout);

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
		gbc_table.insets = new Insets(0, 0, 0, 0);
		gbc_table.gridwidth = 1;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(invitedList, gbc_table);
	}

	public void rejectAndAcceptButton() {

		rejectBtn = new JButton("Weiger");
		rejectBtn.setPreferredSize(new Dimension(160, 50));
		rejectBtn.setBackground(new Color(59, 89, 182));
		rejectBtn.setForeground(Color.BLACK);
		rejectBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_rejectBtn = new GridBagConstraints();

		gbc_rejectBtn.anchor = GridBagConstraints.WEST;
		gbc_rejectBtn.gridx = 0;
		gbc_rejectBtn.gridy = 2;
		add(rejectBtn, gbc_rejectBtn);

		acceptBtn = new JButton("Accepteer");
		acceptBtn.setPreferredSize(new Dimension(160, 50));
		acceptBtn.setBackground(new Color(59, 89, 182));
		acceptBtn.setForeground(Color.BLACK);
		acceptBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_acceptBtn = new GridBagConstraints();
		gbc_acceptBtn.insets = new Insets(0, 0, 0, 0);
		gbc_acceptBtn.anchor = GridBagConstraints.WEST;
		gbc_acceptBtn.gridx = 0;
		gbc_acceptBtn.gridy = 3;
		add(acceptBtn, gbc_acceptBtn);
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
		normalMode.setPreferredSize(new Dimension(200, 100));
		normalMode.setBackground(new Color(59, 89, 182));
		normalMode.setForeground(Color.BLACK);
		normalMode.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_normalBtn = new GridBagConstraints();
		gbc_normalBtn.insets = new Insets(200, 0, 0, 0);
		gbc_normalBtn.anchor = GridBagConstraints.EAST;
		gbc_normalBtn.gridx = 3;
		gbc_normalBtn.gridy = 2;
		add(normalMode, gbc_normalBtn);

	}

	public void advancedButton() {

		advancedMode = new JButton("Geavanceerd");
		advancedMode.setPreferredSize(new Dimension(200, 100));
		advancedMode.setBackground(new Color(59, 89, 182));
		advancedMode.setForeground(Color.BLACK);
		advancedMode.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_advancedBtn = new GridBagConstraints();
		gbc_advancedBtn.insets = new Insets(0, 0, 0, 0);
		gbc_advancedBtn.anchor = GridBagConstraints.EAST;
		gbc_advancedBtn.gridx = 3;
		gbc_advancedBtn.gridy = 3;
		add(advancedMode, gbc_advancedBtn);
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == normalMode) {

		}

		if (a.getSource() == advancedMode) {

		}

		if (a.getSource() == rejectBtn) {

		}

		if (a.getSource() == acceptBtn) {

		}

	}

}
