package com.aqs.countdownlatch.test;

public class ErrorAPI {
	
	public boolean invoke(){
		System.err.println("调取错误外部服务");
		int i = 1/0;
		System.err.println(i);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
}