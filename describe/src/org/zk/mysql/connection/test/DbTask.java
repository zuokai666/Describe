package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTask implements Runnable{
	
	@Override
	public void run() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "d2p9bupt");
			testConnection(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void testConnection(Connection connection) throws SQLException {
		Statement statement = null;
		//存在查询语句转义
		//ResultSet set = statement.executeQuery("show variables like 'innodb_version'");
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.executeUpdate("update person set version = version + 1 where id = '1'");
//			Thread.sleep(1 * 1000);
			connection.commit();
			System.out.println(Thread.currentThread().getName() + " commit success");
		} catch (Exception e) {
			connection.rollback();
		} finally {
			statement.close();
			connection.close();
			System.out.println(Thread.currentThread().getName() + " connection close");
		}
	}
}