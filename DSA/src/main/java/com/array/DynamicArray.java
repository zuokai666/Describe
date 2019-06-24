package com.array;

/**
 * 动态数组
 * 
 * 倍增扩容
 * 
 */
public class DynamicArray<T> {
	
	private Object[] elements;
	
	public DynamicArray(int initialCapacity) {
		elements = new Object[initialCapacity];
	}
}