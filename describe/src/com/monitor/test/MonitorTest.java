package com.monitor.test;

public class MonitorTest {

	public static void main(String[] args) {
		Integer lock = new Integer(0);
		synchronized (lock) {
			int a =0;
			int b = a + 1;
			a = b;
		}
	}
}