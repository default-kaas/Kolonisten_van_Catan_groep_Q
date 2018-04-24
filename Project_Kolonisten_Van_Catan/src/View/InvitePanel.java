package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controller.InviteController;

public class InvitePanel extends JPanel implements ActionListener {
	private JTable playerList;
	private JTable playerFinding;
	public InviteController inviteController;
	private TitledBorder myTitle;
	private BufferedImage myImage;
	private JButton refreshBtn;
	private JButton inviteBtn;
	private Object[][] data;
	private	Object[] data2;
	private	String[] column;
	private String[] column2;
	
	
	public InvitePanel(InviteController inviteController) {
		this.inviteController = inviteController;
//		setPreferredSize(new Dimension(350, 300));
		setBackground(new Color(244, 167, 66));
		column = new String[] { "Name", "speelstatus" };
		column2 = new String[] { "Name"};
		GridBagLayout gridBagLayout = new GridBagLayout();

		setLayout(gridBagLayout);

		// Set Page Title
		setTitle();

		// Set Left Title, Table & Buttons

		lobbyTitle();

		lobbyTable();

		lobbyButtons();

		// set Right Title, Table & Buttons

		inviteTitle();

		inviteTable();

		inviteButton();

	}

	public void setTitle() {
		myTitle = new TitledBorder("Nieuwe Spel");
		myTitle.setTitleFont(new Font("Ayuthaya", Font.BOLD, 80));
		myTitle.setTitleJustification(TitledBorder.CENTER);
		myTitle.setTitlePosition(TitledBorder.TOP);
		myTitle.setTitle("Nieuwe Spel");
		this.setBorder(myTitle);

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
		data = inviteController.showUsers();
		
		playerList = new JTable(data, column);
		playerList.setFont(new Font("Calibri", Font.BOLD, 30));
		playerList.setRowHeight(30);

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
	public void inviteTable() {
		data2 = inviteController.showInviteUsers();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("test",data2);
		playerFinding = new JTable(model);
		playerFinding.setFont(new Font("Calibri", Font.BOLD, 30));
		playerFinding.setRowHeight(30);
		TableColumnModel columnModel1 = playerFinding.getColumnModel();
		playerFinding.setRowHeight(30);
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


	public void lobbyButtons() {
		refreshBtn = new JButton();
		refreshBtn.setPreferredSize(new Dimension(200, 70));
		try {
			myImage = ImageIO.read(new File("images/Buttons/refresh.jpg"));
			refreshBtn.setIcon(new ImageIcon(myImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refreshBtn.setBackground(new Color(13, 150, 45));
		refreshBtn.setForeground(Color.BLACK);
		refreshBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		refreshBtn.addActionListener(this);
		GridBagConstraints gbc_inviteBtn = new GridBagConstraints();
		gbc_inviteBtn.insets = new Insets(0, 0, 80, 150);

		gbc_inviteBtn.anchor = GridBagConstraints.WEST;
		gbc_inviteBtn.gridx = 0;
		gbc_inviteBtn.gridy = 2;
		add(refreshBtn, gbc_inviteBtn);

	}
	

	public void inviteTitle() {
		JLabel lblFinding = new JLabel("Spelers uitnodigen");
		lblFinding.setFont(new Font("Arial", Font.BOLD, 50));
		GridBagConstraints gbc_lblFinding = new GridBagConstraints();
		gbc_lblFinding.insets = new Insets(0, 150, 80, 0);
		gbc_lblFinding.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFinding.gridx = 1;
		gbc_lblFinding.gridy = 0;
		add(lblFinding, gbc_lblFinding);
	}

	
	public void inviteButton() {
		inviteBtn = new JButton();
		try {
			myImage = ImageIO.read(new File("images/Buttons/invitePlayers.jpg"));
			inviteBtn.setPreferredSize(new Dimension(myImage.getWidth(), myImage.getHeight()));
			inviteBtn.setIcon(new ImageIcon(myImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inviteBtn.setBackground(new Color(13, 150, 45));
		inviteBtn.setForeground(Color.BLACK);
		inviteBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		inviteBtn.addActionListener(this);
		GridBagConstraints gbc_inviteBtn1 = new GridBagConstraints();
		gbc_inviteBtn1.insets = new Insets(0, 150, 80, 0);
		gbc_inviteBtn1.anchor = GridBagConstraints.EAST;
		gbc_inviteBtn1.gridx = 1;
		gbc_inviteBtn1.gridy = 2;
		add(inviteBtn, gbc_inviteBtn1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == refreshBtn) {

		}

		if (e.getSource() == inviteBtn) {

		}

	}

}