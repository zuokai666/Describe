package com.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public void sort1(int[] arr){
		System.err.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1] < arr[j]){//升序-窗口滑动
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}