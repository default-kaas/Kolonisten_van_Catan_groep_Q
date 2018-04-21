package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import Controller.LobbyController;

public class LobbyPanel extends JPanel {

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
		int size = (int) (screenSize.getHeight());
		this.setPreferredSize(new Dimension(size, size / 2));

		this.setLayout(new GridBagLayout());

		this.lobbyController = lobbyController;
		
		SPELOPENNU = new JButton("SPEL OPEN NU!!");
		this.add(SPELOPENNU);
		SPELOPENNU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lobbyFrame.showGameScreen();
			}
			
		});
		
		Object[][] data = lobbyController.showUsers();
		setBackground(new Color(157, 24, 31));
		String[] columns = new String[] { "Name", "speelstatus" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblLobby = new JLabel("Uitnodiging");
		lblLobby.setFont(new Font("Arial", Font.BOLD, 80));
		GridBagConstraints gbc_lblLobby = new GridBagConstraints();
		gbc_lblLobby.insets = new Insets(0, 0, 0, 100);
		gbc_lblLobby.anchor = GridBagConstraints.WEST;
		gbc_lblLobby.gridx = 0;
		gbc_lblLobby.gridy = 1;
		add(lblLobby, gbc_lblLobby);
		invitedList = new JTable(data, columns);
		invitedList.setFont(new Font("Calibri", Font.BOLD, 30));
		invitedList.setRowHeight(100);
		TableColumnModel columnModel = invitedList.getColumnModel();
		invitedList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			invitedList.getColumnModel().getColumn(i).setPreferredWidth(250);
		}

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.WEST;
		gbc_table.insets = new Insets(0, 0, 0, 0);
		gbc_table.gridwidth = 3;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		add(invitedList, gbc_table);

		acceptBtn = new JButton("Accepteer");
		acceptBtn.setPreferredSize(new Dimension(200, 100));
		acceptBtn.setBackground(new Color(59, 89, 182));
		acceptBtn.setForeground(Color.BLACK);
		acceptBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_acceptBtn = new GridBagConstraints();
		gbc_acceptBtn.insets = new Insets(0, 0, 20, 0);

		gbc_acceptBtn.anchor = GridBagConstraints.CENTER;
		gbc_acceptBtn.gridx = 0;
		gbc_acceptBtn.gridy = 3;
		add(acceptBtn, gbc_acceptBtn);

		rejectBtn = new JButton("Weiger");
		rejectBtn.setPreferredSize(new Dimension(200, 100));
		rejectBtn.setBackground(new Color(59, 89, 182));
		rejectBtn.setForeground(Color.BLACK);
		rejectBtn.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_rejectBtn = new GridBagConstraints();
		gbc_rejectBtn.insets = new Insets(0, 0, 20, 400);

		gbc_rejectBtn.anchor = GridBagConstraints.CENTER;
		gbc_rejectBtn.gridx = 0;
		gbc_rejectBtn.gridy = 3;
		add(rejectBtn, gbc_rejectBtn);

		normalMode = new JButton("Normale spel crieëren");
		normalMode.setPreferredSize(new Dimension(400, 100));
		normalMode.setBackground(new Color(59, 89, 182));
		normalMode.setForeground(Color.BLACK);
		normalMode.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_normalBtn = new GridBagConstraints();
		gbc_normalBtn.insets = new Insets(200, 0, 0, 0);
		gbc_normalBtn.anchor = GridBagConstraints.CENTER;
		gbc_normalBtn.gridx = 1;
		gbc_normalBtn.gridy = 2;
		add(normalMode, gbc_normalBtn);

		normalMode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lobby openen

			}
		});

		advancedMode = new JButton("Geavanceerde spel crieëren");
		advancedMode.setPreferredSize(new Dimension(400, 100));
		advancedMode.setBackground(new Color(59, 89, 182));
		advancedMode.setForeground(Color.BLACK);
		advancedMode.setFont(new Font("Calibri", Font.BOLD, 30));
		GridBagConstraints gbc_advancedBtn = new GridBagConstraints();
		gbc_advancedBtn.insets = new Insets(0, 0, 0, 0);
		gbc_advancedBtn.anchor = GridBagConstraints.CENTER;
		gbc_advancedBtn.gridx = 1;
		gbc_advancedBtn.gridy = 2;
		add(advancedMode, gbc_advancedBtn);

		advancedMode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lobby openen

			}
		});
	}

}
