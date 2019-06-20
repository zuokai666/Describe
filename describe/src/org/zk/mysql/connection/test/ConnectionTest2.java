package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionTest2 {
	
	public static void main(String[] args) throws SQLException{
		new ConnectionTest2().run();
	}
	
	public void run() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "d2p9bupt");
			Statement statement = null;
			try {
				connection.setAutoCommit(false);
				statement = connection.createStatement();
				statement.execute("select * from a where id = 1 for update");
				connection.commit();
				System.out.println(Thread.currentThread().getName() + " commit success ");
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			} finally {
				statement.close();
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}