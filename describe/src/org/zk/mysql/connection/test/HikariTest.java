package org.zk.mysql.connection.test;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariTest {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(HikariTest.class);
	
	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("d2p9bupt");
		
		HikariDataSource ds = new HikariDataSource(config);
		try {
			Thread.sleep(1000 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ds.close();
	}
}