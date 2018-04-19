package Controller;

import java.sql.SQLException;

import DatabaseConnect.DatabaseConnect;
import View.GUI;

public class MainClass {

	public static void main(String[] args) {
		SuperController superController = new SuperController();
		superController.CreateGUIController();
//		DatabaseConnect Test = new DatabaseConnect();
	}

}
