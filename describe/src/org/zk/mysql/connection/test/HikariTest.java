package org.zk.mysql.connection.test;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariTest {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(HikariTest.class);
	
	public static void main(String[] args) throws SQLException, InterruptedException {
		System.setProperty("com.zaxxer.hikari.housekeeping.periodMs", "10000");
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("d2p9bupt");
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(2);
		config.setMaxLifetime(5000);
		config.setIdleTimeout(5000);
		
		HikariDataSource ds = new HikariDataSource(config);
		ds.getConnection();
		ds.getConnection();
		ds.getConnection();
		ds.getConnection();
		Thread.sleep(444444444);
//		int i = 0;
//		while(true){
//			try {
//				System.err.println(ds.getConnection());
//				i++;
//				System.err.println(i);
//			} catch (Exception e) {
//				e.printStackTrace();
//				break;
//			}
//		}
		ds.close();
	}
}