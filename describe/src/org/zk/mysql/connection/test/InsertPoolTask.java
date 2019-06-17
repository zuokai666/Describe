package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class InsertPoolTask implements Runnable{
	
	static ThreadLocal<Connection> connections = new ThreadLocal<>();
	
	@Override
	public void run() {
		try {
			Connection _connection = null;
			if((_connection = connections.get()) == null){
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "d2p9bupt");
				connections.set(connection);
				_connection = connection;
			}
			testConnection(_connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void testConnection(Connection connection) throws SQLException {
		Statement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			String s1 = UUID.randomUUID().toString();
			String s2 = UUID.randomUUID().toString();
			String s3 = UUID.randomUUID().toString();
			String s4 = UUID.randomUUID().toString();
			String s5 = UUID.randomUUID().toString();
			String s6 = UUID.randomUUID().toString();
			statement.executeUpdate("insert into tab_str(s1,s2,s3,s4,s5,s6) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
			connection.commit();
			System.out.println(Thread.currentThread().getName() + " commit success " + connection.toString());
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			statement.close();
		}
	}
}