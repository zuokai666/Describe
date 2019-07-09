package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class InsertManyTask implements Runnable{
	
	static HikariDataSource ds;
	
	static{
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("d2p9bupt");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		ds = new HikariDataSource(config);
	}
	
	@Override
	public void run() {
		try {
			Connection connection = ds.getConnection();
			testConnection(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void testConnection(Connection connection) throws SQLException {
		Statement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<300;i++){
				String s1 = UUID.randomUUID().toString();
				sb.append("('");
				sb.append(s1);
				sb.append("','");
				sb.append(s1);
				sb.append("','");
				sb.append(s1);
				sb.append("','");
				sb.append(s1);
				sb.append("','");
				sb.append(s1);
				sb.append("','");
				sb.append(s1);
				sb.append("')");
				sb.append(",");
			}
			String vv = sb.toString();
			String sql = "insert into tab_str(s1,s2,s3,s4,s5,s6) values" + vv.substring(0, vv.length()-1);
			int num = statement.executeUpdate(sql);
			connection.commit();
			System.out.println(Thread.currentThread().getName() + " commit success " + num);
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			statement.close();
			connection.close();
		}
	}
}