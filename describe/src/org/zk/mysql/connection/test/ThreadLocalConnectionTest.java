package org.zk.mysql.connection.test;

import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalConnectionTest {
	
	public static void main(String[] args) throws SQLException{
		ThreadPoolExecutor executor= new ThreadPoolExecutor(50, 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		for(int i=0;i<1000 * 10000;i++){
			try {
				executor.execute(new InsertPoolTask());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		executor.shutdown();
	}
}