package org.zk.mysql.connection.test;

import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConnectionTest {
	
	public static void main(String[] args) throws SQLException{
		int testConnection = 10000000;
		ThreadPoolExecutor executor=
					new ThreadPoolExecutor(30, 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		for(int i=0;i<testConnection;i++){
			try {
				executor.execute(new InsertManyTask());
			} catch (RejectedExecutionException e) {
				e.printStackTrace();
				break;
			}
		}
		executor.shutdown();
	}
}