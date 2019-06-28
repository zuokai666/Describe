package com.monitor.test;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
	}
	
	public static void test() {
		StringBuffer sb = new StringBuffer();
		sb.append("aaa");
		sb.append("bbb");
		sb.append("ccc");
	}
	
	public static void test2() {
		Integer lock = new Integer(0);
		synchronized (lock) {
			int a =0;
			int b = a + 1;
			a = b;
		}
	}
}