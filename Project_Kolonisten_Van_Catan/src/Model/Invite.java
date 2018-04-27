package Model;

import java.sql.Connection;

import Database.InviteDAO;

public class Invite {
	private InviteDAO InviteDAO;
	private String username;
	private int idspel;
	private Integer[] volgnrs;

	public Invite(Connection db_conn, int idspel, String username) {
		this.idspel = idspel;
		this.username = username;
		InviteDAO = new InviteDAO(db_conn);
		volgnrs = new Integer[3];
	}

	public Object[][] showUsers() {
		return InviteDAO.getUserList(username, idspel);
	}

	public Object[][] showInviteUsers() {
		int i = InviteDAO.getRejectedVolgnr(idspel);
		if (i == -1) {
		} else {
			volgnrs[i - 2] = null;
		}
		return InviteDAO.getInviteUserList(username);
	}


	public void invitePlayer(String userName) {

		int i = 0;
		while (i < 2) {

			if (volgnrs[i] == null) {
				volgnrs[i] = 2;
				break;
			}
			i++;
		}
		i += 2;
		InviteDAO.invitePlayers(userName, idspel, i);

	}

	public int getNumberInvited() {
		// TODO Auto-generated method stub
		return InviteDAO.getNumberInvited(idspel);
	}


	public int getAcceptedPlayerAmount() {
		// TODO Auto-generated method stub
		return InviteDAO.getAcceptedPlayerAmount(idspel);
	}
	public int getSpelID() {
		return idspel;
	}
}
