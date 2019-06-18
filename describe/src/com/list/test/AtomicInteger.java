package com.list.test;

public class AtomicInteger {
	
	private volatile int value=0;
	
	public final void increment() {
		while(true){
			int current = get();
			int next = current + 1;
			if(compareAndSet(current, next)){
				return;
			}
		}
	}
	
	private boolean compareAndSet(int current, int next) {
		if(value == current){
			value = next;
			return true;
		}else {
			return false;
		}
	}
	
	public final int get() {
		return value;
	}
}