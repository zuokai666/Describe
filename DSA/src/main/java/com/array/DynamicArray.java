package com.array;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态数组
 * 
 * 倍增扩容
 * 
 */
public class DynamicArray<T> {
	
	public static final Logger log = LoggerFactory.getLogger(DynamicArray.class);
	
	private Object[] elements;
	
	private int size = 0;
	
	public DynamicArray(int initialCapacity) {
		elements = new Object[initialCapacity];
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index){
		return (T) elements[index];
	}
	
	public void set(int index, T element) {
        elements[index] = element;
    }
	
	public void add(T t){
		log.debug("开始:{}", Arrays.toString(elements));
		ensureCapacityInternal(size + 1);
		elements[size++] = t;
		log.debug("末尾:{}", Arrays.toString(elements));
	}
	
	private void ensureCapacityInternal(int minCapacity) {
		if(elements.length < minCapacity){
			int oldCapacity = elements.length;
			int newCapacity = oldCapacity << 1;//双倍增扩容
			if(newCapacity < minCapacity){
				newCapacity = minCapacity;
			}
			Object[] copy = new Object[newCapacity];
			System.arraycopy(elements, 0, copy, 0, oldCapacity);
			elements = copy;
			log.debug("扩容:{},大小:{}->{}", Arrays.toString(elements), oldCapacity, newCapacity);
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
}