package com.list.test;

import java.util.ArrayList;

public class Test6 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(2);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		
		int minCapacity = 2;
		int oldCapacity = 1;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity < minCapacity){
            newCapacity = minCapacity;
		}
		System.err.println(newCapacity);
	}
}