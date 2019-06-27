package com.sort.test;

import java.util.Arrays;

import com.heap.Heap;
import com.sort.BubbleSort;
import com.sort.InsertSort;
import com.sort.MergeSort;
import com.sort.ClassicalQuickSort;
import com.sort.SelectSort;
import com.sort.Sort;

@SuppressWarnings("unused")
public class SortTest {
	
	static int[] arr2 = {12,23,34,56,90,56,78,1,7,3,5};
	static int[] arr1 = {12,23,34,56,90,56,78,1,7,3,5};
	static int[] arr3 = {7, 9, 6, 12, 2, 1, 4, 3, 11, 5};
	static int[] arr4 = {4,3,2,1};
	static int[] arr5 = {5,3,8,2,6,9,4,11,1,7};
	
	public static void main(String[] args) {
//		new BubbleSort().sortV1(arr2);
//		new BubbleSort().sortV2(arr2);
//		new InsertSort().sort(arr1);		
//		new SelectSort().sort(arr1);
		
//		Heap heap = new Heap(3);
//		for(int i=0;i<arr3.length;i++){
//			heap.add(arr3[i]);
//		}
//		for(int i=0,n=heap.size();i<n;i++){
//			System.err.println(heap.delMax());
//		}
		
//		new MergeSort().sort(arr2);
//		System.err.println(Arrays.toString(arr2));
//		Sort.check(arr2);
		
		new ClassicalQuickSort().sort(arr5);
		Sort.check(arr5);
	}
}