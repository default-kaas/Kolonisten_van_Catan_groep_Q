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
		return InviteDAO.getInviteUserList(username);
	}


	public void invitePlayer(String userName) {
		int i = InviteDAO.getRejectedVolgnr(idspel);
		if (i == -1) {
		} else {
			volgnrs[i - 2] = null;
		}
		int x = 0;
		while (x < 2) {
			if (volgnrs[x] == null) {
				volgnrs[x] = 2;
				break;
			}
			x++;
		}
		x += 2;
		InviteDAO.invitePlayers(userName, idspel, x);

	}

	public int getNumberInvited() {
		// TODO Auto-generated method stub
		return InviteDAO.getNumberInvited(idspel);
	}


	public int getAcceptedPlayerAmount() {
		return InviteDAO.getAcceptedPlayerAmount(idspel);
	}
	public int getSpelID() {
		return idspel;
	}

	public void cancelGame() {
		InviteDAO.cancelGame(idspel);
	}
}
