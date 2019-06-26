package com.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插入排序：算法稳定
 * 
 * @author King
 *
 */
public class InsertSort {
	
	private static final Logger log = LoggerFactory.getLogger(InsertSort.class);
	
	public void sort(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=i;j>0;j--){
				if(arr[j] < arr[j-1]){//不加=，可以做到算法稳定
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			log.debug("{}-{}", i, Arrays.toString(arr));
		}
	}
}