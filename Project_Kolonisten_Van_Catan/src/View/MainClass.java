package View;

import java.sql.SQLException;

import DatabaseConnect.DatabaseConnect;

public class MainClass {

	public static void main(String[] args) {

		GUI Spel = new GUI();
		try {
			DatabaseConnect Test = new DatabaseConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
