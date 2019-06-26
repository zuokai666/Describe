package com.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * n个数值选出最大m个数（3<m<n）的最小算法复杂度是O(n)
 * 
 * 利用快排的patition思想，基于数组的第k个数来调整，将比第k个数小的都位于数组的左边，
 * 比第k个数大的都调整到数组的右边，这样调整后，位于数组右边的k个数最大的k个数(这k个数不一定是排好序的）
 * 
 * 维持一个大小为m的数组，建立极小堆，时间复杂度为logm,
 * 然后遍历剩下的n-m个元素，若大于堆中最小值，则替换，替换完了进行堆调整。这样复杂度为nlogm。
 * 
 * @author king
 * @date 2019-06-24 22:44:31
 *
 */
public class QuickSort {
	
	private static Logger log = LoggerFactory.getLogger(QuickSort.class);
	
	public void sort(int[] arr,int i){
		int j=arr.length - 1;
		int pivot = arr[i];
		arr[i]=0;
		log.debug(Arrays.toString(arr));
		while(i < j){
			while((i < j) && (pivot <= arr[j])){
				j--;
			}
			arr[i]=arr[j];
			arr[j]=0;
			log.debug(Arrays.toString(arr));
			while((i < j) && (arr[i] <= pivot)){
				i++;
			}
			arr[j]=arr[i];
			arr[i]=0;
			log.debug(Arrays.toString(arr));
		}
		arr[i]=pivot;
		log.debug(Arrays.toString(arr));
	}
}