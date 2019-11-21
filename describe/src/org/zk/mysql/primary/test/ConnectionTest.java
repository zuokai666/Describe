package org.zk.mysql.primary.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//分布式环境下主键生成策略
//1.UUID
public class ConnectionTest {
	
	public static UUIDGenerator uuidGenerator = new UUIDGenerator();
	
	public static void main(String[] args) throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "d2p9bupt");
		Statement statement = connection.createStatement();
		statement.executeUpdate("delete from Person");
		int testConnection = 10;
		ThreadPoolExecutor executor=
					new ThreadPoolExecutor(30, 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		for(int i=0;i<testConnection;i++){
			try {
				InsertTask command = new InsertTask();
				command.setIdGenerator(uuidGenerator);
				executor.execute(command);
			} catch (RejectedExecutionException e) {
				e.printStackTrace();
				break;
			}
		}
		executor.shutdown();
	}
}