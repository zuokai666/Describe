package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTask implements Runnable{
	
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
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.execute("select * from mytest");
			connection.commit();
			System.out.println(Thread.currentThread().getName() + " commit success");
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			statement.close();
			connection.close();
		}
	}
}