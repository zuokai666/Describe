package org.zk.mysql.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * \xF0\x9F\x99\x8F
 * \xF0\x9F\x98\x80
 * \xF0\x9F\x92\x8C
 * 
 * @author King
 *
 */
public class ConnectionTest3 {
	
	public static void main(String[] args) throws SQLException{
		new ConnectionTest3().run();
	}
	
	public void run() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "d2p9bupt");
			Statement statement = null;
			try {
				connection.setAutoCommit(false);
				statement = connection.createStatement();
				String content = "🌹🍀🍎💰📱🌙🍁🍂🍃🌷💎🔪🔫🏀⚽⚡👄👍🔥";
				content = content.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
				System.out.println(content);
				statement.execute("insert into a (con)values('"+content +"')");
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