package com.lock.speed.test;

public class D {
	
	public static void main(String[] args) {
		lock();
	}
	
	static int a=0;
	
    public static void lock() {
    	long f = System.currentTimeMillis();
        Thread[] threads=new Thread[50];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new Runnable() {
                
                @Override
                public void run() {
                    for(int i=0;i<100000;i++){
                    	a++;
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        long e = System.currentTimeMillis();
        System.out.println("ReentrantLock"+ (e - f));
    }
}