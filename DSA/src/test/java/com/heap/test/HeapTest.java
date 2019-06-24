package com.heap.test;

import com.heap.Heap;

public class HeapTest {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(2);
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
	}
}