package com.heap.test;

import com.heap.Heap2;

public class Heap2Test {

	public static void main(String[] args) {
		int[] arr = {0,5,4,3,2,1};
		new Heap2<>().siftDown(arr);
	}
}