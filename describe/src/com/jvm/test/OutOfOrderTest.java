package com.jvm.test;

public class OutOfOrderTest {

	static int a = 0;
	static int b = 0;
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			a();
			a = 0;
			b = 0;
			x = 0;
			y = 0;
			Thread.sleep(10);
		}
	}

	private static void a() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				a = 1;
				x = b;
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				b = 1;
				y = a;
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		if(x ==1 && y == 0){
			
		}else if(x ==0 && y == 1){
			
		}else if(x ==1 && y == 1){
			
		}else {
			System.err.println("x=" + x + ",y=" + y);
		}
	}
}