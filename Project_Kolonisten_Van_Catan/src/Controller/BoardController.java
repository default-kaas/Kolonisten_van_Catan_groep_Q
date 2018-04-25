package Controller;

import java.sql.Connection;

import Model.Game;

public class BoardController {
	private Game game;
	private Connection connection;
	
	public BoardController(Game game, Connection connection ) {
		this.game = game;
		this.connection = connection;
	}
	
	
	
}
