package com.heap;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一组记录排序码为(5 11 7 2 3 17),则利用堆排序方法建立的初始堆为(17 11 7 2 3 5)
 * 
 * 
 * 堆
 * 
 * 最大堆，最小堆，左式堆
 * 
 * 依赖于动态数组
 * 
 */
public class Heap2<T> {
	
	public static final Logger log = LoggerFactory.getLogger(Heap2.class);
	
	public void siftDown(int[] arr){
		int k = 0;
		while(k < arr.length){
			if(k * 2 + 1 < arr.length){
				if(k * 2 + 2 < arr.length){//左右
					int left = arr[k * 2 + 1];
					int right = arr[k * 2 + 2];
					if(arr[k]>=left && arr[k]>=right){
						break;
					}
					int nextK = left<right?k * 2 + 2:k * 2 + 1;
					int temp = arr[nextK];
					arr[nextK] = arr[k];
					arr[k] = temp;
					k=nextK;
				}else {//左
					int left = arr[k * 2 + 1];
					if(arr[k]>=left){
						break;
					}
					int nextK = k * 2 + 1;
					int temp = arr[nextK];
					arr[nextK] = arr[k];
					arr[k] = temp;
					k=nextK;
					break;
				}
			}else {//没有左右
				break;
			}
			System.err.println(Arrays.toString(arr));
		}
	}
}