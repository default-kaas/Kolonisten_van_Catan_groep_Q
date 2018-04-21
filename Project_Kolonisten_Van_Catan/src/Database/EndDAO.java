package Database;

import java.sql.Connection;

public class EndDAO {
	Connection m_Conn;

	public EndDAO(Connection db_conn) {

		try {
			m_Conn = db_conn;
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
