package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConnectionPropeties;
public class ConnectDB {
	
	public static Connection connect() throws SQLException{
		Connection connect = DriverManager.getConnection(ConnectionPropeties.DBURL);	
		return connect;
	}
}

