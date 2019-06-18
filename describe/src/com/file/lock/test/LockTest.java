package com.file.lock.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class LockTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("D://123.txt", "rw");
		FileLock lock = null;
		try {
			lock = raf.getChannel().tryLock();
			if(lock.isValid()){
				System.err.println("占有文件");
				Thread.sleep(10 * 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(lock != null){
				lock.release();
			}
		}
		raf.close();
	}
}