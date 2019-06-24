package com.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.array.DynamicArray;

/**
 * 堆
 * 
 * 最大堆，最小堆，左式堆
 * 
 * 依赖于动态数组
 * 
 */
public class Heap<T> {
	
	public static final Logger log = LoggerFactory.getLogger(Heap.class);
	
	private DynamicArray<T> elements;
	
	private int size = 0;
	
	public Heap(int initialCapacity) {
		elements = new DynamicArray<>(initialCapacity);
	}
	
	public void add(T t){
		if(size == 0){
			elements.set(size, t);
			size++;
		}else {
			siftUp(size, t);
			size++;
		}
	}
	
	private void siftUp(int k, T t) {
		log.debug("上滤前:{}", elements);
		elements.set(k, t);
		log.debug("上滤后:{}", elements);
	}
}