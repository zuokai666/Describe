package com.list.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {
	
	static AtomicInteger atomicInteger = new AtomicInteger();
	
	public static void main(String[] args) {
		int testConnection = 5;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		for(int i=0;i<testConnection;i++){
			try {
				executor.execute(new Runnable() {
					@Override
					public void run() {
						for(int i=0;i<10000;i++){
							atomicInteger.increment();
						}
					}
				});
			} catch (RejectedExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(atomicInteger.get());
	}
}