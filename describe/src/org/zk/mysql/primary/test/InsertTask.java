package org.zk.mysql.primary.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTask implements Runnable{
	
	private static ThreadLocal<Connection> connections = new ThreadLocal<>();
	
	private IdGenerator idGenerator;
	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	
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
			String no = idGenerator.generateId();
			String name = "1";
			String age = "1";
			statement.executeUpdate("insert into person(no,name,age) values('"+no+"','"+name+"','"+age+"')");
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