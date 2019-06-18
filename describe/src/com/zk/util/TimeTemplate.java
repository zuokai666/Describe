package com.zk.util;

public class TimeTemplate {
	
	public static void count(Runnable task){
		long f = System.currentTimeMillis();
		task.run();
		long e = System.currentTimeMillis();
		System.err.println("程序运行时间:["+(e-f)+"]ms");
	}
}