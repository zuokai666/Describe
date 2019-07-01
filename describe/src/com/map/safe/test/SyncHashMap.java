package com.map.safe.test;

import java.util.HashMap;

public class SyncHashMap {
	
	HashMap<Integer, Integer> map = new HashMap<>();
	
	public synchronized Integer get(Integer key) {
		return map.get(key);
	}
	
	public synchronized Integer put(Integer key, Integer value) {
		return map.put(key, value);
	}
}