package com.wrr.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		RateLimiter rateLimiter = new RateLimiter();
		for(int i=0;i<3;i++){
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						if(rateLimiter.acquire(1, 1)){
							System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis() + " - 调用A接口");
							return;
						}else {
//							System.out.println(System.currentTimeMillis() + " - -1");
						}
					}
				}
			});
		}
	}
}