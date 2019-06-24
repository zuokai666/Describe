package com.heap;

/**
 * 堆
 * 
 * 最大堆，最小堆，左式堆
 * 
 * 依赖于动态数组
 * 
 */
public class Heap<T> {
	
	private Object[] elements;
	
	private int size = 0;
	
	public Heap(int initialCapacity) {
		elements = new Object[initialCapacity];
	}
	
	public void inert(T t){
		
	}
}