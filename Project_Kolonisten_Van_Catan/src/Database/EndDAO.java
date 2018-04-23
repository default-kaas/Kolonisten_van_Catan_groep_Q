package Database;

import java.sql.Connection;

public class EndDAO {
	Connection m_Conn;

	public EndDAO(Connection db_conn) {
		m_Conn = db_conn;
	}
}
