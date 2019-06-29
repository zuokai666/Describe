package com.lock.speed.test;

import java.util.concurrent.atomic.AtomicInteger;

public class B {

	public static void main(String[] args) {
		cas();
	}
	
	static AtomicInteger integer=new AtomicInteger(0);
    public static void cas() {
    	long f = System.currentTimeMillis();
        Thread[] threads=new Thread[50];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new Runnable() {
                
                @Override
                public void run() {
                    for(int i=0;i<100000;i++){
                        integer.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        long e = System.currentTimeMillis();
        System.out.println("AtomicInteger"+ (e - f));
    }
}