package com.lintcode._190930;

public class Solution2 {
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 1, 0, 1, 1, 0};
		int k = 1;
		new Solution2().intervalStatistics(arr, k );
	}
	
	public long intervalStatistics(int[] arr, int k) {
		int left =0;
		int right = 0;
		long numOfOne = 0;
		long sum = 0;
		while(right < arr.length){
			if(arr[right] == 1){
				numOfOne++;
				right++;
				continue;
			}
			if(arr[left] == 1){
				numOfOne--;
				left++;
				continue;
			}
			while(k < numOfOne){
				if(arr[left] == 1){
					numOfOne--;
				}
				left++;
			}
			sum += right - left + 1 - numOfOne;
			right++;
		}
		return sum;
	}
}