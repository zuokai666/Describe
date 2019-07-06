package com.zk.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		int threadNum = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
		for(int i=0;i<3;i++){
			executorService.execute(new Runnable() {
				
				@SuppressWarnings("unused")
				@Override
				public void run() {
					int i=0;
					System.err.println(Thread.currentThread().getName());
					while(true){
						i++;
					}
				}
			});
		}
	}
}