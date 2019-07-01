package com.aqs.countdownlatch.test;

public class API {
	
	public boolean invoke(){
		System.out.println("调取外部服务");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
}