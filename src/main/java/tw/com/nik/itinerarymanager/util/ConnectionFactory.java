package tw.com.nik.itinerarymanager.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		
		InitialContext initialContext = new InitialContext();
		DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/MSSQL");
		Connection conn = ds.getConnection();
		
		
		return conn;
		
	}
	
}
