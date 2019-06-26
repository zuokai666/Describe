package com.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 选择排序：算法不稳定
 * 
 * @author King
 *
 */
public class SelectSort {
	
	private static final Logger log = LoggerFactory.getLogger(SelectSort.class);
	
	public void sort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int largeIndex = 0;
			for(int j=0;j<arr.length-i;j++){
				if(arr[largeIndex] < arr[j]){
					largeIndex = j;
				}
			}
			if(largeIndex != arr.length-i-1){
				int temp = arr[largeIndex];
				arr[largeIndex] = arr[arr.length-i-1];
				arr[arr.length-i-1] = temp;
			}
			log.debug("{}-{}", i, Arrays.toString(arr));
		}
	}
}