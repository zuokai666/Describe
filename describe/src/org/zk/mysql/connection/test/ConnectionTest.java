package org.zk.mysql.connection.test;

import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConnectionTest {
	
	public static void main(String[] args) throws SQLException{
		int testConnection = 1000000;
		ThreadPoolExecutor executor=
					new ThreadPoolExecutor(30, 50, 30, TimeUnit.SECONDS, 
							new LinkedBlockingQueue<>());
		for(int i=0;i<testConnection;i++){
			try {
				executor.execute(new SelectTask());
			} catch (RejectedExecutionException e) {
				System.err.println("线程池拒绝提供服务");
				e.printStackTrace();
				break;
			}
//			System.out.println("线程池中线程数目："+executor.getPoolSize()+
//					"，队列中等待执行的任务数目："+executor.getQueue().size()+
//					"，已执行完的任务数目："+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}