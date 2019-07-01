package com.map.safe.test;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockHashMap {
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	HashMap<Integer, Integer> map = new HashMap<>();
	
	public Integer get(Integer key) {
		lock.readLock().lock();
		try {
			return map.get(key);
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public Integer put(Integer key, Integer value) {
		lock.writeLock().lock();
		try {
			return map.put(key, value);
		} finally {
			lock.writeLock().unlock();
		}
	}
}