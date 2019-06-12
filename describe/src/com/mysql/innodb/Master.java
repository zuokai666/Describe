package com.mysql.innodb;

public class Master {
	
	public static void main(String[] args) {
		Master masterThread = new Master();
		masterThread.start();
	}
	
	public void start(){
		while(true){
			for(int i=0;i<10;i++){
				System.out.println("做每1秒的事情");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.err.println("做每10秒的事情");
		}
	}
}