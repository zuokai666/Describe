package com.list.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Test3 {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		list.add(100);
		System.err.println(list.get(0));
		
		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.incrementAndGet();
		atomicInteger.get();
	}
}