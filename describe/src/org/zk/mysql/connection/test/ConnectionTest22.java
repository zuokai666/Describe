package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ConnectionTest22 {
	
	public static void main(String[] args) throws SQLException{
		DataSource dataSource = new DriverDataSource("jdbc:mysql://localhost:3306/test", 
				"com.mysql.jdbc.Driver", "root", "d2p9bupt");
		new ConnectionTest22().run(dataSource);
	}
	
	public void run(DataSource dataSource) {
		try {
			Connection connection = null;
			try {
				connection = dataSource.getConnection();
				connection.setAutoCommit(false);
				Statement statement = connection.createStatement();
				statement.execute("select * from a where id = 1 for update");
				connection.commit();
				System.out.println(Thread.currentThread().getName() + " commit success ");
			} catch (Exception e) {
				System.err.println("1: " + e.getMessage());
				if(connection != null){
					connection.rollback();
				}
			} finally {
				if(connection != null){
					connection.close();
				}
			}
		} catch (SQLException e) {
			System.err.println("2: " + e.getMessage());
		}
	}
}