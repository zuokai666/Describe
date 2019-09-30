package com.lintcode._190930;

public class Solution {

	public long intervalStatistics(int[] arr, int k) {
		if(arr == null || arr.length == 0){
			return -1L;
		}
		long result = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == 0){
				int temp = 0;
				for(int j=i;j<arr.length;j++){
					if(arr[j] == 1){
						temp++;
					}
					if(temp <= k){
						if(j == i){
							if(arr[i] == 0){
								result++;//就一个0的情况
							}else {
								//do nothing.
							}
						}else {
							if(arr[i] == 0 && arr[j] == 0){
								result++;
							}
						}
					}else {
						break;
					}
				}
			}else {
				//do nothing.直接跳过
			}
		}
		return result;
    }
}