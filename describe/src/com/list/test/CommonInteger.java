package com.list.test;

public class CommonInteger {
	
	private volatile int value=0;
	
	public final void increment() {
		value++;
	}
	
	public final int get() {
		return value;
	}
}