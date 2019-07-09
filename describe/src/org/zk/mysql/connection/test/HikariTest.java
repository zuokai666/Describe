package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariTest {
	
	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("d2p9bupt");
		
		HikariDataSource ds = new HikariDataSource(config);
		Connection connection = ds.getConnection();
		System.err.println(connection.getClass());
		connection.close();
		ds.close();
	}
}