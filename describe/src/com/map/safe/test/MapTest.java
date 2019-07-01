package com.map.safe.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
	
	static SyncHashMap syncHashMap = new SyncHashMap();
	
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	static ReadWriteLockHashMap readWriteLockHashMap = new ReadWriteLockHashMap();
	
	public static void main(String[] args) {
		long f = System.currentTimeMillis();
        Thread[] threads=new Thread[50];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new Runnable() {
                
                @Override
                public void run() {
                	boolean flag = true;
                    for(int i=0;i<10 * 10000;i++){
                        if(flag){
                        	map.get(1);
                        }else {
                        	map.put(1, 1);
						}
                        flag = !flag;
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        long e = System.currentTimeMillis();
        System.out.println("map(ms)： "+ (e - f));
	}
}