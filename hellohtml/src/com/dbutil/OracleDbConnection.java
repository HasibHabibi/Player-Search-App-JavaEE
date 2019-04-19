package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbConnection {

	private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String oracle = "oracle.jdbc.OracleDriver";
		Class.forName(oracle);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "java2";
		String password = "mphasis";
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}
}
// Singleton Java class