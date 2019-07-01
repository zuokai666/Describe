package com.aqs.countdownlatch.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	
	static ExecutorService executorService = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		try {
			long f = System.currentTimeMillis();
			CountDownLatch latch = new CountDownLatch(3);
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					new API().invoke();
					latch.countDown();
				}
			});
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					new API().invoke();
					latch.countDown();
				}
			});
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					new ErrorAPI().invoke();
					latch.countDown();
				}
			});
			latch.await(500, TimeUnit.MILLISECONDS);
			long e = System.currentTimeMillis();
			System.err.println("程序运行时间(ms):" + (e - f));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}