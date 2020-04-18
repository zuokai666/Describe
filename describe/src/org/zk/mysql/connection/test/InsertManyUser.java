package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class InsertManyUser implements Runnable{
	
	static HikariDataSource ds;
	
	static AtomicInteger integer = new AtomicInteger(1);
	
	
	static{
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("123456");
		config.setMaximumPoolSize(50);
		
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
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
			for(int i=0;i<100;i++){
				String addr = UUID.randomUUID().toString();
				sb.append("('");
				int id = integer.getAndIncrement();
				sb.append(id);
				sb.append("','");
				sb.append("左凯");
				sb.append("','");
				sb.append("25");
				sb.append("','");
				sb.append(addr);
				sb.append("','");
				sb.append(id);
				sb.append("','");
				sb.append(simpleDateFormat.format(new Date()));
				sb.append("','");
				sb.append(simpleDateFormat.format(new Date()));
				sb.append("')");
				sb.append(",");
			}
			String vv = sb.toString();
			String sql = "insert into user(id,name,age,address,accountId,create_time,update_time) values" + vv.substring(0, vv.length()-1);
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