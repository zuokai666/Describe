package com.lintcode._190710;

/**
 * 920. 会议室
 * 
 * @author King
 *
 */
public class Solution2 {
	
	public int searchInsert(int[] arr, int target) {
		if(target < arr[0]){
			return 0;
		}else if (arr[arr.length - 1] < target) {
			return arr.length;
		}else {
			return searchInsertInternal(target, arr, 0, arr.length - 1);
		}
    }
	
	private int searchInsertInternal(int k, int[] arr,int b, int e){
		if(e < b){
			return -1;
		}
		int m = (b + e) >> 1;
		if(arr[m] == k){
			return m;
		}else if(k < arr[m]){
			if(0 < m - 1 && arr[m - 1] < k){
				return m;
			}
			return searchInsertInternal(k, arr, b, m - 1);
		}else {
			return searchInsertInternal(k, arr, m + 1, e);
		}
	}
}