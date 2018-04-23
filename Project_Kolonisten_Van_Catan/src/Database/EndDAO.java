package Database;

import java.sql.Connection;

public class EndDAO {
	Connection db_conn;

	public EndDAO(Connection db_conn) {
		this.db_conn = db_conn;
	}
}
